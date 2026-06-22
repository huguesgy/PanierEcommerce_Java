public class Produit {
    // TODO: Définir les attributs (id, nom, prix HT, quantité en stock)
    // TODO: Implémenter le constructeur
    // TODO: Implémenter les getters/setters (avec validations : prix et stock >= 0)
    // TODO: Implémenter toString() pour afficher proprement un produit du catalogue

    private int id;
    private String nom;
    private int prixHT;
    private int quantityStock;

    public Produit(int id, String nom, int prix, int quantity){
        this.id = id;
        this.nom = nom;
        setPrix(prix);
        setQuantite(quantity);
    }

    public int getId(){
        return id;
    }

    public String getNom(){
        return nom;
    }

    public int getPrix(){
        return prixHT;
    }

    public int getQuantite(){
        return quantityStock;
    }

    public void setPrix(int prix){
        if (prix <= 0){
            throw new IllegalArgumentException("Le prix d'un produit doit être strictement positif");
        }
        this.prixHT = prix;
    }

    public void setQuantite(int quantity){
        if (quantity < 0){
            throw new IllegalArgumentException("La quantité doit être supérieur ou égale a 0");
        }
        this.quantityStock = quantity;
    }

    @Override
    public String toString(){
        return "Id: "+getId()+" | Nom: "+getNom()+" | Prix: "+getPrix()+" | Quantité: "+getQuantite();
    }
}
