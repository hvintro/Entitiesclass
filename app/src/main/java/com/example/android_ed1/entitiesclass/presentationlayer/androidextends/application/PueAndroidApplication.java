package com.example.android_ed1.entitiesclass.presentationlayer.androidextends.application;

import android.app.Application;

import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Evento;

import java.util.ArrayList;
import java.util.List;
import com.example.android_ed1.entitiesclass.model.servicelayer.manager.servicemaneger;

/**
 * Created by android-ed1 on 02/05/2016.
 */
public class PueAndroidApplication extends Application{

    private List<Evento> eventos;
    private servicemaneger servicemaneger;

    public PueAndroidApplication(){
        super();
        eventos = new ArrayList<Evento>();
        servicemaneger = new servicemaneger();
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public servicemaneger getServicemaneger() {
        return servicemaneger;
    }
}
