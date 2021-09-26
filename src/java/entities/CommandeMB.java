/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dao.CommandeDAO;
import model.*;
import java.util.ArrayList;
import java.util.List;



public class CommandeMB {
    private List<Commandes> cart = new ArrayList<>();
    private double total;
    int cartsize;
    String item = "item";
    private boolean etat=false;

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
    
    public List<Commandes> getCart() {
        return cart;
    }

    public void setCart(List<Commandes> cart) {
        this.cart = cart;
    }

    public double getTotal() {
        total = 0.0;
        for(Commandes item : cart){
            total = total + (item.getQte()* item.getProd().getPrix());
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCartsize() {
        cartsize = cart.size();
        return cartsize;
    }

    public void setCartsize(int cartsize) {
        this.cartsize = cartsize;
    }

    public String getCommandes() {
        if(cartsize > 1){
            item = "items";
        }
        return item;
    }

    public void setCommandes(String item) {
        this.item = item;
    }  
    
    public String addtoCart(Produits product){
 
        
         System.out.println("Cart Size 1: "+cart.size());
        if (cart.size() > 0) {
            for (Commandes item : cart) {
                 System.err.println("Hellllllllllllo"+item);
                if ((item.getIdProduit()).equals(product.getId())) {
                    item.setQte(item.getQte()+ 1);
                    return "success";
              
                }
           
                System.out.println("Hellllllllllllo"+item);
            }            
        }
       
             System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA!!!");
        Commandes i = new Commandes(product.getId(),1);
       // i.setQte(1);
       // i.setIdProduit(product.getId());
       cart.add(i);
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB!!!"); 
  
       System.out.println("Cart Size 2 : "+cart.size());
       etat=false;
       return "success";
       
      
    }
    public void update()
    {
        
    }
    public void processCart(){
   CommandeDAO myDAO= new CommandeDAO();
        for(Commandes item : cart){
        
        myDAO.creer(item);
    }
        cart= new ArrayList<>();
        etat=true;
    }
    
    
    public void removeCart(Commandes i){
        for(Commandes item : cart){
            if (item.equals(i)) {
                cart.remove(i);
                break;
            }
        }
    }
}
