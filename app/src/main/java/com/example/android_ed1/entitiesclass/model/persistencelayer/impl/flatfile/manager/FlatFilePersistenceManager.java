package com.example.android_ed1.entitiesclass.model.persistencelayer.impl.flatfile.manager;

import android.content.Context;

import com.example.android_ed1.entitiesclass.model.persistencelayer.api.IEventoDao;
import com.example.android_ed1.entitiesclass.model.persistencelayer.impl.flatfile.daos.EventoDAO;
import com.example.android_ed1.entitiesclass.model.persistencelayer.manager.PersistenceManager;

/**
 * Created by android-ed1 on 02/05/2016.
 */
public class FlatFilePersistenceManager extends PersistenceManager {
    private IEventoDao eventoDao;
    private Context context;


    @Override
    public IEventoDao getEventoDAO() {

        if (eventoDao == null){
            eventoDao = new EventoDAO(context);
        }

        return eventoDao;
    }

    public  FlatFilePersistenceManager (Context context){
        this.context = context;
    }
}
