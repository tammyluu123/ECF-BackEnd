package exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputManagementException {
    private static Scanner sc = new Scanner(System.in);
    // Input a string not empty
    public static String getString(String inputMsg, String errorMsg) {
        String inputString;
        while (true) {
            System.out.print(inputMsg);
            inputString = sc.nextLine().trim().toUpperCase();
            if (inputString.isEmpty())
                System.out.println(errorMsg);
            else
                return inputString;
        }
    }
    public static String getStringWithMinLength(String inputMsg, String errorMsg, int minLength) {
        String inputString;
        while (true) {
            System.out.print(inputMsg);
            inputString = sc.nextLine().trim().toUpperCase();
            if (inputString.isEmpty() || inputString.length() < minLength) {
                System.out.println(errorMsg);
            } else {
                return inputString;
            }
        }
    }
    public static int getAnInteger(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    public static int getAnIntegerWithMinValue(String inputMsg, String errorMsg, int minValue) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());

                if (n < minValue) {
                    System.out.println(errorMsg);
                } else {
                    return n;
                }

            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errorMsg) {
        double d;
        while (true) {
            try {
                System.out.print(inputMsg);
                d = Double.parseDouble(sc.nextLine());
                return d;
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static Date getUserDate(String inputMsg, String errorMsg) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        while (true) {
            try {
                System.out.print(inputMsg);
                String dateString = sc.nextLine();
                // Convertit la chaîne en objet Date.
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date date = dateFormat.parse(dateString);
                return date;
            } catch (ParseException e) {
                System.out.println(errorMsg);
            }
        }
    }
    public static boolean getBoolean(String inputMsg, String errorMsg) {
        while (true) {
            try {
                System.out.print(inputMsg);
                String userInput = sc.nextLine().trim().toLowerCase();

                if (userInput.equals("true") || userInput.equals("false")) {
                    return Boolean.parseBoolean(userInput);
                } else {
                    System.out.println(errorMsg);
                }

            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    public static String getEmail(String inputMsg, String errorMsg) {
        String email;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            email = sc.nextLine().trim();
            match = email.matches("[a-zA-Z0-9._%+-]+@gmail\\.com");
            if (match ){
                return email;
            } else {
                System.out.println(errorMsg);
            }
        }
    }
    public static String getFormattedTime(String inputMsg, String errorMsg) {
        String time;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            time = sc.nextLine().trim();
            match = time.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");
            if (match ){
                return time;
            } else {
                System.out.println(errorMsg);
            }
        }
    }

    public static void main(String[] args) {
       /* String inputString = getString("Entrez le nom  en format chaîne de caractères: ", "Veuillez entrer un nom  valide!");
        System.out.println("Vous avez saisi :  " + inputString);
*/
       /* Date userDate = getUserDate(
                "Veuillez entrer une date (format : dd/MM/yyyy) : ",
                "Format de date invalide. Veuillez utiliser le format dd/MM/yyyy."
        );
        System.out.println("Date saisie : " + userDate);*/
           /* double inputDouble = getADouble("Entrez un nombre réel : ", "Veuillez entrer un nombre réel valide.");
            System.out.println("Vous avez saisi : " + inputDouble);*/


           /* int inputInteger = getAnInteger("Entrez un nombre entier : ", "Veuillez entrer un nombre entier valide.");
            System.out.println("Vous avez saisi : " + inputInteger);*/

        /*String professorName = getStringWithMinLength(
                "Saisissez le nom de l'enseignant (doit contenir au moins 3 caractères): ",
                "Le nom de l'enseignant doit contenir au moins 3 caractères.",
                3
        );
        System.out.println("Nom de l'enseignant: " + professorName);*/

        /*int professorAge = getAnIntegerWithMinValue(
                "Saisissez l'âge du professeur (doit être majeur) : ",
                "Le professeur doit être majeur.",
                18
        );
        System.out.println("Âge du professeur : " + professorAge);*/
        /*boolean isProfessorPrincipal = getBoolean(
                "Le professeur est-il principal? (true/false): ",
                "Veuillez saisir une valeur valide (true/false)."
        );
        System.out.println("Le professeur est principal : " + isProfessorPrincipal);*/

        /*String email = getEmail("Entrez email en format @gmail.com: ", "Veuillez saisir un email valide ");
        System.out.println("Votre email : " + email);*/
        String formattedTime = getFormattedTime("Entrez l'heure : ", "Format d'heure invalide. Utilisez HH:mm");
        System.out.println("Heure saisie : " + formattedTime);
    }
}
