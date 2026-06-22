public class LignePanier {
    // TODO: Définir les attributs (produit de type Produit, quantite de type int)
    // TODO: Implémenter le constructeur
    // TODO: Implémenter les getters/setters (avec validation : quantité > 0)
    // TODO: Implémenter une méthode pour obtenir le prix total HT de cette ligne (quantité * prix HT du produit)
    // TODO: Implémenter toString() pour afficher une ligne du panier (ex: "2 x Livre Java (Total: 80€)")

    private Produit produit;
    private int quantite;

    public LignePanier(Produit produit, int quantite){
        this.produit = produit;
        setQuantite(quantite);
    }

    public Produit getProduit(){
        return produit;
    }

    public int getQuantite(){
        return quantite;
    }

    public void setQuantite(int quantity){
        if (quantity < 0){
            throw new IllegalArgumentException("La quantité doit être supérieure ou égale a 0");
        }
        this.quantite = quantity;
    }

    public int getPrixTotalHT(){
        return quantite * produit.getPrix();
    }
}
