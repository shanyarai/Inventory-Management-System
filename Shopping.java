

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import shopping.login.*;

/**
 *
 * @author Nipam
 * @author Sparsh
 * @author Suhani
 * @author Shanya
 */
public class Shopping  {

    //Login and Signup
    public static void main(String args[]) {
        
        Login free = new Login();
        free.loginPrompt();
        free.runMenu();
        
    }
}
