/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dao.CategorieDAO;
import java.util.ArrayList;
import java.util.List;
import model.Categorie;
import model.Produits;

/**
 *
 * @author USER
 */
public class CategorieMB {

    /**
     * Creates a new instance of CategorieMB
     */
      private List<Categorie> myCategorie;
      private List<Produits> myProduits =new ArrayList<>();
    public CategorieMB() {
      
        myCategorie = (new CategorieDAO()).recuperer_All();
    
    }

    public void setMyCategorie (List<Categorie> myCategorie) {
        this.myCategorie = myCategorie;
    }
    
    public String viewProducts(Categorie cat)
    {
        System.out.println("Categorie : "+cat.getIntitule());
        myProduits = (new CategorieDAO()).recuperer_AllProducts(cat.getId());
        for (int i = 0; i < myProduits.size(); i++) {
            
            System.out.println("Proprietes"+ myProduits.get(i).getNom() + " "+myProduits.get(i).getImgLink());
        }
        return "viewPerCategory";
    }
    
    public List<Categorie> getMyCategorie() {
        return myCategorie;
    }

    public void setMyProduits(List<Produits> myProduits) {
        this.myProduits = myProduits;
    }
    
    
    
   /* public List<Produits> listOfProductsForCat(Categorie c)
    {
        return c.getProduitsList();
    }*/

    public List<Produits> getMyProduits() {
      //  System.out.println("Size of products list :"+myProduits.size());
        for (int i = 0; i < myProduits.size(); i++) {
            System.out.println(myProduits.get(i));
        }
        return myProduits;
    }
}
