import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ECommerceManager {
    // TODO: Définir la structure pour le catalogue de produits (ex: List<Produit>)
    // TODO: Implémenter le constructeur et y initialiser un catalogue de produits de test
    // TODO: Implémenter l'affichage du catalogue
    // TODO: Implémenter la méthode pour trouver un produit par son ID
    // TODO: Implémenter validerAchat(Panier panier) qui déduit le stock du catalogue
    private List<Produit> liste;
    public ECommerceManager(){
        liste = new ArrayList<>();
        Produit p1 = new Produit(0, "Livre Java", 1500, 12);
        Produit p2 = new Produit(1, "Souris", 8000, 40);
        Produit p3 = new Produit(2, "Clavier", 5000, 15);
        liste.add(p1);
        liste.add(p2);
        liste.add(p3);
    }

    public List<Produit> afficherCatalogue(){
        return liste;
    }

    public Produit trouvProduit(int id){
        for (Produit p: liste){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }
    // Cette methode permet de verifier si les quantités voulues par les utilisateurs pourront etre satisfaites par rapport au stock disponible en boutique,
    // s'il passe cette etape les quantites qu'il aura achete seront soustraits des stocks disponoble de la boutique.
    public void validerAchat(Panier panier){
        for (LignePanier l: panier.getLigne()){
            for (Produit p: liste){
                if (l.getProduit().getId() == p.getId()){
                    if (p.getQuantite() < l.getQuantite()){
                        throw new IllegalStateException("Stock insuffisant pour le produit "+l.getProduit().getNom());
                    }
                    p.setQuantite(p.getQuantite() - l.getQuantite());
                }
            }
        }
        panier.vider();
        System.out.println("Panier valide avec succès !");

    }
}
