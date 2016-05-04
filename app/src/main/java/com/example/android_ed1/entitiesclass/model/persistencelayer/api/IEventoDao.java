package com.example.android_ed1.entitiesclass.model.persistencelayer.api;

import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Evento;

import org.json.JSONException;

import java.util.List;

/**
 * Created by android-ed1 on 02/05/2016.
 */
public interface IEventoDao {

    void eventosSave(List<Evento> eventos) throws JSONException;
    Evento geteventobydorsal(String Dorsal) throws Exception;

}
