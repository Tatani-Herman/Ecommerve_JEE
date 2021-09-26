/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dao.ProduitDAO;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import model.Produits;

/**
 *
 * @author USER
 */
@Dependent
public class ProduitMB {

    public ProduitDAO myDAO =new ProduitDAO();;
    List<model.Produits> all = myDAO.recuperer_All();
    Produits product = new Produits();
    private Produits selectedProduits;

    public Produits getSelectedProduits() {
        return selectedProduits;
    }

    public void setSelectedProduits(Produits selectedProduits) {
        this.selectedProduits = selectedProduits;
    }
    public Produits getProduct() {
        return product;
    }

    public void setProduct(Produits product) {
        this.product = product;
    }
    /**
     * Creates a new instance of ProduitMB
     */
    public ProduitMB() {
    }
        
    public List<model.Produits> getAll()
    {
        
        return all;
    }
    
    public void setAll(List<model.Produits> all)
    {
        this.all= all;
    }
    
   
    
}
