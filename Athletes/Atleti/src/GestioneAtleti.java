/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Studente
 */
public class GestioneAtleti {

    /*
        1) estendere il codice aggiungendo la classe "Ciclisti" . Il main dovrà visualizzare oltre alla classifica degli atleti 
        anche la classifica dei ciclisti in base al tempo di arrivo.
    
        2) il programma dovrà gestire infine un elenco di percorsi. I percorsi hanno forme geometriche diverse (quadrato, 
        rettangolo, triangolo, cerchio). Classificare i percorsi , in ordine decrescente, in base al perimetro.
    
        3) calcolare il tempo di percorrenza del percorso in base alla velocità e il perimetro dati
    */
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        Atleti[] elenco = {new Atleti(1, 19, 12), new Atleti(2, 19, 13),
        new Atleti(3, 29, 14)};
        Ordinatore o = new Ordinatore(elenco);
        Atleti[] classifica = (Atleti[]) o.selectionSortA_Z();
        System.out.println("Classifica");
        for (int i=0; i<classifica.length; i++){
        System.out.println("Pettorale: " + classifica[i].pettorale +" " + (classifica[i].prestazione - Atleti.coefficienteEta*classifica[i].eta));
        }
        
        Ciclisti[] elencoC = {new Ciclisti(1,20), new Ciclisti(2, 15), new Ciclisti(3, 5)};
        Ordinatore oc = new Ordinatore(elencoC);
        Ciclisti[] classificaCiclisti;
        classificaCiclisti = (Ciclisti[]) oc.selectionSortA_Z();
        for (int i=0; i<classificaCiclisti.length; i++){
            System.out.println("Pettorale: " + classificaCiclisti[i].pettorale +"\n Tempo arrivo: "+classificaCiclisti[i].tempo);
        }
        
    }  
    
}
