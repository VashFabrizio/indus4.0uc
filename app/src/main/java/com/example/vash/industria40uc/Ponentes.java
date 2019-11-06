package com.example.vash.industria40uc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ponentes extends AppCompatActivity {

    private ListView listView;
    private CustomAdapter customAdapter;

    public static final String TEXTO = "texto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ponentes);

        init();

        this.listView.setNestedScrollingEnabled(true);
        this.listView.setAdapter(customAdapter);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(position ==0)
                {
                    Intent a = new Intent(view.getContext(), DetallePonente_Heena.class);
                    startActivity(a);
                }

                if(position ==1)
                {
                    Intent b = new Intent(view.getContext(), DetallePonente_Lucia.class);
                    startActivity(b);
                }

                if(position ==2)
                {
                    Intent c = new Intent(view.getContext(), DetallePonente_Jorge.class);
                    startActivity(c);
                }
                if(position ==3)
                {
                    Intent d = new Intent(view.getContext(), DetallePonente_Ruth.class);
                    startActivity(d);
                }
                if(position ==4)
                {
                    Intent e = new Intent(view.getContext(), DetallePonente_Joseph.class);
                    startActivity(e);
                }
                if(position ==5)
                {
                    Intent f = new Intent(view.getContext(), DetallePonente_Juan.class);
                    startActivity(f);
                }

                if(position ==6)
                {
                    Intent g = new Intent(view.getContext(), DetallePonente_Jairo.class);
                    startActivity(g);
                }

                if(position ==7)
                {
                    Intent h = new Intent(view.getContext(), DetallePonente_Nelson.class);
                    startActivity(h);
                }

                if(position ==8)
                {
                    Intent i = new Intent(view.getContext(), DetallePonente_Edmundo.class);
                    startActivity(i);
                }

                if(position ==9)
                {
                    Intent j = new Intent(view.getContext(), DetallePonente_Cesar.class);
                    startActivity(j);
                }

                if(position ==10)
                {
                    Intent k = new Intent(view.getContext(), DetallePonente_Italo.class);
                    startActivity(k);
                }

                if(position ==11)
                {
                    Intent l = new Intent(view.getContext(), DetallePonente_Jose.class);
                    startActivity(l);
                }

            }
        });

    }

    private void init() {
        this.listView = findViewById(R.id.listViewPonentes);
        this.customAdapter = new CustomAdapter(this, getArrayList());
    }

    private String getEmoji(int unicode) {
        return new String(Character.toChars(unicode));
    }

    private ArrayList<ObjetoListView> getArrayList() {

        ArrayList<ObjetoListView> arrayList = new ArrayList<>();

        arrayList.add(new ObjetoListView("Heena Rathore  " +getEmoji(0x1F1EC)+getEmoji(0x1F1E7) , "Ph.D. Ciencias de la Computación. Científica - Universidad Texas",
                "UK", TEXTO, true, 0 , "", R.drawable.img_heena));

        arrayList.add(new ObjetoListView("Lucía Pía Torres "+getEmoji(0x1F1E6)+getEmoji(0x1f1f7), "Ing. electrónica - Universidad Nacional de Tucumán",
                "ARG", TEXTO, true, 0, "", R.drawable.img_lucia));

        arrayList.add(new ObjetoListView("Jorge Ascencio Damián " + getEmoji(0x1F1EF)+getEmoji(0x1F1F5), "Ing. de Medio Ambiente y Energía - Universidad de Tohoku",
                "JAP", TEXTO, true, 0, "", R.drawable.img_jorge));

        arrayList.add(new ObjetoListView("Ruth Manzanares Grados "+getEmoji(0x1f1f2)+getEmoji(0x1f1fd), "Mg.Ingeniería Automotriz - Tecnológico de Monterrey",
                "MEX", TEXTO, true, 0, "", R.drawable.img_rut));

        arrayList.add(new ObjetoListView("Josep Cargol Noguer " + getEmoji(0x1F1EA) +getEmoji(0x1F1F8),"Mg.Proyectos,Urbanismo e Historia-U. Politécnica de Catalunya",
                "ESP", TEXTO, true, 0, "", R.drawable.img_josep));

        arrayList.add(new ObjetoListView("Juan Pablo Serna Cardona "+getEmoji(0x1F1E8) +getEmoji(0X1F1F4),
                "Arq. y Mg. en Gestion Urbana - U. Piloto de Colombia",
                "COL", TEXTO, true, 0, "", R.drawable.img_juan));

        arrayList.add(new ObjetoListView("Jairo Vargas Bonilla"+getEmoji(0x1F1E8) +getEmoji(0X1F1F4),
                "Ing. Industrial, MBA Atlantic ",
                "COL", TEXTO, true, 0, "", R.drawable.img_jairo));

        arrayList.add(new ObjetoListView("Nelson Alfonso Huertas "+getEmoji(0x1F1E8) +getEmoji(0X1F1F4),
                "Geologo, Mg. en Ciencias",
                "COL", TEXTO, true, 0, "", R.drawable.img_nelson));

        arrayList.add(new ObjetoListView("Edmundo Muñoz Alvear "+getEmoji(0x1F1E8)+getEmoji(0x1F1F1),
                "Dr. Ingenieria Medioambiental",
                "CHI", TEXTO, true, 0, "", R.drawable.img_eduardo));

        arrayList.add(new ObjetoListView("César Gallegos "+getEmoji(0x1F1F5)+getEmoji(0x1F1EA),
                "Consultor Tecnologia, Ing. Electronico",
                "PER", TEXTO, true, 0, "", R.drawable.img_cesar));

        arrayList.add(new ObjetoListView("Italo Quispe Guerra "+getEmoji(0x1F1F5)+getEmoji(0x1F1EA),
                "Google Product Experts - Google Beta Tester",
                "PER", TEXTO, true, 0, "", R.drawable.img_italo));

        arrayList.add(new ObjetoListView("José Durán Talledo "+getEmoji(0x1F1F5)+getEmoji(0x1F1EA),
                "Ing. Electronico - UNMSM",
                "PER", TEXTO, true, 0, "", R.drawable.img_jose));

        return arrayList;
    }

}