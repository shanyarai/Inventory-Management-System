/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping.login;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import shopping.stock.*;

/**
 *
 * @author Sparsh
 * @author Suhani
 * @author Shanya
 * @author Nipam
 * 
 */
public class Login extends Stock {

    private String User = null;
    private String file = "C:\\Users\\asus\\Desktop\\Study\\SEM 5\\JAVA\\shopping\\src\\shopping\\login\\members.txt";

    //Login and Signup
    public void loginPrompt() {

        while (true) {
            System.out.println("----------------------------");
            System.out.println("---------Welcome to---------");
            System.out.println("------the Fashion Store-----");
            System.out.println("----------------------------");
            System.out.print("\n1. Login    2. Signup   3. Exit    ");
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter your choice: ");

            int loginInput = input.nextInt();

            //Option Checking
            if (loginInput == 1) {
                User = login(file);
                if (User != null) {
                    break;
                }
                System.out.println("Username or password didn't match.");
                System.out.println();

            } else if (loginInput == 2) {
                signup(file);
            } else if (loginInput == 3) {
                System.out.println("Thank you for using our application");
                System.exit(0);
            } else {
                System.out.println("Wrong Input!!");
            }
        }

        System.out.println("Logged in as:" + User);
    }

    public static String login(String file) {
        //standard variables
        Scanner x;
        Scanner sin = new Scanner(System.in);
        boolean found = false;
        String tempUsername = "";
        String tempPassword = "";

        //username and password input
        System.out.print("Enter Username: ");
        String username = sin.nextLine();
        System.out.print("Enter Password: ");
        String password = sin.nextLine();
        //System.out.println();

        //try Block for file
        try {
            x = new Scanner(new File(file));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found) {
                tempUsername = x.next();
                tempPassword = x.next();

                if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {
                    found = true;
                }
            }
            x.close();
        } catch (Exception e) {
            System.out.println("Error!!!!");
        }

        //user found or not
        if (found == true) {
            return username.trim();
        }
        return null;
    }

    public static void signup(String file) {
        //standard variables
        Scanner x;
        Scanner sin = new Scanner(System.in);
        boolean found = false;
        String tempUsername = "";
        String tempPassword = "";
        String username = null;

        //username input avaibility check
        while (true) {
            found = false;
            System.out.print("Enter Username: ");
            username = sin.nextLine();

            //try Block for file
            try {
                x = new Scanner(new File(file));
                x.useDelimiter("[,\n]");

                while (x.hasNext() && !found) {
                    tempUsername = x.next();
                    tempPassword = x.next();

                    if (tempUsername.trim().equals(username.trim())) {
                        found = true;
                        break;
                    }
                }
                x.close();
            } catch (Exception e) {
                System.out.println("Error!!!!");
            }
            //chicking if username available
            if (found == true) {
                System.out.println("Username Not Available. \n");
            } else {
                break;
            }
        }

        System.out.print("Enter Password: ");
        String password = sin.nextLine();
        System.out.println();

        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println("");
            String entry = username.trim() + "," + password.trim();
            pw.print(entry);

            pw.flush();

            pw.close();
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("!!ERROR!!");
        }

        System.out.println("User Successfully Registered. \n \n");
    }

}
