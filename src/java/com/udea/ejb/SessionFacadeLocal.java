/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.entity.Session;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface SessionFacadeLocal {

    void create(Session session);

    void edit(Session session);

    void remove(Session session);

    Session find(Object id);

    List<Session> findAll();

    List<Session> findRange(int[] range);

    int count();
    
}
