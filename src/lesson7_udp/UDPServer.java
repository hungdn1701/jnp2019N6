/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson7_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class UDPServer {
    DatagramSocket server;
    DatagramPacket receivePacket, sendPacket;
    int port;
    int bufferSize;
    byte[] receiveData, sendData;
    public UDPServer() {
        try {
             bufferSize = 1024;
             port = 1107;
             server = new DatagramSocket(port); // open server
        } catch (SocketException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void listening(){
        while(true){
            try {
                receiveData = new byte[bufferSize];
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                server.receive(receivePacket); // nhận gói tin UDP
                String strTemp = new String(receivePacket.getData()).trim();
                System.out.println(strTemp);
                String strReverse = StrUtil.reverse(strTemp);
                sendData = strReverse.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length
                        ,receivePacket.getSocketAddress());// InetAddress + Port = SocketAddress
                server.send(sendPacket);
                
            } catch (IOException ex) {
                Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
