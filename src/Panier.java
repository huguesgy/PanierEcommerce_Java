import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

public class Panier {
    // TODO: Définir la structure pour stocker les lignes de panier (ex: List<LignePanier> ou Map<Integer, LignePanier>)
    // TODO: Implémenter le constructeur
    // TODO: Implémenter ajouterProduit(Produit p, int quantite)
    // TODO: Implémenter modifierQuantite(int idProduit, int nouvelleQuantite)
    // TODO: Implémenter retirerProduit(int idProduit)
    // TODO: Implémenter calculerTotalHT() (somme des sous-totaux des lignes)
    // TODO: Implémenter calculerTotalTTC(double tauxTVA) (ex: tauxTVA = 20.0 pour 20%)
    // TODO: Implémenter vider()
    // TODO: Implémenter getLignes() pour permettre à l'affichage de lister le panier

    // J'ai decide d'utiliser une Map au lieu d'une List pour que par la suite on puisse identifier une ligne de panier juste avec l'identifiant du produit.
    private Map<Integer, LignePanier> lignes;

    public Panier(){
        lignes = new HashMap<>();
    }
    // Grâce à cette methode, si l'utilisateur veut ajouter un produit dans son panier et que le produit est deja present dans son panier, le produit additionnera simplement les deux quantités,
    // si le produit n'est pas encore dans le panier, le programme l'ajoute automatiquement dans le panier de l'utilisateur.
    public void ajouterProduit(Produit p, int quantite){
        if (lignes.containsKey(p.getId())){
            LignePanier ligneExistante = lignes.get(p.getId());
            ligneExistante.setQuantite(ligneExistante.getQuantite() + quantite);
        }else{
            lignes.put(p.getId(), new LignePanier(p, quantite));
        }
    }

    public void modifierQuantite(int idProduit, int nouvelleQuantite){
        LignePanier ligne = lignes.get(idProduit);
        if (ligne == null){
            throw new IllegalStateException("Le produit n'est pas dans votre panier");
        }
        ligne.setQuantite(nouvelleQuantite);
    }

    public void retirerProduit(int idProduit){
        LignePanier ligneSupprime = lignes.remove(idProduit);
        if (ligneSupprime == null){
            throw new IllegalStateException("Le produit n'est pas dans votre panier");
        }
    }

    public int calculerTotalHT(){
        int calculTotalHT = 0;
        for (LignePanier p: lignes.values()){
            calculTotalHT += p.getPrixTotalHT();
        }
        return calculTotalHT;
    }

    public double calculerTotalTTC(){
        int calculTotalHT = 0;
        for (LignePanier p: lignes.values()){
            calculTotalHT += p.getPrixTotalHT();
        }
        return calculTotalHT * 1.2;
    }

    public void vider(){
        lignes.clear();
    }

    public Collection<LignePanier> getLigne(){
        return lignes.values();
    }
}
