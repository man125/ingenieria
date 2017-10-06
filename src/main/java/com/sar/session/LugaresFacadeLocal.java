/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sar.session;

import com.sar.model.Lugares;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author manuel
 */
@Local
public interface LugaresFacadeLocal {

    void create(Lugares lugares);

    void edit(Lugares lugares);

    void remove(Lugares lugares);

    Lugares find(Object id);

    List<Lugares> findAll();

    List<Lugares> findRange(int[] range);

    int count();
    
}
