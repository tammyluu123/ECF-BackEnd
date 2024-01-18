import java.util.Scanner;

public class IHMConsole {
    private Scanner scanner;
    public void Ihm() {

        scanner = new Scanner(System.in);
    }
    private void menu(){
        System.out.println("################ Menu ###################");
        System.out.println(" 1. Ajouter un produit");
        System.out.println(" 2. Afficher les informations d'un produit");
        System.out.println(" 3. Supprimer un produit");
        System.out.println(" 4. Modifier les informations du produit");
        System.out.println(" 5. Afficher la totalité des produits");
        System.out.println(" 6. Afficher les produits dont le prix est supérieur au montant précisé");
        System.out.println(" 7. Afficher les produits achetés entre deux dates");
        System.out.println(" 8. Afficher les produits dont le stock est inférieur au montant précisé");
        System.out.println(" 9. Afficher la valeur du stock d'une marque");
        System.out.println("10. Afficher le prix moyen des produits");
        System.out.println("11. Afficher la liste des produits d'une marque choisie");
        System.out.println("12. Supprimer les produits d'une marque choisie");
        System.out.println("13. Ajouter une image à un produit ");
        System.out.println("14. Ajouter un commentaire à un produit. ");
        System.out.println("15. Afficher les produits avec une note de 4 ou plus ");
        System.out.println("16. Ajouter une commande avec un ou plusieurs produits. ");
        System.out.println("17. Afficher la totalité des commandes. ");
        System.out.println("18. Afficher uniquement les commandes du jour. ");
        System.out.println(" 0. Quitter l'application");
        System.out.println("################ ************ ###################");
        System.out.print("Choix : ");

    }
    public  void start() {
        String choice;
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":

                    break;
                case "8":

                    break;
                case "9":

                    break;
                case "10":

                    break;
                case "11":

                    break;
                case "12":

                    break;
                case "13":

                    break;
                case "14":

                    break;
                default:
                    System.out.println("choix invalide !");

            }
        }while(!choice.equals("0"));
        //???.end();  sessionFactory.close() dans service
    }

}
