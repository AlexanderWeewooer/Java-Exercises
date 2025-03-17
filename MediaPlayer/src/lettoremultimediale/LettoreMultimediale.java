/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lettoremultimediale;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Studente
 */
public class LettoreMultimediale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        /*  
            
            Multimedia() + metodo toString()
        
            Immagine(int luminosità) +  metodo show
            Filmato(int durata, int volume, int luminosità))+  metodo play, weaker, louder, darker, brighter
            Registrazione audio(int durata, int volume)+  metodo play, weaker, louder
            
            Interfaccia: show, play, weaker, louder, darker, brighter
            
        */
        
        /*
        PROVE VARIE
        
        Multimedia i1 = new Immagine("Cane",6200);
        i1.show();
        i1.darker(1000);
        i1.show();
        i1.brighter(40);
        i1.show();
        
        Multimedia f1 = new Filmato("Gattino",10,80,50);
        f1.show();
        f1.play();
        
        
        Multimedia r1 = new Registrazione("Corsa",10,60);
        r1.show();
        r1.play();
        
        */
        
        int flag=0;
        int choice=0;
        System.out.println("");
        ConsoleInput console = new ConsoleInput();
        ArrayList<Multimedia> lista= new ArrayList();
        
            System.out.println("\n Inserire i 5 multimedia:\n ");
            for(int i=0; i<5; i++){
                System.out.println(" Nome del multimedia: ");
                String nome = console.readLine(); 
                System.out.println("\n Tipo: [1=Immagine, 2=Filmato, 3=Registrazione] \n Scelta: ");
                int scelta = console.readInt();
                switch(scelta){
                    case 1:
                        System.out.println("\n Inserire la luminosità da 0 a 100: ");
                        int luminosita1= console.readInt();
                        Multimedia immagine= new Immagine(nome,luminosita1);
                        lista.add(immagine);
                        break;
                    case 2:
                        System.out.println("\n Inserire la durata: ");
                        int durata1= console.readInt();
                        System.out.println("\n Inserire la luminosità da 0 a 100: ");
                        int luminosita2= console.readInt();
                        System.out.println("\n Inserire il volume da 0 a 100: ");
                        int volume= console.readInt();
                        Multimedia filmato= new Filmato(nome,durata1,volume,luminosita2);
                        lista.add(filmato);
                        break;
                    case 3:
                        System.out.println("\n Inserire la durata: ");
                        int durata2= console.readInt();
                        System.out.println("\n Inserire il volume da 0 a 100: ");
                        int volume2= console.readInt();
                        Multimedia registrazione= new Registrazione(nome,durata2,volume2);
                        lista.add(registrazione);
                        break;
                    default:
                        break;
                }
            }
        
        while(flag==0){
            
            System.out.println("\n ------ MENU ------ \n");
            System.out.println(" Selezione l'elemento con cui vuoi interagire: \n 1. 2. 3. 4. 5. qualsiasi altro numero per uscire! \n ");
            choice= console.readInt();
            switch(choice){
                case 1:
                    System.out.println("\n ** menù dell'elemento **");break;
                case 2:
                   System.out.println("\n ** menù dell'elemento **");break;
                case 3:
                    System.out.println("\n ** menù dell'elemento **");break;
                case 4:
                    System.out.println("\n ** menù dell'elemento **");break;
                case 5:
                    System.out.println("\n ** menù dell'elemento **");break;
                default:
                    flag=1;
                    break;
            }
            
            
        }
        
    }
    
}
