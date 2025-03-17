/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GiocoGrafica.pacchettogioco.personaggi;

import GiocoGrafica.pacchettogioco.carte.Carta;

/**
 *
 * @author Studente
 */
public class Vampiro extends Carta{
    
    //ATTRIBUTI
    private String nome;
    private int punti_vita=15;
    private int punti_attacco=3;
    private int reward_human_kill=5;
    
    //COSTRUTTORE
    public Vampiro(String nome){
        super(nome);
    }
    
    //SET
    public void setPV(int new_PV){punti_vita=new_PV;}
    public void setPA(int new_PA){punti_attacco=new_PA;}
    
    //GET
    public int getPV(){return punti_vita;}
    public int getPA(){return punti_attacco;}
    
    //METODI
    public void cartaBollaClassica(){
        punti_attacco+=1;
    }
    public void cartaBollaPrincipessa(){
        punti_attacco*=1.5;
    }
    public void cartaAglio() {
        punti_attacco-=1;
    }
    @Override
    public void pozione(){
        punti_vita+=3;
    }
    public Carta elimina(){
        Carta eliminato = new Carta("Personaggio eliminato!");
        return eliminato;
    }
    
    //TOSTRING e stampe
    @Override
    public String toString(){
        return super.toString()+" Punti attacco: "+punti_attacco+"<br> Punti vita: "+punti_vita+"</html>";
    } 
}
