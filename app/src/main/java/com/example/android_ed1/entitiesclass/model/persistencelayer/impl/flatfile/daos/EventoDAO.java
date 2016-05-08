package com.example.android_ed1.entitiesclass.model.persistencelayer.impl.flatfile.daos;

import android.content.Context;
import android.util.Log;

import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Evento;
import com.example.android_ed1.entitiesclass.model.busineslayer.entities.Participante;
import com.example.android_ed1.entitiesclass.model.persistencelayer.api.IEventoDao;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Created by android-ed1 on 02/05/2016.
 */
public class EventoDAO implements IEventoDao {

    private Context context;
    public String jeison;
    JSONObject jeisonobiect;

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

    @Override
    public Participante getparticipantebydorsal(String Dorsal) throws Exception {

        String json = null;
        try {

            InputStream is = context.getAssets().open("eventos.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();

        }


        try {
            JSONArray jeisonaznar= (JSONArray) new JSONTokener(json).nextValue();
            for(int i=0; i < jeisonaznar.length(); i++) {

                JSONObject jsonobject = jeisonaznar.getJSONObject(i);

                JSONArray allcorredores = jsonobject.getJSONArray("corredores");

                for (int j= 0; j < allcorredores.length();j++) {
                    JSONObject jsonobject2 = allcorredores.getJSONObject(j);
                    String dorsal = jsonobject2.getString("dorsal");

                    if (dorsal.equals(Dorsal)) {

                     //   Participante hemman = jsonobject2;
                        return new Gson().fromJson(jsonobject2.toString(), Participante.class);

                    }
                }

            }


        } catch (Exception e) {
            Log.d("Json excemption: ", e.toString());
            return null;
        }

        return null;
    }



}
