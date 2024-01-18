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
                Date date = dateFormat.parse(dateString);
                return date;
            } catch (ParseException e) {
                System.out.println(errorMsg);
            }
        }
    }



    public static void main(String[] args) {
       /* String inputString = getString("Entrez le nom  en format chaîne de caractères: ", "Veuillez entrer un nom  valide!");
        System.out.println("Vous avez saisi :  " + inputString);
*/
        Date userDate = getUserDate(
                "Veuillez entrer une date (format : dd/MM/yyyy) : ",
                "Format de date invalide. Veuillez utiliser le format dd/MM/yyyy."
        );
        System.out.println("Date saisie : " + userDate);
           /* double inputDouble = getADouble("Entrez un nombre réel : ", "Veuillez entrer un nombre réel valide.");
            System.out.println("Vous avez saisi : " + inputDouble);


            int inputInteger = getAnInteger("Entrez un nombre entier : ", "Veuillez entrer un nombre entier valide.");
            System.out.println("Vous avez saisi : " + inputInteger);*/


    }
}
