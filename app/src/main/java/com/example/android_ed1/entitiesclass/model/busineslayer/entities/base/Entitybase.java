package com.example.android_ed1.entitiesclass.model.busineslayer.entities.base;

import java.util.Date;
import java.util.UUID;

/**
 * Created by android-ed1 on 27/04/2016.
 *
 * Clase base. es la clase que que llevará tot lo que es base para todas las clases anémicas
 *
 */
public abstract class Entitybase {
    public static final int ENTITY_UNSAVED_VALUE=-1;

    //identificador del objeto
    private UUID uuid;
    //id se pone para tener relación
    private int id;
    //date con la fecha de inserción en la db. sabemos si está insertado y cuando.
    private Date insertedDBDate;

    public Entitybase(){
        uuid = UUID.randomUUID();
        id = ENTITY_UNSAVED_VALUE;
        insertedDBDate = null;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Date getInsertedDBDate() {return insertedDBDate;}

    public void setInsertedDBDate(Date insertedDBDate) {this.insertedDBDate = insertedDBDate;}
}
