import java.util.Scanner;

public class Main {
    // Je créé cette methode pour faciliter la verifications des entrees des utilisateurs dans le cas ou l'utilisateur met une lettre à la place d'un nombre
    // Il nettoie le buffer pour éviter le bug des sauts de ligne de Scanner.nextLine().
    public static int lireEntierSecurise(Scanner input, String message){
        while (true){
            System.out.print(message);
            String saisie  = input.nextLine();
            try{
                return Integer.parseInt(saisie);
            }
            catch (NumberFormatException e){
                System.out.println("Erreur: Entrez une valeur numérique entière");
            }
        }
    }

    public static void main(String[] args) {
        // TODO: Initialiser ECommerceManager et Panier
        // TODO: Implémenter la boucle de menu console principale
        // TODO: Gérer la validation des entrées utilisateur (saisie de nombres)
        Scanner entree = new Scanner(System.in);
        ECommerceManager manager = new ECommerceManager();
        Panier panier = new Panier();
        System.out.println("### Bienvenue sur le gestionnaire de commande 2.0 ###");
        while (true){
            System.out.println("\n \n1. Afficher catalogue \n2. Ajouter au panier \n3. Consulter panier \n4. Modifier/Supprimer Quantité \n5. Valider la commande \n6. Quitter");
            int choice = lireEntierSecurise(entree,"Option: ");
            if (choice == 1){
                if (manager.afficherCatalogue().isEmpty()){
                    System.out.println("Aucun produit disponible en magasin actuellement, repassez plus tard svp");
                }
                for (Produit p: manager.afficherCatalogue()){
                    System.out.println(p);
                }
            }

            if (choice == 2){
                int id = lireEntierSecurise(entree, "L'identifiant du produit que vous voulez ajouter: ");
                boolean trouve = false;
                for (Produit p: manager.afficherCatalogue()){
                    if (p.getId() == id){
                        int quantite = lireEntierSecurise(entree, "Quelle quantité voulez vous ?: ");
                        if (p.getQuantite() < quantite){
                            System.out.println("Cette quantité n'est pas disponible en magasin");
                            trouve = true;
                            break;
                        }
                        panier.ajouterProduit(p, quantite);
                        System.out.println("Produit ajoute avec succès");
                        trouve = true;
                        break;
                    }
                }
                if (!trouve){
                    System.out.println("Ce produit n'est pas disponible en magasin");
                }
            }

            if (choice == 3){
                System.out.println("\nLe contenu de votre panier: ");
                for (LignePanier l: panier.getLigne()){
                    System.out.println("Id: "+l.getProduit().getId()+" | Nom: "+l.getProduit().getNom()+" | Prix unitaire: "+l.getProduit().getPrix()+" | Quantité: "+l.getQuantite());
                }
                System.out.println("TotalHT: "+panier.calculerTotalHT());
                System.out.println("TotalTTC: "+panier.calculerTotalTTC());
            }

            if (choice == 4){
                boolean trouve = false;
                int id = lireEntierSecurise(entree, "Entrez l'identifiant du produit dont vous voulez modifier la quantité: ");
                for (LignePanier l: panier.getLigne()){
                    if (l.getProduit().getId() == id){
                        System.out.println("Id: "+l.getProduit().getId()+" | Nom: "+l.getProduit().getNom()+" | Prix: "+l.getProduit().getPrix()+" | Quantité: "+l.getQuantite());
                        int nouvelleQuantite = lireEntierSecurise(entree, "Entrez la nouvelle quantité: ");
                        if (manager.trouvProduit(id).getQuantite() < nouvelleQuantite){
                            System.out.println("Cette quantité n'est pas disponible en magasin");
                            trouve = true;
                            break;
                        }
                        l.setQuantite(nouvelleQuantite);
                        System.out.println("Quantité mise a jour avec succès !");
                        trouve = true;
                        break;
                    }
                }

                if (!trouve){
                    System.out.println("Ce produit n'est pas dans votre panier.");
                }

            }

            if (choice == 5){
                for (LignePanier l: panier.getLigne()){
                    System.out.println("Id: "+l.getProduit().getId()+" | Nom: "+l.getProduit().getNom()+" | Prix unitaire: "+l.getProduit().getPrix()+" | Quantité: "+l.getQuantite());
                }
                System.out.println("Total a payer: "+panier.calculerTotalTTC());
                manager.validerAchat(panier);
            }

            if (choice == 6){
                System.out.println("Au revoir !");
                break;
            }
        }
    }


}
