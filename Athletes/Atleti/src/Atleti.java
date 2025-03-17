/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Studente
 */
public class Atleti implements Ordinabile {
    
    int pettorale=0;
    int eta=0, prestazione=0; //in secondi
    public final static double coefficienteEta=0.4;
    
    public Atleti(int _pettorale, int _eta, int _prestazione){
        pettorale=_pettorale; eta=_eta; prestazione=_prestazione;}
    
    public boolean minoreDi(Object altroAtleta){
        if(altroAtleta==null || !(altroAtleta instanceof Atleti))
        return false;
        
        else {
        double indicePrestazioneQuestoAtleta =
        prestazione - coefficienteEta*eta;
        double indicePrestazioneAltro =((Atleti)altroAtleta).prestazione - coefficienteEta*((Atleti)altroAtleta).eta;
        return indicePrestazioneQuestoAtleta < indicePrestazioneAltro;
        }
    }
    
    public boolean maggioreDi(Object altroAtleta){  
        return ! minoreDi(altroAtleta);
    }
    
    public String toString(){
        return "\n\n Pettorale: "+pettorale+"\n Prestazione: "+prestazione+"\n Età: "+eta;
    }
    
}
