package com.example.android_ed1.entitiesclass.model.servicelayer.api;

import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Evento;

import java.text.ParseException;
import java.util.List;

/**
 * Created by android-ed1 on 02/05/2016.
 */
public interface IEventoService {

    List<Evento> createInitialLocalEventos() throws ParseException;

}