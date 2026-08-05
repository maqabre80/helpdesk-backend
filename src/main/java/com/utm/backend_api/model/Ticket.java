package com.utm.backend_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

/**
 * Modelo de datos para los tickets del Help Desk.
 * @author Fausto Damian Guano Loya
 */
@Document(collection = "tickets")
public class Ticket {

    @Id
    private String id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private String prioridad;
    private String estado;
    private String tecnico;
    private Date fecha;

    public Ticket() {
        this.estado  = "Abierto";
        this.tecnico = "Por Asignar";
        this.fecha   = new Date();
    }

    public String getId()                { return id; }
    public void setId(String id)         { this.id = id; }
    public String getTitulo()            { return titulo; }
    public void setTitulo(String t)      { this.titulo = t; }
    public String getDescripcion()       { return descripcion; }
    public void setDescripcion(String d) { this.descripcion = d; }
    public String getCategoria()         { return categoria; }
    public void setCategoria(String c)   { this.categoria = c; }
    public String getPrioridad()         { return prioridad; }
    public void setPrioridad(String p)   { this.prioridad = p; }
    public String getEstado()            { return estado; }
    public void setEstado(String e)      { this.estado = e; }
    public String getTecnico()           { return tecnico; }
    public void setTecnico(String t)     { this.tecnico = t; }
    public Date getFecha()               { return fecha; }
    public void setFecha(Date f)         { this.fecha = f; }
}