import java.util.Scanner;

public class IHMConsole {
    private Scanner scanner;
    public void Ihm() {

        scanner = new Scanner(System.in);
    }
    private void menu(){
        System.out.println("################ Menu ###################");
        System.out.println(" 1. Afficher la liste des classes (sans les eleves).");
        System.out.println(" 2. Afficher le nombre de matière d'un élève");
        System.out.println(" 3. Afficher la liste des notes d'un eleve (avec les détails)");
        System.out.println(" 4. Aficher la moyenne d'un eleve");
        System.out.println(" 5. Afficher le nombre d'eleve d'un département.");
        System.out.println(" 6. Afficher tous les noms des eleves d'un niveau.");
        System.out.println(" 7. Suppression d'un eleve, supprimera sa note mais pas sa classe");
        System.out.println(" 8. Suppression classe => supprime uniquement les éléves de cette classe");
        System.out.println(" 9. Suppression d'un departement => Supprime toutes les classes et tous les professeurs");
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
                    showListOfClass();
                    break;
                case "2":
                    showStudentSubjects();
                    break;
                case "3":
                    viewStudentScoreDetail();
                    break;
                case "4":
                    showGPA();
                    break;
                case "5":
                    showStudentsByDepartement();
                    break;
                case "6":
                    showAllStudentByLevel();
                    break;
                case "7":
                    deletAllScoreByStudent();
                    break;
                case "8":
                    deleteAllStudentsByClass();
                    break;
                case "9":
                    deleteAllClassByDepartement();
                    break;

                default:
                    System.out.println("choix invalide !");

            }
        }while(!choice.equals("0"));
        //???.end();  sessionFactory.close() dans service
    }

    private void deleteAllClassByDepartement() {
    }

    private void deleteAllStudentsByClass() {
    }

    private void deletAllScoreByStudent() {
    }

    private void showAllStudentByLevel() {
    }

    private void showStudentsByDepartement() {
    }

    private void showGPA() {
    }

    private void viewStudentScoreDetail() {
    }

    private void showStudentSubjects() {
    }

    private void showListOfClass() {
    }

}
