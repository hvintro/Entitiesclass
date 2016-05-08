package com.example.android_ed1.entitiesclass.model.busineslayer.entities;

import com.example.android_ed1.entitiesclass.cAnnotation;
import com.example.android_ed1.entitiesclass.model.busineslayer.entities.base.Entitybase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by android-ed1 on 27/04/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@interface macundra{}
public class Evento extends Entitybase {
    @macundra()
    private String nombre;
    private String descripcion;
    private int numeroplazas;
    private List<Participante> corredores;
    private List<Session> Sesiones;

    public Evento(){
        setNombre(null);
        setDescripcion(null);
        setNumeroplazas(0);
        setCorredores(new ArrayList<Participante>());
        setSesiones(new ArrayList<Session>());
    }
    @cAnnotation()
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumeroplazas() {
        return numeroplazas;
    }

    public void setNumeroplazas(int numeroplazas) {
        this.numeroplazas = numeroplazas;
    }


    public List<Participante> getCorredores() {
        return corredores;
    }

    public void setCorredores(List<Participante> corredores) {
        this.corredores = corredores;
    }

    public List<Session> getSesiones() {
        return Sesiones;
    }

    public void setSesiones(List<Session> sesiones) {
        Sesiones = sesiones;
    }
}
