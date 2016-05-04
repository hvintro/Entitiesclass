package com.example.android_ed1.entitiesclass.presentationlayer.activities;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_ed1.entitiesclass.R;
import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Evento;
import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Participante;
import com.example.android_ed1.entitiesclass.model.servicelayer.manager.servicemaneger;
import com.example.android_ed1.entitiesclass.presentationlayer.androidextends.application.PueAndroidApplication;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private PueAndroidApplication app;
    private servicemaneger servicemanager;
    private EditText searched;
    private TextView resulttv;
    private String search;
    private String result;
    private List<Evento> specialEvents;
    private Button button;
    private Timer timer;
    private final long DELAY = 5000; // milliseconds
    private double seconds;


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



        searched = (EditText) findViewById(R.id.main_etDorsal);
        resulttv = (TextView) findViewById(R.id.results);

        search = searched.getText().toString();

        specialEvents = new ArrayList<Evento>();

        specialEvents = app.getEventos();


        button = (Button) findViewById(R.id.buton) ;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Evento evento: specialEvents){
                    for ( Participante corredores : evento.getCorredores()){
                        if (corredores.getDorsal().equals(search)){
                            resulttv.setText(corredores.getDorsal() + " " + corredores.getEmail() + " " + corredores.getName());
                        }
                    }
                }
            }
        });

        timer=new Timer();



        searched.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

                Calendar c = Calendar.getInstance();
                double secondary = seconds;
                seconds = c.get(Calendar.SECOND);

                result = s.toString();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (Evento evento : specialEvents) {
                            for (Participante corredores : evento.getCorredores()) {
                                if (corredores.getDorsal().toString().equals(result)) {
                                    resulttv.setText(corredores.getDorsal() + " " + corredores.getEmail() + " " + corredores.getName());
                                }
                            }
                        }
                    }
                }, DELAY);

            }
        });


        //trying call eventoservice method

        //Todo: hacer esto, luego tratarlo como si fuera una llamada asincrona y luego cuando acabe esta llamafa tratar de pintar un boton

        Evento hola = app.getServicemaneger().getEventoService().getEventobydorsal("00005");


    }
}

