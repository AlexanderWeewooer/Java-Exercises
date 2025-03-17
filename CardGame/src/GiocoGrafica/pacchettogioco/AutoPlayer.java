/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GiocoGrafica.pacchettogioco;

import java.io.IOException;
import GiocoGrafica.pacchettogioco.carte.Oggetti;
import GiocoGrafica.pacchettogioco.carte.Carta;
import GiocoGrafica.pacchettogioco.carte.Deck;
import GiocoGrafica.pacchettogioco.personaggi.Licantropo;
import GiocoGrafica.pacchettogioco.personaggi.Eroe;
import GiocoGrafica.pacchettogioco.personaggi.Vampiro;
import java.util.ArrayList;

/**
 *
 * @author Studente
 */
public class AutoPlayer {
          
    //ATTRIBUTI
    private String nome; //Nome del player
    private int LP=0; //Punti vita del player (se arrivano a 0 perde)
    private ArrayList mano; //lista delle carte in mano
    private int counter_mano=0; //conta quante carte si ha in mano
    private int max_mano=5; //massimo dell carte che si possono avere in mano (usate per la prima pescata)
    private Carta carta_in_gioco;
    private ConsoleInput input;
    
    
    //COSTRUTTORE
    public AutoPlayer(String nome){
        this.nome=nome;
        mano = new ArrayList();
        LP=40;
        input = new ConsoleInput();
    }
    
    //SET
    public void setLP(int new_LP){LP=LP-new_LP;}
    public void setCartaInGioco(Carta carta){
        carta_in_gioco=carta;
        counter_mano--;
        mano.remove(carta);
    }
    public void cambiaCartaInGioco(Carta carta){
        mano.add(carta_in_gioco);
        carta_in_gioco=carta;
        mano.remove(carta);
    }
    
    //GET
    public int getLP(){return LP;}
    public String getNome(){return nome;}
    public Carta getCartaInGioco(){return carta_in_gioco;}
    public ArrayList getMano() {
        return mano;
    }
    
    //METODI
    public boolean usaCarta(Carta personaggio, Oggetti oggetto){
        if("Carta Panino (x Umano)".equals(oggetto.getNome())&&personaggio instanceof Eroe){
            Eroe current = (Eroe) personaggio;
            current.cartaPanino();
            System.out.println("\n Usata la carta panino! +1 PA per l'Eroe!");
        }
        else if("Bolla di sangue (x Vampiro)".equals(oggetto.getNome())&&personaggio instanceof Vampiro){
            Vampiro current = (Vampiro) personaggio;
            current.cartaBollaClassica();
            System.out.println("\n Usata la carta bolla di sangue! +1 PA per il Vampiro!");
        }
        else if("Redbull (x Umano)".equals(oggetto.getNome())&&personaggio instanceof Eroe){
            Eroe current = (Eroe) personaggio;
            current.cartaRedbull();
            System.out.println("\n Usata la carta redbull! x1.5 PA per l'Eroe!");
        }
        else if("Bolla di sangue (x Vampiro dalla Principessa)".equals(oggetto.getNome())&&personaggio instanceof Vampiro){
            Vampiro current = (Vampiro) personaggio;
            current.cartaBollaPrincipessa();
            System.out.println("\n Usata la carta bolla di sangue della principessa! x1.5 PA per il Vampiro!");
        }
        else if("Gatto Nero (x Umano)".equals(oggetto.getNome())&&personaggio instanceof Eroe){
            Eroe current = (Eroe) personaggio;
            current.cartaGatto();
            System.out.println("\n Usata la carta gatto nero! -1 PA per l'Eroe avversario!"); 
        }
        else if("Aglio (x Vampiro)".equals(oggetto.getNome())&&personaggio instanceof Vampiro){
            Vampiro current = (Vampiro) personaggio;
            current.cartaAglio();
            System.out.println("\n Usata la carta aglio! -1 PA per il Vampiro!");
        }
        else if("Paletto d'Argento (x Vampiro)".equals(oggetto.getNome())&&personaggio instanceof Vampiro){
            Vampiro current = (Vampiro) personaggio;
            current = null;
            System.out.println("\n Usata la paletto d'argento! Vampiro eliminato!");
        }
        else if("Fulmine (x Umano)".equals(oggetto.getNome())&&personaggio instanceof Eroe){
            Eroe current = (Eroe) personaggio;
            current = null;
            System.out.println("\n Usata la carta fulmine! Eroe eliminato!");
        }
        else if("Carne (x Licantropo)".equals(oggetto.getNome())&&personaggio instanceof Licantropo){
            Licantropo current = (Licantropo) personaggio;
            current.carne();
            System.out.println("\n Usata la carta carne! +1 PA per il Licantropo!");
        }
        else if("Luna (x Licantropo)".equals(oggetto.getNome())&&personaggio instanceof Licantropo){
            Licantropo current = (Licantropo) personaggio;
            current.luna();
            System.out.println("\n Usata la carta luna! x1.5 PA per il Licantropo!");
        }
        else if("Sole (x Licantropo)".equals(oggetto.getNome())&&personaggio instanceof Licantropo){
            Licantropo current = (Licantropo) personaggio;
            current.sole();
            System.out.println("\n Usata la carta sole! -1 PA per il Licantropo!");
        }
        else if("Pugnale d'Argento (x Licantropo)".equals(oggetto.getNome())&&personaggio instanceof Licantropo){
            Licantropo current = (Licantropo) personaggio;
            current = null;
            System.out.println("\n Usata la carta pugnale d'argento! Licantropo eliminato!");
        }
        else if("Pozione (x tutti)".equals(oggetto.getNome())){
            personaggio.pozione();
            System.out.println("\n Usata la carta pozione! +3 PV !");
        }
        else{
            System.out.println("\n Stai cercando di usare questa carta sul tipo di personaggio sbagliato!");
            return false;
        }
        System.out.println("\n Carta oggetto usata!");
        return true;
    }
    
    public void pescataIniziale(Deck deck){
        while(counter_mano<max_mano){
            Carta current = deck.pescaCarta();
            mano.add(current);
            counter_mano++;
        }
    }
    
    public void turno(Deck deck, Deck oggetti, Player p) throws IOException{
       System.out.println("\n Punti vita del player: "+getLP()+" \n");
       
       //formula utile: int rand = (int)(Math.random() * range) + min; + int range = max - min +1;
       int min1=1; int max1=2; int min4=1; int max4=3; //range 2 e 3 messi sotto per necessità
       int range1 = max1 - min1 +1;
       int range4 = max4 - min4 +4;
        
        //IL PLAYER SCEGLIE L'AZIONE SULLE CARTE OGGETTO
        int flag=0;
        while(flag==0){
            System.out.println("\n Scegli l'azione del turno: \n 1) Pesca una carta oggetto \n 2) Gioca una carta oggetto \n Scelta: ");
            //int choice = input.readInt();
            int choice = (int)(Math.random() * range1) + min1;
            ArrayList<Oggetti> oggettiInMano = new ArrayList();
            switch (choice) {
                case 1:
                    //PESCA UNA CARTA OGGETTO
                    this.pesca(oggetti);
                    System.out.println("\n L'avversario ha pescato! Mano aggiornata! \n ");
                    System.out.println(mano);
                    flag=1;
                    break;
                case 2:
                    //GIOCA UNA CARTA OGGETTO
                    for(int i=0;i<mano.size();i++){
                        if(mano.get(i) instanceof Oggetti){
                            oggettiInMano.add((Oggetti) mano.get(i));
                        }
                    }
                    if(oggettiInMano.size()==1){
                        if((oggettiInMano.get(0)).getSuAvversario()){
                            p.usaCarta(p.getCartaInGioco(),oggettiInMano.get(0));
                            flag=1;
                        }
                        else{
                            this.usaCarta(this.getCartaInGioco(),oggettiInMano.get(0));
                            flag=1;
                        }
                    }
                    else if(oggettiInMano.size()>1){
                        int bandierina=0;
                        while(bandierina==0){
                            System.out.println(oggettiInMano);
                            System.out.println("\n Inserisci il numero della carta che vuoi usare ( parte da 0 fino al numero massimo ) : ");
                            //int choice2= input.readInt();
                            int min2=0; int max2=oggettiInMano.size()-1;
                            int range2 = max2 - min2 +1;
                            
                            int choice2= (int)(Math.random() * range2) + min2;
                            if(choice2>=oggettiInMano.size()||choice2<0){
                                System.out.println("\n L'avversario ha scelto una carta non disponibile! ");
                            }
                            else{
                                Oggetti cartascelta = oggettiInMano.get(choice2);
                                if(cartascelta.getSuAvversario()){
                                    p.usaCarta(p.getCartaInGioco(),cartascelta);
                                    bandierina=1;
                                }
                                else{
                                    this.usaCarta(carta_in_gioco, cartascelta);
                                    bandierina=1;
                                }
                            }
                        }
                        flag=1;
                    }
                    else{
                        System.out.println("\n L'avversario non ha nessuna carta da utilizzare! \n");
                    }
                    break;
                default:
                    System.out.println("\n Scelta non valida, riprovare! ");
                    break;
            }
        }
        
        //IL PLAYER SCEGLIE L'AZIONE SULLE CARTE PERSONAGGIO
        int flagp=0;
        while(flagp==0){
            System.out.println("\n Scegli l'azione del turno: \n 1) Cambia la carta in gioco \n 2) Attacca l'avversario \n 3) Passa il turno \n ");
            int choice = (int)(Math.random() * range4) + min4;
            ArrayList<Carta> personaggiInMano = new ArrayList();
            switch (choice) {
                case 1:
                    //CAMBIA LA CARTA IN GIOCO
                    for(int i=0;i<mano.size();i++){
                        if(mano.get(i) instanceof Eroe||mano.get(i) instanceof Vampiro||mano.get(i) instanceof Licantropo){
                            personaggiInMano.add((Carta) mano.get(i));
                        }
                    }
                    System.out.println(personaggiInMano);
                    System.out.println("\n L'avversario sceglie la carta che mette al posto di quella sul campo : ");
                            //int choice2= input.readInt();
                            int min3=0; int max3=personaggiInMano.size()-1;
                            int range3 = max3 - min3 +1;
                            int choice2 = (int)(Math.random() * range3) + min3;
                            
                            if(choice2>=personaggiInMano.size()||choice2<0){
                                System.out.println("\n L'avversario ha scelto una carta non disponibile! Riprova! ");
                            }
                            else{
                                Carta cartascelta = personaggiInMano.get(choice2);
                                this.cambiaCartaInGioco(cartascelta);
                                flagp=1;
                            }
                    break;
                case 2:{
                    int tu_PA=0;
                    int avv_PA=0;
                    //ATTACCA L'AVVERSARIO
                        
                        //controllo di che tipo è la mia carta
                        if(carta_in_gioco instanceof Eroe){
                            Eroe tu= (Eroe) carta_in_gioco;
                            tu_PA= tu.getPA();
                        }
                        else if(carta_in_gioco instanceof Vampiro){
                            Vampiro tu= (Vampiro) carta_in_gioco;
                            tu_PA= tu.getPA();
                        }
                        else if(carta_in_gioco instanceof Licantropo){
                            Licantropo tu= (Licantropo) carta_in_gioco;
                            tu_PA= tu.getPA();
                        }
                        else{
                            System.out.println("\n La tua carta è stata eliminata devi cambiarla prima di attaccare! \n");
                            break;
                        }
                        
                        //controllo di che tipo è la carta dell'avversario
                        if(p.getCartaInGioco() instanceof Eroe){
                            Eroe avv= (Eroe) p.getCartaInGioco();
                            avv_PA= avv.getPA();
                        }
                        else if(p.getCartaInGioco() instanceof Vampiro){
                            Vampiro avv= (Vampiro) p.getCartaInGioco();
                            avv_PA= avv.getPA();
                        }
                        else if(p.getCartaInGioco() instanceof Licantropo){
                            Licantropo avv= (Licantropo) p.getCartaInGioco();
                            avv_PA= avv.getPA();
                        }
                        else{
                            avv_PA=0;
                        }                        
                        //Aggiorno i punti vita ed elimino i personaggi
                        if(tu_PA>avv_PA){
                            //SE HA VINTO IL PLAYER
                            p.setLP(p.sconfitta());
                            if(p.getCartaInGioco() instanceof Eroe){
                                Eroe avv= (Eroe) p.getCartaInGioco();
                                p.cambiaCartaInGioco(avv.elimina());
                            }
                            else if(p.getCartaInGioco() instanceof Vampiro){
                                Vampiro avv= (Vampiro) p.getCartaInGioco();
                                p.cambiaCartaInGioco(avv.elimina());
                            }
                            else if(p.getCartaInGioco() instanceof Licantropo){
                                Licantropo avv= (Licantropo) p.getCartaInGioco();
                                p.cambiaCartaInGioco(avv.elimina());
                            }
                            flagp=1;
                            System.out.println("\n Battaglia vinta da "+nome+"! \n");
                        }
                        else if(tu_PA==avv_PA){
                            //SE SI HA LA PARITA'
                            p.setLP(p.sconfitta());
                            this.setLP(sconfitta());
                            
                            if(p.getCartaInGioco() instanceof Eroe){
                                Eroe avv= (Eroe) p.getCartaInGioco();
                                p.cambiaCartaInGioco(avv.elimina());
                            }
                            else if(p.getCartaInGioco() instanceof Vampiro){
                                Vampiro avv= (Vampiro) p.getCartaInGioco();
                                p.cambiaCartaInGioco(avv.elimina());
                            }
                            else{
                                Licantropo avv= (Licantropo) p.getCartaInGioco();
                                p.cambiaCartaInGioco(avv.elimina());
                            }
                            
                            if(carta_in_gioco instanceof Eroe){
                                Eroe tu= (Eroe) carta_in_gioco;
                                this.cambiaCartaInGioco(tu.elimina());
                            }
                            else if(carta_in_gioco instanceof Vampiro){
                                Vampiro tu= (Vampiro) carta_in_gioco;
                                this.cambiaCartaInGioco(tu.elimina());
                            }
                            else{
                                Licantropo tu= (Licantropo) carta_in_gioco;
                                this.cambiaCartaInGioco(tu.elimina());
                            }
                            System.out.println("\n Parità! \n");
                            flagp=1;
                        }
                        else{
                            //SE HA VINTO IL COMPUTER
                            this.setLP(sconfitta());
                            
                            if(carta_in_gioco instanceof Eroe){
                                Eroe tu= (Eroe) carta_in_gioco;
                                this.cambiaCartaInGioco(tu.elimina());
                            }
                            else if(carta_in_gioco instanceof Vampiro){
                                Vampiro tu= (Vampiro) carta_in_gioco;
                                this.cambiaCartaInGioco(tu.elimina());
                            }
                            else{
                                Licantropo tu= (Licantropo) carta_in_gioco;
                                this.cambiaCartaInGioco(tu.elimina());
                            }
                            System.out.println("\n Battaglia vinta da "+p.getNome()+"! \n");
                            flagp=1;
                        }
                        
                        
                    break;}
                case 3:{
                    System.out.println("\n Hai passato il turno! ");
                    flagp=1;
                    break;
                }
                default:
                    System.out.println("\n Scelta non valida, riprovare! ");
                    break;
            }
        }
    }
    
    public int sconfitta(){
        return 10;
    }
   
    public Carta pesca(Deck deck){
        Carta current = deck.pescaCarta();
        mano.add(current);
        Carta temp = current;
        deck.eliminaCarta(current);
        counter_mano++;
        return temp;
    }
    
    //TOSTRING e stampe
    @Override
    public String toString(){
        return "\n Player: "+nome+" \n Life Points: "+LP;
    }
    public String manotoString(){
        return "\n ----- Mano di "+nome+" ----- \n"+mano.toString()+"\n";
    }

    
}
