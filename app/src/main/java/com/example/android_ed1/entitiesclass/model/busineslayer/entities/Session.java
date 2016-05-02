package com.example.android_ed1.entitiesclass.model.busineslayer.entities;

import android.content.Entity;

import com.example.android_ed1.entitiesclass.model.busineslayer.entities.base.Entitybase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by android-ed1 on 27/04/2016.
 */
public class Session extends Entitybase {

    private Date fechainicio;
    private Date fechafin;
    private List<Asistencia> Asistencias;

    public Session(){
        fechafin = null;
        fechainicio = null;
        Asistencias = new ArrayList<Asistencia>();
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public List<Asistencia> getAsistencias() {
        return Asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        Asistencias = asistencias;
    }
}
