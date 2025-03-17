/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Studente
 */
public class Ciclisti implements Ordinabile{
   
    int pettorale=0;
    int tempo=0;
    
    public Ciclisti(int pettorale, int tempo){
        this.pettorale=pettorale; this.tempo=tempo;}
    
    public boolean minoreDi(Object altroAtleta){
        if(altroAtleta==null || !(altroAtleta instanceof Ciclisti))
        return false;
        
        else {
        double indicePrestazioneQuestoAtleta = this.tempo;
        double indicePrestazioneAltro =((Ciclisti)altroAtleta).tempo;
        return indicePrestazioneQuestoAtleta < indicePrestazioneAltro;
        }
    }
    
    public boolean maggioreDi(Object altroAtleta){  
        return ! minoreDi(altroAtleta);
    }
    
    public String toString(){
        return "\n\n Pettorale: "+pettorale+"\n Tempo di arrivo: "+tempo;
    }
    
}
