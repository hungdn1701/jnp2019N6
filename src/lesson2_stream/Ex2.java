/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2_stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author mam
 */
public class Ex2 {
    public static void main(String[] args) {
        String file = "C:\\jnp\\2019\\n6\\ex3.bin";
//        Product p = new Product(10,"lemon", 5.5);
        try ( FileInputStream fos = new FileInputStream(file);
                DataInputStream oos = new DataInputStream(fos)   ){
            System.out.println(oos.readInt());
            System.out.println(oos.readUTF());
            System.out.println(oos.readDouble());
           
        } catch (Exception e) {
            System.out.println("err: " + e.getMessage());
        }
       
    }
}
class Product implements Serializable{
    private int productId;
    private String name;
    private double price;

    public Product() {
    }

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%d %s %.2f", this.productId, this.name, this.price);
    }
    
    
}
