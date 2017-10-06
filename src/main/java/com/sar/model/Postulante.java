/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sar.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "POSTULANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postulante.findAll", query = "SELECT p FROM Postulante p")
    , @NamedQuery(name = "Postulante.findByCedulaPostulante", query = "SELECT p FROM Postulante p WHERE p.cedulaPostulante = :cedulaPostulante")
    , @NamedQuery(name = "Postulante.findByNombreCompleto", query = "SELECT p FROM Postulante p WHERE p.nombreCompleto = :nombreCompleto")
    , @NamedQuery(name = "Postulante.findByEscolaridad", query = "SELECT p FROM Postulante p WHERE p.escolaridad = :escolaridad")
    , @NamedQuery(name = "Postulante.findByEdad", query = "SELECT p FROM Postulante p WHERE p.edad = :edad")
    , @NamedQuery(name = "Postulante.findByExperienciaLaboral", query = "SELECT p FROM Postulante p WHERE p.experienciaLaboral = :experienciaLaboral")
    , @NamedQuery(name = "Postulante.findByEspecialidad", query = "SELECT p FROM Postulante p WHERE p.especialidad = :especialidad")
    , @NamedQuery(name = "Postulante.findByLicenciaConducir", query = "SELECT p FROM Postulante p WHERE p.licenciaConducir = :licenciaConducir")})
public class Postulante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CEDULA_POSTULANTE")
    private String cedulaPostulante;
    @Size(max = 50)
    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;
    @Size(max = 15)
    @Column(name = "ESCOLARIDAD")
    private String escolaridad;
    @Column(name = "EDAD")
    private BigInteger edad;
    @Size(max = 100)
    @Column(name = "EXPERIENCIA_LABORAL")
    private String experienciaLaboral;
    @Size(max = 20)
    @Column(name = "ESPECIALIDAD")
    private String especialidad;
    @Size(max = 20)
    @Column(name = "LICENCIA_CONDUCIR")
    private String licenciaConducir;
    @JoinColumn(name = "CODIGO_ESTADO", referencedColumnName = "CODIGO_ESTADO")
    @ManyToOne
    private Estado codigoEstado;
    @JoinColumn(name = "RESIDENCIA", referencedColumnName = "CODIGO")
    @ManyToOne
    private Lugares residencia;

    public Postulante() {
    }

    public Postulante(String cedulaPostulante) {
        this.cedulaPostulante = cedulaPostulante;
    }

    public String getCedulaPostulante() {
        return cedulaPostulante;
    }

    public void setCedulaPostulante(String cedulaPostulante) {
        this.cedulaPostulante = cedulaPostulante;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public BigInteger getEdad() {
        return edad;
    }

    public void setEdad(BigInteger edad) {
        this.edad = edad;
    }

    public String getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(String experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getLicenciaConducir() {
        return licenciaConducir;
    }

    public void setLicenciaConducir(String licenciaConducir) {
        this.licenciaConducir = licenciaConducir;
    }

    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public Lugares getResidencia() {
        return residencia;
    }

    public void setResidencia(Lugares residencia) {
        this.residencia = residencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaPostulante != null ? cedulaPostulante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postulante)) {
            return false;
        }
        Postulante other = (Postulante) object;
        if ((this.cedulaPostulante == null && other.cedulaPostulante != null) || (this.cedulaPostulante != null && !this.cedulaPostulante.equals(other.cedulaPostulante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sar.model.Postulante[ cedulaPostulante=" + cedulaPostulante + " ]";
    }
    
}
