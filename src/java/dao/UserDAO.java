/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Users;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author USER
 */
public class UserDAO {
    Session s;
    public boolean creer(Users u)
    {
        try{
           s= hibernateCurrentSession.getSessionFactory().openSession();
           s.beginTransaction();
           s.save(u);
           s.getTransaction().commit();
           return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

  
    public boolean update(Users u) {
        try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          s.update(u);
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

  
    public Users recuperer(int id) {
        Users resultat = null;
        try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          resultat = (Users) s.get(Users.class, id);
          s.getTransaction().commit();
        
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return resultat;
    }

  
    public List<Users> recuperer_All() {
       List<Users> list_users= null; 
       try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
       
         //list_prod =   s.createSQLQuery("select * from Table_Users").list();//requete SQL
           list_users = s.createCriteria(Users.class).list();
         // list_prod = s.createQuery("from Users").list();//requete HQL
          s.getTransaction().commit();
             
       
        }catch(Exception e){
            e.printStackTrace();
           
        }
      
       return list_users;
    }
}
