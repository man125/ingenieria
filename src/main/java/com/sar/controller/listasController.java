/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sar.controller;

import com.sar.model.Estado;
import com.sar.model.Lugares;
import com.sar.model.Postulante;
import com.sar.session.EstadoFacadeLocal;
import com.sar.session.LugaresFacadeLocal;
import com.sar.session.PostulanteFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;



/**
 *
 * @author manuel
 */
@Named(value = "listController")
@SessionScoped
public class listasController implements Serializable {

    private  Estado es = new Estado();
    private Lugares lug = new Lugares();
 
    @EJB
    private EstadoFacadeLocal estadoFacade;
    @EJB
    private LugaresFacadeLocal lugarFacade;
    
 
 
   
    /**
     * Creates a new instance of cursoController
     */
    public listasController() {
    }
    
    public List<Estado> listaEstados(){
        return this.estadoFacade.findAll();
        
    }
    
    public List<Lugares> listaLugares(){
        return this.lugarFacade.findAll();
        
    }
    
   /* 
    public String agregar(){
        try{
        this.post.setCodigoEstado(es);
            System.out.println(post.getCodigoEstado());
        this.facade.create(this.post);
       //limpiar
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return "postulante";
    }
    
   public void delete(Alumno al){
        this.alumnoFacade.remove(al);
    }
    
    public String modify(){
        this.cursoFacade.edit(this.c);
         this.c = new Curso();
        return "list";
    }
    
    public String edit(Curso cur){
        this.c = cur;
        return "edit";
    }*/
    
}
