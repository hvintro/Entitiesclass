package com.example.android_ed1.entitiesclass.model.busineslayer.entities;

import com.example.android_ed1.entitiesclass.model.busineslayer.entities.base.Entitybase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by android-ed1 on 27/04/2016.
 */
public class Asistencia extends Entitybase {

    private Date Inicio;
    private Date Fin;
    private Participante participante;
    private List<Posicion> recorrido;

    public  Asistencia(){
        Inicio = null;
        Fin = null;
        participante = new Participante();
        recorrido = new ArrayList<Posicion>();
    }

    public Date getInicio() {
        return Inicio;
    }

    public void setInicio(Date inicio) {
        Inicio = inicio;
    }

    public Date getFin() {
        return Fin;
    }

    public void setFin(Date fin) {
        Fin = fin;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public List<Posicion> getRuta() {
        return recorrido;
    }

    public void setRuta(List<Posicion> ruta) {
        recorrido = ruta;
    }
}
