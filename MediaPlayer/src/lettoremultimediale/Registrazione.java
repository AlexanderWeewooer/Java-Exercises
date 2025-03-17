/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lettoremultimediale;

/**
 *
 * @author Studente
 */
public class Registrazione extends Multimedia implements Interfaccia{

        int durata;
        int volume;
        boolean playable=false;
    
        public Registrazione(String nome, int durata, int volume){
        
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

    }
    
    
    //SUPPORTATE

    @Override
    public void play() {
        if(playable){
            System.out.println("\n *** registrazione *** ");
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
    public void show() {
        System.out.println(super.toString()+"\n Playable= "+playable+"\n Durata: "+durata+" sec");
    }
   
    //NON SUPPORTATE

    @Override
    public void darker(int decrease) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void brighter(int increase) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}
