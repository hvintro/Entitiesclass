package com.example.android_ed1.entitiesclass.model.busineslayer.entities;

import com.example.android_ed1.entitiesclass.model.busineslayer.entities.base.Entitybase;

import java.util.Date;

/**
 * Created by android-ed1 on 27/04/2016.
 */
public class Posicion extends Entitybase {

        private double latitud;
        private double longitud;
        private Date fecha;
        private double presicion;


    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPresicion() {
        return presicion;
    }

    public void setPresicion(double presicion) {
        this.presicion = presicion;
    }

}
