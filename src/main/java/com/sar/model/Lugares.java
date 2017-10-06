/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sar.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "LUGARES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lugares.findAll", query = "SELECT l FROM Lugares l")
    , @NamedQuery(name = "Lugares.findByCodigo", query = "SELECT l FROM Lugares l WHERE l.codigo = :codigo")
    , @NamedQuery(name = "Lugares.findByProvincia", query = "SELECT l FROM Lugares l WHERE l.provincia = :provincia")
    , @NamedQuery(name = "Lugares.findByColumn1", query = "SELECT l FROM Lugares l WHERE l.column1 = :column1")})
public class Lugares implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private BigDecimal codigo;
    @Size(max = 20)
    @Column(name = "PROVINCIA")
    private String provincia;
    @Size(max = 20)
    @Column(name = "COLUMN1")
    private String column1;
    @OneToMany(mappedBy = "residencia")
    private List<Postulante> postulanteList;

    public Lugares() {
    }

    public Lugares(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    @XmlTransient
    public List<Postulante> getPostulanteList() {
        return postulanteList;
    }

    public void setPostulanteList(List<Postulante> postulanteList) {
        this.postulanteList = postulanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lugares)) {
            return false;
        }
        Lugares other = (Lugares) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return provincia+"-"+column1;
    }
    
}
