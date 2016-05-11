package com.example.android_ed1.entitiesclass.utilitieslayer;

import android.support.annotation.MainThread;

import com.example.android_ed1.entitiesclass.cAnnotation;
import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Evento;
import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Session;
import com.example.android_ed1.entitiesclass.presentationlayer.activities.MainActivity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by android-ed1 on 02/05/2016.
 */
public abstract class AppUtils {

    public static enum PersistenceTechnologies{FLAT_FILE,REST,SQL}

    public static boolean isAtributeValue(){
        try {

            Class cls = Class.forName("com.example.android_ed1.entitiesclass.model.busineslayer.entities.Evento");
            Annotation[] fiaeld = cls.getDeclaredAnnotations();
            Field[] fieltr = cls.getFields();

          /*  for(Annotation An : fiaeld){
                //String feld = An.getClass()
            }

            for (Field In : fieltr){
                Annotation[] annotation = In.getDeclaredAnnotations();

            }*/

            for(Field field : cls.getDeclaredFields()){
                Class type = field.getType();
                String name = field.getName();
                Annotation[] annotations = field.getDeclaredAnnotations();

                for (Annotation ac : annotations){
                    if (ac.toString().equals("@com.example.android_ed1.entitiesclass.model.busineslayer.entities.macundra()")){

                        boolean ec = false;
                    }
                    String hey = ac.toString();

                }

            }

            return true;

        }catch (Exception e) {
            return true;
        }

    }

    public final static String  EVENTOS_DB = "eventosDB";
    public final static int EVENTOS_DB_VERSION = 1;
    public final static String TABLA_EVENTOS = "eventos";
    public final static String TABLA_EVENTOS_ID = "_id";
    public final static String TABLA_EVENTOS_EVENTO = "evento";
}
