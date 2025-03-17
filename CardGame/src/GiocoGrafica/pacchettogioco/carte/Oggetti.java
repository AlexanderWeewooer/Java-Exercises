/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GiocoGrafica.pacchettogioco.carte;

import GiocoGrafica.pacchettogioco.carte.Carta;

/**
 *
 * @author Studente
 */
public class Oggetti extends Carta{

    private boolean su_avversario;
    private String desc;
        
    public Oggetti(String nome, boolean su_avversario, String desc){
        super(nome);
        this.su_avversario=su_avversario;
        this.desc=desc;
    }
    
    //METODI
    public boolean getSuAvversario(){
        return su_avversario;
    }
    
    //TOSTRING e Stampe
    @Override
    public String toString(){
        return "<html> Carta Effetto: "+ super.getNome() + "<br> ID: "+super.getId()+"<br> Descrizione: "+desc+"<br></html>";
    }

    @Override
    public void pozione() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
