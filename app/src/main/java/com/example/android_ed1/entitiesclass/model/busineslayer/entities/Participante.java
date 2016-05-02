package com.example.android_ed1.entitiesclass.model.busineslayer.entities;

import com.example.android_ed1.entitiesclass.model.busineslayer.entities.base.Entitybase;

/**
 * Created by android-ed1 on 27/04/2016.
 */
public class Participante extends Entitybase {

    private String name;
    private String dorsal;
    private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDorsal() {
        return dorsal;
    }

    public void setDorsal(String dorsal) {
        this.dorsal = dorsal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Participante(){
        name = null;
        email = null;
        dorsal = null;

    }

}
