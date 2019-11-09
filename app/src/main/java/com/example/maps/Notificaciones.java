package com.example.maps;

import android.app.Notification;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
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

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Notificaciones extends AppCompatActivity {
    private RequestQueue queue;
    private int count = 0 ;
    public boolean nointer ;
    private TableLayout tableLayout;
    private List<String> MensajesList = new ArrayList<>() ;
    private List<String> RemoveList = new ArrayList<>() ;
    public Timer timer;

    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);
        timer =  new Timer();
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
                            Toast.makeText(Notificaciones.this,"CONECTESE A INTERNET", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                            nointer = true ;

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("net",error.toString());
                        timer.cancel();
                        finish();
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
                    Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_1_ID)
                            .setSmallIcon(R.drawable.icon)
                            .setContentTitle(evento_nombre)
                            .setContentText(notificacion_mensaje)
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_EVENT)
                            .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 })
                            .setLights(Color.GREEN, 30000,3000)
                            .build();
                    notificationManager.notify(1,notification);
                }
            }
            count ++;
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            nointer = true ;
        }

    }

    public void ValidateNet()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            obtenerNotificaciones();
        }
    }

    public void setTimer()
    {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                ValidateNet();
            }
        };
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
}
