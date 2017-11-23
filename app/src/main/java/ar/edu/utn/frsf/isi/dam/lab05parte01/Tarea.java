package ar.edu.utn.frsf.isi.dam.lab05parte01;

import java.util.Date;

/**
 * Created by mdominguez on 23/11/17.
 */

public class Tarea {

    private String titulo;
    private String descripcion;

    public Tarea() {
    }

    public Tarea(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
