/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Produits;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author USER
 */
public class ProduitDAO {
    Session s;
    public boolean creer(Produits p)
    {
        try{
           s= hibernateCurrentSession.getSessionFactory().openSession();
           s.beginTransaction();
           s.save(p);
           s.getTransaction().commit();
           return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

  
    public boolean update(Produits p) {
        try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          s.update(p);
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

  
    public Produits recuperer(int id) {
        Produits resultat = null;
        try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          resultat = (Produits) s.get(Produits.class, id);
          s.getTransaction().commit();
        
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return resultat;
    }

  
    public List<Produits> recuperer_All() {
       List<Produits> list_prod= null; 
       try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
       
         //list_prod =   s.createSQLQuery("select * from Table_Produits").list();//requete SQL
           list_prod = s.createCriteria(Produits.class).list();
         // list_prod = s.createQuery("from Produits").list();//requete HQL
          s.getTransaction().commit();
             
       
        }catch(Exception e){
            e.printStackTrace();
           
        }
      
       return list_prod;
    }
}
