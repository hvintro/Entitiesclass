package com.example.android_ed1.entitiesclass.model.persistencelayer.manager;

import android.content.Context;

import com.example.android_ed1.entitiesclass.model.persistencelayer.api.IEventoDao;
import com.example.android_ed1.entitiesclass.model.persistencelayer.impl.flatfile.manager.FlatFilePersistenceManager;
import com.example.android_ed1.entitiesclass.model.persistencelayer.impl.rest.manager.RestPersistenceManager;
import com.example.android_ed1.entitiesclass.model.persistencelayer.impl.sql.manager.SqlPersistenceManager;
import com.example.android_ed1.entitiesclass.utilitieslayer.AppUtils;

/**
 * Created by android-ed1 on 02/05/2016.
 */
public abstract class PersistenceManager {

    public abstract IEventoDao getEventoDAO();

    public static PersistenceManager getPersistenceManager(
            AppUtils.PersistenceTechnologies persistenceTechnologies, Context context
    ){
        PersistenceManager persistenceManager = null;

        switch ( persistenceTechnologies){
            case FLAT_FILE:
                persistenceManager = new FlatFilePersistenceManager(context);
                break;
            case SQL:
                persistenceManager = new SqlPersistenceManager();
                break;
            case REST:
                persistenceManager = new RestPersistenceManager();
                break;
        }

        return persistenceManager;

    };


}
