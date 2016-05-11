package com.example.android_ed1.entitiesclass.presentationlayer.listeners;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Asistencia;
import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Posicion;

import java.util.Date;

/**
 * Created by android-ed1 on 11/05/2016.
 */
public class geopositionlistener implements LocationListener {

    //INYECCION DE DEPENDENCIAS XQ NO PUEDO Obtener el app
    private Asistencia asistencia;

    public geopositionlistener(Asistencia asistencia){
        this.asistencia = asistencia;
    }

    @Override
    public void onLocationChanged(Location location) {

        Posicion posicion = new Posicion();
        posicion.setLatitud(location.getLatitude());
        posicion.setLongitud(location.getLongitude());
        posicion.setPresicion((int) location.getAccuracy());
        posicion.setFecha(new Date());

        asistencia.getRuta().add(posicion);
        Log.d("Ruta creacion",String.valueOf(asistencia.getRuta().size()));

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
