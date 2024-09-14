/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labweek9;

import javax.swing.JOptionPane;

public class Song {

    private int codigo;
    private String nombre; 
    private double precio; 
    private double rating;
    private double sumaEstrellas;
    private int cantReviews;
    
    public Song(int codigo, String nombre, double precio){
        this.codigo=codigo;
        this.nombre=nombre;
        this.precio=precio;
        this.rating=0;
        this.sumaEstrellas=0;
        this.cantReviews=0;
    }
    
    public int getCode(){
        return this.codigo;
    }
    
    public String getName(){
        return this.nombre;
    }
    
    public double getPrice(){
        return this.precio;
    }
    
    public void addStars(int stars){
        if (stars>0&&stars<6) {
            cantReviews++;
            sumaEstrellas+=stars;
        } else { 
            JOptionPane.showMessageDialog(null, "Ingrese las estrellas dentro del rango de 1 a 5! ");
        }
    }
    
    public double songRating(){
        if (cantReviews==0)
            return rating=sumaEstrellas/cantReviews;
        return 0;
    }
    
    public void print(){
        System.out.println("--INFO DE CANCION--");
        System.out.println("CODIGO :"+codigo);
        System.out.println("NOMBRE :"+nombre);
        System.out.println("PRECIO :"+precio);
        System.out.println("RATING :"+songRating());
    }
}
