package com.example.android_ed1.entitiesclass.model.servicelayer.manager;

import com.example.android_ed1.entitiesclass.model.servicelayer.api.IEventoService;
import com.example.android_ed1.entitiesclass.model.servicelayer.implementation.EventoService;

/**
 * Created by android-ed1 on 02/05/2016.
 */
public class servicemaneger {
    //servicios
    private IEventoService eventoService;
    //inicialización gestor de servicios. Exponemos los servicuis al mundo
    public IEventoService getEventoService (){
        //hacemos el singleton, la referencia seguirá existiendo muentras exista el objeto
        if (eventoService == null){eventoService = new EventoService();}
        return eventoService;
    }
}
