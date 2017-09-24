/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sar.model;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
/**
 *
 * @author manuel
 */



@Entity
@Table(name= "usuario_inge")
public class Usuario implements Serializable {
   
   @Id
   @Column(unique = true)
   @NotNull
   private String cedula;
   @Column(name = "nombre")
   @NotNull
   private String nombre;
   @Column(name = "contraseña")
   @NotNull
   private String contraseña;
   @Column(name = "tipo")
   @NotNull
   private String tipo;
   
   //llave foranea no implementada
   //ver si es necesario en usuario
    @Column(name = "numrequisicion")
    @NotNull
   private short numeroRequisicion =1;


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public short getNumeroRequisicion() {
        return numeroRequisicion;
    }

    public void setNumeroRequisicion(short numeroRequisicion) {
        this.numeroRequisicion = numeroRequisicion;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", nombre=" + nombre + ", contrase\u00f1a=" + contraseña + ", tipo=" + tipo + ", numeroRequisicion=" + numeroRequisicion + '}';
    }
    
}