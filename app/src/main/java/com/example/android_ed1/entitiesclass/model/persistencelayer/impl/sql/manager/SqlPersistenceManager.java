package com.example.android_ed1.entitiesclass.model.persistencelayer.impl.sql.manager;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android_ed1.entitiesclass.model.persistencelayer.api.IEventoDao;

import com.example.android_ed1.entitiesclass.model.persistencelayer.impl.sql.daos.EventoDao;
import com.example.android_ed1.entitiesclass.model.persistencelayer.impl.sql.helpers.SQLiteDBHelper;
import com.example.android_ed1.entitiesclass.model.persistencelayer.manager.PersistenceManager;
import com.example.android_ed1.entitiesclass.utilitieslayer.AppUtils;

/**
 * Created by android-ed1 on 02/05/2016.
 */
public class SqlPersistenceManager extends PersistenceManager {

    private IEventoDao eventoDao;
    private SQLiteDBHelper dbHelper;
    private Context context;

    public SqlPersistenceManager (Context context){

        this.context = context;
        dbHelper = new SQLiteDBHelper(
                context,
                AppUtils.EVENTOS_DB,
                null,
                AppUtils.EVENTOS_DB_VERSION);

    }




    @Override
    public IEventoDao getEventoDAO() {

        if(eventoDao == null){
            eventoDao = new EventoDao(dbHelper);
        }

        return null;
    }
}
