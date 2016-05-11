package com.example.android_ed1.entitiesclass.presentationlayer.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Asistencia;
import com.example.android_ed1.entitiesclass.presentationlayer.androidextends.application.PueAndroidApplication;
import com.example.android_ed1.entitiesclass.presentationlayer.listeners.geopositionlistener;

/**
 * Created by android-ed1 on 11/05/2016.
 */
public class GeoPositionService extends Service {

    private LocationManager locationManager;
    private geopositionlistener geopositionlistener;

    @Override
    public void onCreate() {
        super.onCreate();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Asistencia asistencia = ((PueAndroidApplication) getApplication()).getAsistenciaActual();

        geopositionlistener = new geopositionlistener(asistencia);

        iniciarposicionameinto();

    }

    private void iniciarposicionameinto(){
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                5000, // cada 5 segundos
                0,  //      si se ha movido 0 metros se localizará
                geopositionlistener);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    @Override
    public void onDestroy() {

        locationManager.removeUpdates(geopositionlistener);
        super.onDestroy();
    }
}
