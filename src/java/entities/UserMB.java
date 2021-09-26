/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dao.UserDAO;
import model.Users;

/**
 *
 * @author USER
 */
public class UserMB {
     private Users myUser;
      public UserDAO myDAO;
      private int id;
      private String name;
      private String password;


    /**
     * Creates a new instance of UserMB
     */
    public UserMB() {
    
    }

    public Users getMyUser() {
        return myUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMyUser(Users myUser) {
        this.myUser = myUser;
    }
     public String loginAction()
    {
        myDAO = new UserDAO();
        myUser= myDAO.recuperer(id);
        return password.equals(myUser.getPassword()) ? "success" : "failure";
    }
    
     public String registerAction()
    {
        myUser = new Users(id,name,password);
        myDAO = new UserDAO();
        myDAO.creer(myUser);
        
        return "success";
    }
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
