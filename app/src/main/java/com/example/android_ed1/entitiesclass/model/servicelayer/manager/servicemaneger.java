package com.example.android_ed1.entitiesclass.model.servicelayer.manager;

import android.content.Context;
import android.widget.RelativeLayout;

import com.example.android_ed1.entitiesclass.model.persistencelayer.impl.flatfile.manager.FlatFilePersistenceManager;
import com.example.android_ed1.entitiesclass.model.persistencelayer.impl.rest.manager.RestPersistenceManager;
import com.example.android_ed1.entitiesclass.model.persistencelayer.impl.sql.manager.SqlPersistenceManager;
import com.example.android_ed1.entitiesclass.model.persistencelayer.manager.PersistenceManager;
import com.example.android_ed1.entitiesclass.model.servicelayer.api.IEventoService;
import com.example.android_ed1.entitiesclass.model.servicelayer.implementation.EventoService;
import com.example.android_ed1.entitiesclass.utilitieslayer.AppUtils;

/**
 * Created by android-ed1 on 02/05/2016.
 */
public class servicemaneger {
    //singletones de gestiones de persistencia

    private FlatFilePersistenceManager flatFilePersistenceManager;
    private RestPersistenceManager restPersistenceManager;
    private SqlPersistenceManager sqlPersistenceManager;
    private Context context;

    public servicemaneger(Context context)
    {
        this.context = context;

        flatFilePersistenceManager = (FlatFilePersistenceManager) PersistenceManager.getPersistenceManager(AppUtils.PersistenceTechnologies.FLAT_FILE,context);

        restPersistenceManager = (RestPersistenceManager) PersistenceManager.getPersistenceManager(AppUtils.PersistenceTechnologies.REST,context);

        sqlPersistenceManager = (SqlPersistenceManager) PersistenceManager.getPersistenceManager(AppUtils.PersistenceTechnologies.SQL,context);

    }

    //servicios
    private IEventoService eventoService;
    //inicialización gestor de servicios. Exponemos los servicuis al mundo
    public IEventoService getEventoService (){
        //hacemos el singleton, la referencia seguirá existiendo muentras exista el objeto
        if (eventoService == null){eventoService = new EventoService(
                flatFilePersistenceManager,
                restPersistenceManager,
                sqlPersistenceManager
        );}
        return eventoService;
    }
}
