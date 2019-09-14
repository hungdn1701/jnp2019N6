/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3_mvc;

import java.util.Scanner;

/**
 *
 * @author mam
 */
public class LoginView {
    LoginModel user;
    // (1)
    public LoginView() { // login view
        String _strUser, _strPass;
        System.out.println(" - LOGIN VIEW -");
        Scanner in = new Scanner(System.in);
        _strUser = in.nextLine();
        _strPass = in.nextLine();
        
        new LoginController(_strUser, _strPass);
    }
    // (2)
    public LoginView(LoginModel user) { // details view
        this.user = user;
        System.out.println(" - DETAILS VIEW -");
        System.out.println("user: " + this.user.getUser());
        System.out.println("pass: " + this.user.getPass());
    }
    
}
