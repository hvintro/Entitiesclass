package com.example.android_ed1.entitiesclass.presentationlayer.activities;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_ed1.entitiesclass.R;
import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Evento;
import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Participante;
import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Session;
import com.example.android_ed1.entitiesclass.model.servicelayer.manager.servicemaneger;
import com.example.android_ed1.entitiesclass.presentationlayer.androidextends.application.PueAndroidApplication;
import com.example.android_ed1.entitiesclass.utilitieslayer.AppUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private final long DELAY = 1000; // milliseconds
    private double seconds;
    private Button read;
    private ImageButton main_btn_start;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Boolean d = AppUtils.isAtributeValue();
        timer=new Timer();
        app =  (PueAndroidApplication) getApplication();
        servicemanager = app.getServicemaneger();

        try {app.setEventos(servicemanager.getEventoService().createInitialLocalEventos());
        }catch (ParseException e){e.printStackTrace();}

        main_btn_start = (ImageButton) findViewById(R.id.main_btn_start);
        main_btn_start.setTag("Start");
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

        main_btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (main_btn_start.getTag().equals("Start")) {
                    main_btn_start.setTag("Stop");
                    main_btn_start.setBackgroundResource(R.drawable.stopbutton);

                    app.setAsistenciaActual(servicemanager.getEventoService().addCurrentAssitenciaToEvent(app.getEvento()));

                    //4 - Se ha decidido hacer en el evento service
                   /*
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                    Calendar cal = Calendar.getInstance();

                    try {
                        Evento evento = app.getServicemaneger().getEventoService().getEventobydorsal2(searched.getText().toString());
                        Session s = new Session();

                        for (Session s1 : evento.getSesiones()) {

                            if (cal.getTime().after(s1.getFechainicio()) && cal.getTime().before(s1.getFechafin()) ){


                            }

                        }
                    }catch (Exception e){
                        Log.e("Fat32 Error", e.toString());
                    }
                */

                } else {
                    main_btn_start.setTag("Start");
                    main_btn_start.setBackgroundResource(R.drawable.startbutton);


                }
            }
        });




        searched.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

             /*   Calendar c = Calendar.getInstance();
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
                }, DELAY);*/
                timer.cancel();
                timer = new Timer();

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                       new EventosAsincrono().execute(app,searched.getText().toString(),main_btn_start);
                    }
                },DELAY);


            }
        });


        //trying call eventoservice method

        //Todo: hacer esto, luego tratarlo como si fuera una llamada asincrona y luego cuando acabe esta llamafa tratar de pintar un boton

        read = (Button) findViewById(R.id.Readbutton);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Participante  hola;

               /* new Thread(new Runnable() {
                    public void run() {
                        Participante hola = app.getServicemaneger().getEventoService().getEventobydorsal("00004");

                }).start();

                    Toast.makeText(MainActivity.this,hola.getEmail().toString(),Toast.LENGTH_SHORT).show();*/
            }
        });




    }
}

class EventosAsincrono extends AsyncTask<Object, Object, Evento>{

    private PueAndroidApplication app=null;
    private ImageButton main_btn_start = null;

    @Override
    protected Evento doInBackground(Object... params) {

        app = (PueAndroidApplication) params[0];
        String dorsal = (String) params[1];
        main_btn_start = (ImageButton) params[2];
        try {

            Evento evento = app.getServicemaneger().getEventoService().getEventobydorsal2(dorsal);
            app.setEvento(evento);
            return evento;

        }catch (Exception e){

        }
        return null;
    }

    //Accediendo a la ui en post execute asincrono
    protected void onPostExecute(Evento evento){
        super.onPostExecute(evento);

        if(evento != null){
            main_btn_start.setVisibility(View.VISIBLE);
        }

    }

}

