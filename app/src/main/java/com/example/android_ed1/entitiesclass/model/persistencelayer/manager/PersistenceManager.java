package com.example.android_ed1.entitiesclass.model.persistencelayer.manager;

import com.example.android_ed1.entitiesclass.model.persistencelayer.api.IEventoDao;

/**
 * Created by android-ed1 on 02/05/2016.
 */
public abstract class PersistenceManager {

    public abstract IEventoDao getEventoDAO();

}
