/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.ArrayList;
import java.util.List;
import model.Categorie;

import model.Produits;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author USER
 */
public class CategorieDAO {
    Session s;
    public boolean creer(Categorie c)
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

  
    public boolean update(Categorie c) {
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

  
    public Categorie recuperer(int id) {
        Categorie resultat = null;
        try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          resultat = (Categorie) s.get(Categorie.class, id);
          s.getTransaction().commit();
        
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return resultat;
    }

  
    public List<Categorie> recuperer_All() {
       List<Categorie> list_prod= null; 
       try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
       
           list_prod = s.createCriteria(Categorie.class).list();
          s.getTransaction().commit();
             
       
        }catch(Exception e){
            e.printStackTrace();
           
        }
      
       return list_prod;
    }
    
    public List<Produits> recuperer_AllProducts(int id) {
       List<Produits> list_prod= new ArrayList<>(); 
        List<Produits> list_prod2= null; 
       try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          // list_prod =  (List<Produits>)(s.createSQLQuery("select * from Produits where ID_CATEGORIE="+id)).list();
          list_prod2 = s.createCriteria(Produits.class).list();
         for(int i=0;i<list_prod2.size();i++)
         {
             if(list_prod2.get(i).getIdCategorie()==id)
             {
                 list_prod.add(list_prod2.get(i));
             }
         }
           /* crit.add(Restrictions.eq("ID_CATEGORIE",id));
            list_prod = crit.list();*/
          s.getTransaction().commit();
             
       
        }catch(Exception e){
            e.printStackTrace();
           
        }
      
       return list_prod;
    }
}
