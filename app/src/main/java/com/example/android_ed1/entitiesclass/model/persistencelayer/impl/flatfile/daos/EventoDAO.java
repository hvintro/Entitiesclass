package com.example.android_ed1.entitiesclass.model.persistencelayer.impl.flatfile.daos;

import android.content.Context;

import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Evento;
import com.example.android_ed1.entitiesclass.model.persistencelayer.api.IEventoDao;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Created by android-ed1 on 02/05/2016.
 */
public class EventoDAO implements IEventoDao {

    private Context context;

    public EventoDAO(Context context) {
        this.context = context;
    }

    @Override
    public void eventosSave(List<Evento> eventos) throws JSONException {
        //grabarará dentro de la app la serialización de los eventos en texto plano

        /**
        *para serializar los objetos en java se haria así
         *
         */
        /*
        JSONObject obj = new JSONObject();
        obj.put("nombre", "tgrwetgwer");
        obj.put("nombre", "tgrwetgwer");
        obj.put("nombre", "tgrwetgwer");*/

        /*usando la libreria GSON que se añade desde el gradle es asin:*/


        // de cara al examen recordar que el sdk se toca desde el manifest aunque a efectors praacticos se hace desde el
        //gradel. EL maven es lom mismo que el gradle pero ams rustico

        Gson gson = new Gson();
        String eventosJSON = gson.toJson(eventos);
        OutputStreamWriter osw = null;

        //MODEPRIVADO machaca el contenido que existe, si hay dos modificando el mismo fichero el último que llega
        // es el que pisa ej contenido.Los otros modos estan deprecados.
        try {
            osw = new OutputStreamWriter(
                    context.openFileOutput("eventos.json",context.MODE_PRIVATE));
            osw.write(eventosJSON);
            osw.close();
        }catch (Exception e){
            throw new RuntimeException("Error al guarfar en disco");
        }

    }
}
