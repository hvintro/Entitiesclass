package com.example.android_ed1.entitiesclass.presentationlayer.androidextends.application;

import android.app.Application;

import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Asistencia;
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
// referecias globales
    private Evento evento;
    private Asistencia asistenciaActual;

    public PueAndroidApplication(){
        super();
        setEventos(new ArrayList<Evento>());
        setServicemaneger(new servicemaneger(this));
        evento = null;
        setAsistenciaActual(null);
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

    public void setServicemaneger(com.example.android_ed1.entitiesclass.model.servicelayer.manager.servicemaneger servicemaneger) {
        this.servicemaneger = servicemaneger;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Asistencia getAsistenciaActual() {
        return asistenciaActual;
    }

    public void setAsistenciaActual(Asistencia asistenciaActual) {
        this.asistenciaActual = asistenciaActual;
    }
}
