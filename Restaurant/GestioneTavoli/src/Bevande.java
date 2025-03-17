/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Utente
 */
public class Bevande extends Cibo{
    
    //Attributi
    private boolean ghiaccio=false;
    private String misura;
    
    public Bevande(String nome, double prezzo, String misura,boolean ghiaccio){
        super(nome,prezzo);
        this.ghiaccio=ghiaccio;
        this.misura=misura;
    }
    
    public double getPrezzo(){
        return super.getPrezzoPrivato();
    }
    
    public String toString(){
        String esc="";
        if(ghiaccio==true){
            esc=esc+"\n Con Ghiaccio o non";
        }
        else{
            esc=esc+"\n Bevanda calda";
        }
        esc=esc+"\n Misura: "+misura+"\n";
        return super.toString()+esc;
    }
    
}
