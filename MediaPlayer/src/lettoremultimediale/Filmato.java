/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lettoremultimediale;

/**
 *
 * @author Studente
 */
public class Filmato extends Multimedia implements Interfaccia{
    
    int durata;
    int volume;
    int luminosita;
    boolean playable=false;

    public Filmato(String nome, int durata, int volume, int luminosita){
        
        super(nome);
        
        this.durata=durata;
        if(durata>0){
            this.playable=true;
        }
        
        if(volume>100){
            this.volume=100;
        }
        else if(volume<0){
            this.volume=0;
        }
        else{
            this.volume=volume;
        }
        
        
        if(luminosita>100){
            this.luminosita=100;
        }
        else if(luminosita<0){
            this.luminosita=0;
        }
        else{
            this.luminosita=luminosita;
        }
    }
    
    //METODI SUPPORTATI
    @Override
    public void play() {
        if(playable){
            System.out.println("\n *** video *** ");
        }
        else{
            System.out.println("\n not playable  ");
        }
    }

    @Override
    public void weaker(int decrease) {
        volume=volume-decrease;
        if(volume>100){
            this.volume=100;
        }
        else if(volume<0){
            this.volume=0;
        }
        else{
            this.volume=volume;
        }
    }

    @Override
    public void louder(int increase) {
        volume=volume+increase;
        if(volume>100){
            this.volume=100;
        }
        else if(volume<0){
            this.volume=0;
        }
        else{
            this.volume=volume;
        }
    }

    @Override
    public void darker(int decrease) {
        luminosita=luminosita-decrease;
        if(luminosita>100){
            this.luminosita=100;
        }
        else if(luminosita<0){
            this.luminosita=0;
        }
        else{
            this.luminosita=luminosita;
        }
    }

    @Override
    public void brighter(int increase) {
        luminosita=luminosita+increase;
        if(luminosita>100){
            this.luminosita=100;
        }
        else if(luminosita<0){
            this.luminosita=0;
        }
        else{
            this.luminosita=luminosita;
        }
    }    
    
    @Override
    public void show() {
        System.out.println(super.toString()+"\n Playable= "+playable+"\n Durata: "+durata+" sec"+"\n Luminosità: "+luminosita+" %");
    }
    
}
