package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Documentos extends AppCompatActivity {

    public class PDFDoc {
        int id;
        String nombre,docruta;

        public int getId(){return id;}
        public void setId(int id){this.id = id;}
        public String getNombre(){return nombre;}
        public void setNombre(String nombre){this.nombre = nombre;}
        public String getDocruta(){return docruta;}
        public void setDocruta(String docruta){this.docruta = docruta;}
    }


    public class GridViewAdapter extends BaseAdapter {

        Context c;
        ArrayList<PDFDoc> pdfDocuments;

        public GridViewAdapter(Context c,ArrayList<PDFDoc>pdfDocuments){
            this.c = c;
            this.pdfDocuments=pdfDocuments;

        }

        @Override
        public int getCount() {
            return pdfDocuments.size();
        }

        @Override
        public Object getItem(int position) {
            return pdfDocuments.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if(view==null)
            {
                view = LayoutInflater.from(c).inflate(R.layout.documeto_model,viewGroup,false);
            }
            TextView txtname = view.findViewById(R.id.pdfnombre);

            final PDFDoc pdf =(PDFDoc) this.getItem(position);
            txtname.setText(pdf.getNombre());

            if(pdf.getDocruta()!=null ){
                Picasso.get();
            }else {
                Toast.makeText(c,"Imagen en blanco",Toast.LENGTH_LONG).show();
            }

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(c,pdf.getNombre(),Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(c,PDFActivity.class);
                    i.putExtra("PATH",pdf.getDocruta());
                    c.startActivity(i);
                }
            });

            return view;
        }
    }

    public class JSONDownloader {
        private static final String PDF_SITE_URL="http://ymarquez.webfactional.com/Archivos/";
        private final Context c;
        private GridViewAdapter adapter;

        public JSONDownloader(Context c){
            this.c=c;

        }

        public void retrieve(final GridView gv, final ProgressBar myProgressBar)
        {
            final ArrayList<PDFDoc>pdfDocuments=new ArrayList<>();
            myProgressBar.setIndeterminate(true);
            myProgressBar.setVisibility(View.VISIBLE);

            AndroidNetworking.get(PDF_SITE_URL)
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsJSONArray(new JSONArrayRequestListener() {
                        @Override
                        public void onResponse(JSONArray response) {
                            JSONObject jo;
                            PDFDoc p;
                            try {
                                for(int i=0;i<response.length();i++){
                                    jo=response.getJSONObject(i);

                                    int id=jo.getInt("documento_id");
                                    String name=jo.getString("documento_nombre");
                                    String url=jo.getString("documento_ruta");

                                    p=new PDFDoc();
                                    p.setId(id);
                                    p.setNombre(name);
                                    p.setDocruta(url);

                                    pdfDocuments.add(p);
                                }

                                adapter=new GridViewAdapter(c,pdfDocuments);
                                gv.setAdapter(adapter);
                                myProgressBar.setVisibility(View.GONE);
                            }catch (JSONException e){
                                myProgressBar.setVisibility(View.GONE);
                                Toast.makeText(c,"No se recive el archivo json"+e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }
                        @Override
                        public void onError(ANError anError) {
                            anError.printStackTrace();
                            myProgressBar.setVisibility(View.GONE);
                            Toast.makeText(c,"unsuccesfull"+anError.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentos);

        final GridView myGridView=findViewById(R.id.myGridView);
        final ProgressBar myProgresBar = findViewById(R.id.myProgressBar);
        new JSONDownloader(Documentos.this).retrieve(myGridView,myProgresBar);


    }

}
