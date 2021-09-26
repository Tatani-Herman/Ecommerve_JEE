/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Commandes;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author USER
 */
public class CommandeDAO {
    Session s;
    public boolean creer(Commandes  c)
    {
        try{
           s= hibernateCurrentSession.getSessionFactory().openSession();
           s.beginTransaction();
           s.save(c);
           s.getTransaction().commit();
           return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

  
    public boolean update(Commandes  c) {
        try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          s.update(c);
          s.getTransaction().commit();
          return true;
        }catch(Exception e){
            e.printStackTrace();
             return false;
        }
      }

  
    public boolean delete(int id) {
        try{
          hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          s.delete(id);
          s.getTransaction().commit();
          return true;
        }catch(Exception e){
            e.printStackTrace();
             return false;
        }
    }

  
    public Commandes recuperer(int id) {
        Commandes resultat = null;
        try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          resultat = (Commandes) s.get(Commandes.class, id);
          s.getTransaction().commit();
        
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return resultat;
    }

  
    public List<Commandes> recuperer_All() {
       List<Commandes> list_cmd= null; 
       try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
       
         
           list_cmd = s.createCriteria(Commandes.class).list();
       
          s.getTransaction().commit();
             
       
        }catch(Exception e){
            e.printStackTrace();
           
        }
      
       return list_cmd;
    }
}
