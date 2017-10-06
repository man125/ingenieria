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
@Named(value = "posController")
@RequestScoped
public class postulanteController implements Serializable {

    @EJB
    private PostulanteFacadeLocal facade;
   /*
    @EJB
    private EstadoFacadeLocal estadoFacade;
    
    @EJB
    private LugaresFacadeLocal lugaresFacade;
    */
    
   private  Postulante post = new Postulante();
   private  Estado es = new Estado();
   private  Lugares lugar = new Lugares();

    public Postulante getPost() {
        return post;
    }

    public void setPost(Postulante post) {
        this.post = post;
    }

    public Estado getEs() {
        return es;
    }

    public void setEs(Estado es) {
        this.es = es;
    }

    public Lugares getLugar() {
        return lugar;
    }

    public void setLugar(Lugares lugar) {
        this.lugar = lugar;
    }

   

      
    

    
    /**
     * Creates a new instance of cursoController
     */
    public postulanteController() {
    }
    
    public List<Postulante> listar(){
        return this.facade.findAll();
    }
   
    public String agregar(){
        try{
        this.post.setCodigoEstado(es);
        this.post.setResidencia(lugar);
        System.out.println(post.getResidencia());
        this.facade.create(this.post);
       //limpiar
        this.post = new Postulante();
        this.es = new Estado();
        this.lugar= new Lugares();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return "postulante";
    }
    /*
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
