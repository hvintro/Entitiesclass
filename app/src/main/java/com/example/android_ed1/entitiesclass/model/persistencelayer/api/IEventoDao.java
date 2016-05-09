package com.example.android_ed1.entitiesclass.model.persistencelayer.api;

import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Evento;
import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Participante;

import org.json.JSONException;

import java.util.List;

/**
 * Created by android-ed1 on 02/05/2016.
 */
public interface IEventoDao {

    void eventosSave(List<Evento> eventos) throws JSONException;
    Participante getparticipantebydorsal (String Dorsal) throws Exception;
    Evento getEventoByDorsal(String dorsal);


}
