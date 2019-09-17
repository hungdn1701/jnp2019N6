/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson6_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class SServer {
    public static void main(String[] args) {
        InputStream in;
        OutputStream out;
        byte[] b = new byte[1024];
        try {
            ServerSocket server = new ServerSocket(1107);
            System.out.println("server started ...");
            while(true){
                Socket conn = server.accept();
                in = conn.getInputStream();
                while(in.available()>0)
                    in.read(b);
                System.out.println(new String(b).trim());
                
                conn.close();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(SServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
}
