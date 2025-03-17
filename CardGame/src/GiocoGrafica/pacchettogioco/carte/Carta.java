/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GiocoGrafica.pacchettogioco.carte;

/**
 *
 * @author Studente
 */
public class Carta {
      
    //ATTRIBUTI
    private String nome;
    private int id;
    private static int numprog=0;
    
    //COSTRUTTORE
    public Carta(String nome){
        this.nome=nome;
        this.id=numprog++;
    }
    
    //SET
    
    //GET
    public String getNome(){return nome;}
    public int getId(){return id;}
    
    //METODI
    public void pozione(){
        
    }
    
    //TOSTRING
    @Override
    public String toString(){return "<html>"+nome+"<br> ID: "+id+"<br>";}
      
}
