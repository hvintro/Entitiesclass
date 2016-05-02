package com.example.android_ed1.entitiesclass.presentationlayer.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android_ed1.entitiesclass.R;
import com.example.android_ed1.entitiesclass.model.servicelayer.manager.servicemaneger;
import com.example.android_ed1.entitiesclass.presentationlayer.androidextends.application.PueAndroidApplication;

import java.text.ParseException;

public class MainActivity extends AppCompatActivity {

    private PueAndroidApplication app;
    private servicemaneger servicemanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        app =  (PueAndroidApplication) getApplication();
        servicemanager = app.getServicemaneger();

        try {
            app.setEventos(servicemanager.getEventoService().createInitialLocalEventos());
        }catch (ParseException e){
            e.printStackTrace();
        }

        Toast.makeText(this,"hola",Toast.LENGTH_LONG).show();

    }
}

