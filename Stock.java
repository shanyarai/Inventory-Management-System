/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping.stock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sparsh
 * @author Suhani
 * @author Nipam
 * @author Shanya
 */
public class Stock {

    private static boolean EXIT = false;
    public static int count = 0, totalAmount = 0;

    private static final String[][] mat1 = {
        {"0", "Jeans      ", "1199"},
        {"1", "Trousers   ", "999"},
        {"2", "Shirts     ", "699"},
        {"3", "T-shirts   ", "499"},
        {"4", "Track pants", "599"},
        {"5", "Kurtas       ", "599"},
        {"6", "Nehru jackets", "499"},
        {"7", "Shirts       ", "599"},
        {"8", "Sherwani     ", "1999"},
        {"9", "Pathani suits", "1499"},
        {"10", "Jeans   ", "999"},
        {"11", "Dresses ", "999"},
        {"12", "Skirts  ", "699"},
        {"13", "Tops    ", "799"},
        {"14", "T-shirts", "399"},
        {"15", "Kurtas   ", "499"},
        {"16", "Sarees   ", "1999"},
        {"17", "Palazzos ", "399"},
        {"18", "Churidars", "399"},
        {"19", "Lehangas ", "1999"},
        {"20", "Shirts     ", "499"},
        {"21", "T-shirts   ", "399"},
        {"22", "Track pants", "499"},
        {"23", "Shorts     ", "299"},
        {"24", "Denims     ", "799"},
        {"25", "Frocks ", "699"},
        {"26", "Jeans  ", "499"},
        {"27", "Skirts ", "399"},
        {"28", "Tops   ", "499"},
        {"29", "Dresses", "999"}};
    private static final String[][] mat2 = new String[3][30];
    private static final String[][] selection = new String[30][5];

    private static final String[] firstCategory = {"Men's Fashion", "Women's Fashion", "Kids' Fashion"},
            secCategory = {"Western", "Ethnic"},
            secCategoryBG = {"Boys", "Girls"},
            checkOut = {"Checkout", "Buy again"};

    private String gender, wearType;

    public void firstCheck() {
        String res2 = "";
        System.out.println("----------------------------");
        System.out.println("------Shop by Category------");
        System.out.println("----------------------------");
        displayMenu(firstCategory);
        String res1 = collectResponse(firstCategory);
        gender = res1;
        while (true) {

            if (res1 == "Men's Fashion" || res1 == "Women's Fashion") {
                System.out.println("-----------------------------");
                System.out.println("----Choose your wear type----");
                System.out.println("-----------------------------");
                displayMenu(secCategory);
                res2 = collectResponse(secCategory);
                break;
            } else if ("Kids' Fashion".equals(res1)) {
                System.out.println("-----------------------------");
                System.out.println("----Choose for Boys/Girls----");
                System.out.println("-----------------------------");
                displayMenu(secCategoryBG);
                res2 = collectResponse(secCategoryBG);
                break;
            } else {
                System.out.println("Thank You");
                System.exit(0);
            }

        }
        wearType = res2;
        secCheck();
    }

    public void secCheck() {
        String res1 = gender;
        String res2 = wearType;
        //try {
        if ("Men's Fashion".equals(res1) && "Western".equals(res2)) {
            getDetail(0);
        } else if ("Men's Fashion".equals(res1) && "Ethnic".equals(res2)) {
            getDetail(5);
        } else if ("Women's Fashion".equals(res1) && "Western".equals(res2)) {
            getDetail(10);//break;
        } else if ("Women's Fashion".equals(res1) && "Ethnic".equals(res2)) {
            getDetail(15);//break;
        } else if ("Kids' Fashion".equals(res1) && "Boys".equals(res2)) {
            getDetail(20);//break;
        } else if ("Kids's Fashion".equals(res1) && "Girls".equals(res2)) {
            getDetail(25);// break;
        } else {
            System.out.println("Try Again!!");
            runMenu();
        }
        /*} catch (Exception e) {
         System.out.println("Something went wrong!!");
         }*/
    }

    public static String collectResponse(String category[]) {
        int choice;
        String response = "";
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter your choice: ");
        choice = in.nextInt();
        try {
            if (choice < category.length + 1) {
                response = category[choice - 1];
            } else if (choice == (int) (category.length + 1)) {
                System.out.println("Thank You");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Error.");
        }
        return response;
    }

    public void displayMenu(String items[]) {
        System.out.println("\n Options: ");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d. %s\n", i + 1, items[i]);
        }
        System.out.printf("%d. Exit\n", items.length + 1);
    }

    public void runMenu() {
        Scanner uin = new Scanner(System.in);
        firstCheck();
        System.out.println("Thank You for Shopping with Us.");
        System.exit(0);
    }

    public void showCart() {

        System.out.println("You have selected: " + gender + "-->" + wearType);
        /*for (String[] row : selection) {
         System.out.println(Arrays.toString(row));
         }*/
        int i = 0;
        while (true) {
            if (selection[i][0] == null) {
                break;
            } else {
                System.out.println("Product\t\tPrice\t\tSize\t\tColor\t\tQuantity");
                System.out.println(selection[i][0] + "\t" + selection[i][1] + "\t\t" + selection[i][2].toUpperCase() + "\t\t" + selection[i][3] + "\t\t" + selection[i][4]);
                System.out.println("------------------------------------------------------------------");
                totalAmount += Integer.decode(selection[i][1]) * (Integer.decode(selection[i][4]));
                i++;
            }
        }
        System.out.println("You order total:     Rs. " + totalAmount);
        System.out.println("\n1. Continue Shopping");
        System.out.println("2. Check Out");
        System.out.println("-----------------------------");
        
        Scanner in = new Scanner(System.in);
        System.out.print("\nSelect your choice: ");
        int choice = in.nextInt();
        switch(choice){
            case 1:
                runMenu();
            case 2:
                System.out.println("Thank You for Shopping with Us.");
                System.exit(0);
        }
    }

    public int getPid(int starter) {
        int choice;
        Scanner inn = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println("--------Product chart--------");
        System.out.println("-----------------------------");
        System.out.println("\nSr.  Product     Price");
        for (int i = starter; i < starter + 5; i++) {
            System.out.println(Integer.toString(i - starter + 1) + ".  " + mat1[i][1] + "  Rs." + mat1[i][2]);
        }
        System.out.println("-----------------------------");
        System.out.println("6.  Go to Cart   \n7.  Go Back   \n8.  Exit");
        System.out.println("-----------------------------");
        System.out.println("---Select product/ options---");
        System.out.println("-----------------------------");
        choice = inn.nextInt();
        return choice;
    }

    public void getDetail(int st) {
        Scanner uin = new Scanner(System.in);
        while (true) {

            int option = getPid(st);
            if (option == 6) {
                showCart();
                System.out.println("Thank You for Shopping with Us.");
                System.exit(0);
            } else if (option == 7) {
                firstCheck();
                break;
            } else if (option == 8) {
                System.out.println("Thank You for Shopping with Us.");
                System.exit(0);
            } else {
                System.out.print("Enter (Size, Color, Quantity): ");
                String[] val = uin.nextLine().split(",");
                mat2[count][0] = mat1[st + option - 1][0];
                mat2[count][1] = val[0];
                mat2[count][2] = val[1];
                mat2[count][3] = val[2];

                //pname
                selection[count][0] = mat1[st + option - 1][1];
                //price
                selection[count][1] = mat1[st + option - 1][2];
                //size
                selection[count][2] = val[0];
                //color
                selection[count][3] = val[1];
                //qty
                selection[count][4] = val[2];
                count++;
            }
        }
        uin.close();
    }

}
