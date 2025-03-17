/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lettoremultimediale;

/**
 *
 * @author Studente
 */
public class Immagine extends Multimedia implements Interfaccia{
    
    int luminosita; //da 0 a 100
    
    public Immagine(String nome, int luminosita){
        super(nome);
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
    public void show() {
        String lum=" ";
        for(int i=0;i<luminosita/10;i++){
            lum=lum+"*";
        }
        System.out.println(super.toString()+lum);
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
    
    //METODI NON SUPPORTATI
    @Override
    public void play() {
        throw new UnsupportedOperationException("Immagine non riproducibile."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void weaker(int volume) {
        throw new UnsupportedOperationException("Un'immagine non ha un volume."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void louder(int volume) {
        throw new UnsupportedOperationException("Un'immagine non ha un volume."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
