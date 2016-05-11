package com.example.android_ed1.entitiesclass.model.persistencelayer.impl.sql.daos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Evento;
import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Participante;
import com.example.android_ed1.entitiesclass.model.persistencelayer.api.IEventoDao;
import com.example.android_ed1.entitiesclass.model.persistencelayer.impl.sql.helpers.SQLiteDBHelper;
import com.example.android_ed1.entitiesclass.utilitieslayer.AppUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by android-ed1 on 11/05/2016.
 */
public class EventoDao implements IEventoDao {

    private SQLiteDatabase db = null;
    private SQLiteDBHelper sqLiteDBHelper = null;

    public EventoDao(SQLiteDBHelper sqLiteDBHelper){

        this.sqLiteDBHelper =sqLiteDBHelper;


    }

    @Override
    public void eventosSave(List<Evento> eventos) throws JSONException {
      /*
        Evento e = new Evento();
        e.getUuid();
        e.getInsertedDBDate();*/

        if(db == null || !db.isOpen()){
            db = sqLiteDBHelper.getWritableDatabase();
        }
        Gson gson = new Gson();
        String json;
        ContentValues contentValues;
        for (Evento evento:eventos){

            contentValues = new ContentValues();

            //Si nunca he guardado el objeto hacemos insert

            if(evento.getInsertedDBDate() == null){
                int _id=0;
                Cursor cursor = db.query(
                        "sqlite_sequence",
                        new String[]{"seq"},
                        "name=?",
                        new String[]{AppUtils.TABLA_EVENTOS},
                        null,
                        null,
                        null
                        );


                if (cursor.moveToNext()){
                    _id = cursor.getInt(cursor.getColumnIndex("seq"));
                }
                _id++;

                evento.setId(_id);
                evento.setInsertedDBDate(new Date());
                json = gson.toJson(evento);

                contentValues.put(AppUtils.TABLA_EVENTOS_EVENTO,json);

                db.insert(
                        AppUtils.TABLA_EVENTOS,
                        null,
                        contentValues
                );
            }else {
                //hacemos el update!!
                json = gson.toJson(evento);
                contentValues.put(AppUtils.TABLA_EVENTOS_EVENTO,json);
                db.update(
                        AppUtils.TABLA_EVENTOS,
                        contentValues,
                        AppUtils.TABLA_EVENTOS_ID +"=?",
                        new String[]{String.valueOf(evento.getId())}
                );
            }
        }

        if(db.isOpen()){
            db.close();
        }

    }

    @Override
    public Participante getparticipantebydorsal(String Dorsal) throws Exception {
        return null;
    }

    @Override
    public Evento getEventoByDorsal(String dorsal) {
       if(db == null || !db.isOpen()){
           db = sqLiteDBHelper.getReadableDatabase();
       }

        Cursor cursor = db.query(
                AppUtils.TABLA_EVENTOS,
                null,null,null,null,null,null,null);

        Gson gson = new Gson();
        Evento evento = null;
        boolean encontrado = false;


        while (cursor.moveToNext() && !encontrado){
            evento = gson.fromJson(
                    cursor.getString(cursor.getColumnIndex(AppUtils.TABLA_EVENTOS)),
                            new TypeToken<Evento>(){}.getType());
               for (Participante participante:evento.getCorredores()){
                   if (participante.getDorsal().equals(dorsal)){

                       evento.getCorredores().clear();
                       evento.getCorredores().add(participante);
                       encontrado = true;
                       break;
                   }
               }
        }

        cursor.close();

        return evento;

    }
}
