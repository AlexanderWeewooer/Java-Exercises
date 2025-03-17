/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Utente
 */
public class Piatti extends Cibo{
    
    //Attributi
    private String nome;
    private double prezzo;
    private boolean freddo;
    private String portata;
    
    public Piatti(String nome, double prezzo, boolean freddo, String portata){
        super(nome,prezzo);
        this.freddo=freddo;
        this.portata=portata;
    }
    
    public double getPrezzo(){
        return super.getPrezzoPrivato();
    }
    
    public String toString(){
        String esc="";
        if(freddo==false){
            esc=esc+"\n Servito caldo ";
        }
        esc=esc+"\n "+portata;
        return super.toString() +esc;
    }
    
}
