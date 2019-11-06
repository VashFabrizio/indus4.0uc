package com.example.vash.industria40uc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class IndustriaDB extends SQLiteOpenHelper {

    private static final String DB_NAME="db_industria.bd";
    private static final int VERSION_DB=1;
    private static final String TABLE_EVENTO="CREATE TABLE evento(" +
            "evento_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "evento_nombre TEXT,"+
            "evento_ponente TEXT,"+
            "evento_fecha NUMERIC," +
            "evento_hora NUMERIC," +
            "evento_lugar TEXT)";

    public IndustriaDB(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_EVENTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS evento");
        sqLiteDatabase.execSQL(TABLE_EVENTO);
    }

    public void insertarEvento()
    {
        SQLiteDatabase database=getWritableDatabase();
        Cursor cursor=database.rawQuery("SELECT*FROM evento",null);
        if(database!=null && cursor.getCount()==0)
        {
            database.execSQL("INSERT INTO evento(evento_nombre,evento_ponente,evento_fecha,evento_hora,evento_lugar) VALUES('Personal and Professional Development Challengers of Young Professionals in the Industry 4.0'," +
                    "'Lucía Pía Torres – IEEE Industry Applications Society – Argentina'," +
                    "'14/11/19'," +
                    "'9:00am'," +
                    "'Auditorio')");
            database.execSQL("INSERT INTO evento(evento_nombre,evento_ponente,evento_fecha,evento_hora,evento_lugar) VALUES('Improving Security in the Internet of Things (IoT) through Bio - Inspired Approaches'," +
                    "'Heena Rathore – Texas A&M University – Estados Unidos'," +
                    "'14/11/19'," +
                    "'10:15am'," +
                    "'Auditorio')");
            database.execSQL("INSERT INTO evento(evento_nombre,evento_ponente,evento_fecha,evento_hora,evento_lugar) VALUES('El ingeniero global y los desafíos de la Agenda 2030'," +
                    "'José Duran Talledo – Presidente del Consejo Andino del Institute of Electrical and Electronics Engineers (IEEE) – Perú'," +
                    "'14/11/19'," +
                    "'11:30am'," +
                    "'Auditorio')");
            database.execSQL("INSERT INTO evento(evento_nombre,evento_ponente,evento_fecha,evento_hora,evento_lugar) VALUES('La planificación territorial como base para constituir ciudades y territorios inteligentes'," +
                    "'Juan Pablo Serna Cardona – Universidad del Rosario / Eninco S.A – Colombia'," +
                    "'14/11/19'," +
                    "'12:15pm'," +
                    "'Auditorio')");
            database.execSQL("INSERT INTO evento(evento_nombre,evento_ponente,evento_fecha,evento_hora,evento_lugar) VALUES('La incorporación de la gestión del riesgo de desastres en el ordenamiento del territorio, para la construcción de ciudades inteligentes'," +
                    "'Nelson Alfonso Huertas – Universidad Nacional de Colombia Eninco S.A – Colombia'," +
                    "'14/11/19'," +
                    "'3:00pm'," +
                    "'Auditorio')");
            database.execSQL("INSERT INTO evento(evento_nombre,evento_ponente,evento_fecha,evento_hora,evento_lugar) VALUES('Propuesta de Arquitectura Empresarial para la Transformación Digital'," +
                    "'César Gallegos – Chair, Sección Perú del IEEE – Perú'," +
                    "'14/11/19'," +
                    "'3:45pm'," +
                    "'Auditorio')");
            database.execSQL("INSERT INTO evento(evento_nombre,evento_ponente,evento_fecha,evento_hora,evento_lugar) VALUES('Crowdsource in the age of Artificial Intelligence'," +
                    "'Italo Quispe Guerra – Google Product Expert – Perú'," +
                    "'14/11/19'," +
                    "'5:00pm'," +
                    "'Auditorio')");
            database.execSQL("INSERT INTO evento(evento_nombre,evento_ponente,evento_fecha,evento_hora,evento_lugar) VALUES('¿Cómo realizar una transformación cultural para lograr holismo en la organización?'," +
                    "'Jairo Vargas Bonilla – Former Vice President of Institute of Industrial and System Engineering (IISE) – Colombia'," +
                    "'14/11/19'," +
                    "'5:45pm'," +
                    "'Auditorio')");
            database.execSQL("INSERT INTO evento(evento_nombre,evento_ponente,evento_fecha,evento_hora,evento_lugar) VALUES('Remediación Ambiental en la Industria 4.0. Caso de estudio: Japón'," +
                    "'Jorge Ascencio Damián – Tohoku University – Japón'," +
                    "'15/11/19'," +
                    "'9:00am'," +
                    "'Auditorio')");
            database.execSQL("INSERT INTO evento(evento_nombre,evento_ponente,evento_fecha,evento_hora,evento_lugar) VALUES('Los nuevos materiales en la manufactura 4.0'," +
                    "'Ruth Manzanares Grados – Tecnológico de Monterrey – México'," +
                    "'15/11/19'," +
                    "'9:45am'," +
                    "'Auditorio')");
            database.execSQL("INSERT INTO evento(evento_nombre,evento_ponente,evento_fecha,evento_hora,evento_lugar) VALUES('Oportunidades del Análisis del Ciclo de Vida Ambiental ACV en la producción sostenible'," +
                    "'Edmundo Muñoz Alvear – Universidad Andrés Bello – Chile'," +
                    "'15/11/19'," +
                    "'11:00am'," +
                    "'Auditorio')");
            database.execSQL("INSERT INTO evento(evento_nombre,evento_ponente,evento_fecha,evento_hora,evento_lugar) VALUES('Territorios instantáneos, Chasquis 4.0'," +
                    "'Josep Cargol Noguer – Universidad Politécnica de Cataluña – España'," +
                    "'15/11/19'," +
                    "'11:45am'," +
                    "'Auditorio')");
            database.close();
        }
    }

    public List<Evento> mostrarEventosAgenda()
    {
        SQLiteDatabase database=getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT*FROM evento",null);
        List<Evento> eventos=new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do {
                eventos.add(new Evento(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                        cursor.getString(3),cursor.getString(4),cursor.getString(5)));
            }while (cursor.moveToNext());
        }
        return  eventos;
    }


    public List<Evento> mostrarEventos14N()
    {
        SQLiteDatabase database=getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT*FROM evento where evento_fecha='14/11/19'",null);
        List<Evento> eventos=new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do {
                eventos.add(new Evento(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                        cursor.getString(3),cursor.getString(4),cursor.getString(5)));
            }while (cursor.moveToNext());
        }
        return  eventos;
    }

    public List<Evento> mostrarEventos15N()
    {
        SQLiteDatabase database=getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT*FROM evento where evento_fecha='15/11/19'",null);
        List<Evento> eventos=new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do {
                eventos.add(new Evento(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                        cursor.getString(3),cursor.getString(4),cursor.getString(5)));
            }while (cursor.moveToNext());
        }
        return  eventos;
    }



}
