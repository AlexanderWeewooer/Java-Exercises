/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Utente
 */
public abstract class Cibo {
    
    //Attributi
    private String nome;
    private double prezzo;
    
    public Cibo(String nome, double prezzo){
        this.nome=nome;
        this.prezzo=prezzo;
    }
    
    public String getNome(){return nome;}
    
    public double getPrezzoPrivato(){return prezzo;}
    
    public abstract double getPrezzo();
    
    public String toString(){
        return "\n "+nome+" \n "+prezzo+"$";
    }
    
}
