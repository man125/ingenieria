/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sar.controller;



import com.sar.model.Usuario;
import com.sar.session.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author manuel
 */
@Named("usuarioController")
@RequestScoped
public class UsuarioController implements Serializable{
    private Usuario user;
    
    @EJB
    private UsuarioFacadeLocal facade;
    
    @PostConstruct
    public void init(){
        user = new Usuario();
        
        System.out.println("aqui voy");
    }
    
    

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    
    
    public List<Usuario> listar(){           
            return this.facade.findAll();    
    }
    
    public void limpiar(){
        //mejorar con cni
       user = new Usuario();
    }
    
    public void eliminar(Usuario c){
        try{
            //pregintar confirmacion en el view
            facade.remove(c);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    
    public void registrar(){
        try{
            facade.create(user);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void modificar(){
         try{
            facade.edit(user);
            this.user = new Usuario();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
      // return "categoria";
    }
    
    public void edit(Usuario c){
        this.user = c;
        //return "editar";
    }
    
}
