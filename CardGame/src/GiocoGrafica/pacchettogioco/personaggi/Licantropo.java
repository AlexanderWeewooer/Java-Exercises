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
public class Licantropo extends Carta{
   
    //ATTRIBUTI
    private String nome;
    private boolean luna_piena=false;
        //attributi della notte
        private int punti_vita_notte=15;
        private int punti_attacco_notte=3;
        private int reward_human_kill=5;
        //attributi del giorno
        private int punti_vita_giorno=10;
        private int punti_attacco_giorno=2;
        private int reward_monster_kill=7;
    
    //COSTRUTTORE
    public Licantropo(String nome){
        super(nome);
    }
    
    //SET
    public void setLunaPiena(int num){
        if(num==10){
            luna_piena=true;
        }
        else{
            luna_piena=false;
        }
    }
    public void setPV(int new_PV){
        if(luna_piena){
            punti_vita_notte=new_PV;
        }
        else{
            punti_vita_giorno=new_PV;
        }
    }
    public void setPA(int new_PA){
        if(luna_piena){
            punti_attacco_notte=new_PA;
        }
        else{
            punti_attacco_giorno=new_PA;
        }        
    }
    
    //GET
    public int getPV(){
        if(luna_piena){
            return punti_vita_notte;
        }
        else{
            return punti_vita_giorno;
        }
    }
    public int getPA(){
         if(luna_piena){
            return punti_attacco_notte;
        }
        else{
            return punti_attacco_giorno;
        }
    }
    
    //METODI
    @Override
    public void pozione(){
        this.setPV(getPV()+3);
    }
    public void carne() {
        this.setPA(getPA()+1);
    }
    public void luna() {
        this.setPA((int) (getPA()*1.5));
    }
    public void sole() {
        this.setPA(getPA()-1);
    }
    public Carta elimina(){
        Carta eliminato = new Carta("Personaggio eliminato!");
        return eliminato;
    }
    
    //TOSTRING e stampe
    @Override
    public String toString(){
        return super.toString()+" Punti attacco: "+getPA()+"<br> Punti vita: "+getPV()+"</html>";
    } 
    
}
