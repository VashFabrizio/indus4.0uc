package com.example.vash.industria40uc;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Notificaciones extends AppCompatActivity {
    private RequestQueue queue;
    private int count = 0 ;
    private TableLayout tableLayout;
    private List<String> MensajesList = new ArrayList<>() ;
    private List<String> RemoveList = new ArrayList<>() ;

    private NotificationManagerCompat  notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);

        notificationManager = NotificationManagerCompat.from(this);
        queue = Volley.newRequestQueue(this );
        tableLayout=findViewById(R.id.tableLayout);
        obtenerNotificaciones();

        setTimer();

    }
    private void obtenerNotificaciones() {

        String url= "http://ymarquez.webfactional.com/serviciosRest/controladores/read_notification.php";
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray Array = response.getJSONArray("Notificaciones");

                            JSONArray newArray = validateState(Array);
                            setData(newArray);
                        } catch (JSONException e) {
                            Toast.makeText(Notificaciones.this, e.toString(), Toast.LENGTH_SHORT).show();
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Notificaciones.this, error.toString() , Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(request);
    }

    public void setData(JSONArray array){
        try {

            IndustriaDB db=new IndustriaDB(this);
            SQLiteDatabase conexion = db.getReadableDatabase();
            String mQuery = "SELECT evento_nombre FROM evento WHERE evento_id = ?";

            List<Evento> eventoList = db.mostrarEventosAgenda();
            String eventos =eventoList.get(1).getNombre();
            for (int i = 0 ; i < array.length() ; i++)
            {
                View tableRow = LayoutInflater.from(this).inflate(R.layout.table_item,null,false);
                TextView evento  =  tableRow.findViewById(R.id.evento);
                TextView mensaje  =  tableRow.findViewById(R.id.mensaje);

                JSONObject a = array.getJSONObject(i);
                String notificacion_id = a.getString("notificacion_id");
                String eveto_id = a.getString("evento_id");

                String[] selectionArgs = {eveto_id};
                Cursor c = conexion.rawQuery(mQuery, selectionArgs);

                c.moveToFirst();
                String evento_nombre = c.getString(0);

                String notificacion_mensaje = a.getString("notificacion_mensaje");

                evento.setText(evento_nombre);
                mensaje.setText(notificacion_mensaje);

                Boolean valor = validate(notificacion_id);
                if(!valor){
                    tableLayout.addView(tableRow,i);
                    MensajesList.add(notificacion_id);
                }
                if(!valor && count >= 1){
                    Intent intent = new Intent(this,Notificaciones.class);
                    intent.setAction("ACTION_SHOW_BACKUP_FRAGMENT");
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    PendingIntent contentIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
                    Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_1_ID)
                            .setSmallIcon(R.drawable.icon)
                            .setContentTitle(evento_nombre)
                            .setContentText(notificacion_mensaje)
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_EVENT)
                            .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 })
                            .setColor(Color.YELLOW)
                            .setContentIntent(contentIntent)
                            .setAutoCancel(true)
                            .setOnlyAlertOnce(true)
                            .build();
                    notificationManager.notify(1,notification);
                }
            }
            count ++;
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }

    }


    public void setTimer()
    {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                obtenerNotificaciones();
            }
        };

        Timer timer =  new Timer();
        timer.scheduleAtFixedRate(timerTask,10000,3000);

    }

    public boolean validate(String id)
    {
        for ( String str: MensajesList)
        {
            if (str.trim().contains(id))
            return true;
        }
        return false;
    }
    public boolean validateRemove(String remove)
    {
        for ( String str: RemoveList)
        {
            if (str.trim().contains(remove))
                return true;
        }
        return false;
    }
    public JSONArray validateState(JSONArray array)
    {
        JSONArray nuevoArray = new JSONArray();

        for (int i = 0 ; i < array.length() ; i++)
        {
            try {
                JSONObject a = array.getJSONObject(i);
                String state = a.getString("notificacion_estado");
                String id = a.getString("notificacion_id");
                    if (state.equals("0"))
                    {
                        if(!validateRemove(id))
                        {
                            RemoveList.add(id);
                            if (tableLayout.getChildCount() > 2) tableLayout.removeViewAt(i);
                        }
                    }
                    else
                    {
                        nuevoArray.put(a);
                    }
                }

            catch (Exception e){
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        return nuevoArray ;
    }


    @Override
    protected void onPause() {
        super.onPause();
        setTimer();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }
}
