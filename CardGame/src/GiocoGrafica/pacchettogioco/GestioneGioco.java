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
public class GestioneGioco {
        
       /* //Deck e Player
        Deck Tramogena = new Deck();
        Deck Oggetti = new Deck();
        Player player = new Player("Giocatore Umano");
        AutoPlayer computer = new AutoPlayer("Giocatore Computer");
        
        //Variabili utili
        int max1=2; int min1=1; int max2=10; int min2=1; int max3=4; int min3=0;
        int range1 = max1 - min1 + 1;
        int range2 = max2 - min2 + 1;
        int range3 = max3 - min3 +1;
        ConsoleInput input = new ConsoleInput();
        
        //Inserimento personaggi
        for(int i=0; i<16; i++){
            Carta current = new Eroe("Eroe");
            Tramogena.aggiungiCarta(current);
        }
        for(int i=0; i<14; i++){
            Carta current = new Licantropo("Licantropo");
            Tramogena.aggiungiCarta(current);
        }
        for(int i=0; i<10; i++){
            Carta current = new Vampiro("Vampiro");
            Tramogena.aggiungiCarta(current);
        }
        
        //Inserimento oggetti
        for(int i=0;i<7;i++){
            Oggetti current = new Oggetti("Carta Panino (x Umano)",false,"+1 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }
        for(int i=0;i<7;i++){
            Oggetti current = new Oggetti("Bolla di sangue (x Vampiro)",false,"+1 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }        
        for(int i=0;i<3;i++){
            Oggetti current = new Oggetti("Redbull (x Umano)",false,"x1.5 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }        
        for(int i=0;i<3;i++){
            Oggetti current = new Oggetti("Bolla di sangue (x Vampiro dalla Principessa)", false,"x1.5 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }
        for(int i=0;i<9;i++){
            Oggetti current = new Oggetti("Gatto Nero (x Umano)",true, "-1 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }
        for(int i=0;i<9;i++){
            Oggetti current = new Oggetti("Aglio (x Vampiro)",true, "-1 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }
        for(int i=0;i<1;i++){
            Oggetti current = new Oggetti("Paletto d'Argento (x Vampiro)",true,"Elimina il personaggio");
            Oggetti.aggiungiCarta(current);
        }
        for(int i=0;i<1;i++){
            Oggetti current = new Oggetti("Fulmine (x Umano)",true,"Elimina il personaggio");
            Oggetti.aggiungiCarta(current);
        }        
        for(int i=0;i<3;i++){
            Oggetti current = new Oggetti("Carne (x Licantropo)",false,"+1 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }        
        for(int i=0;i<2;i++){
            Oggetti current = new Oggetti("Luna (x Licantropo)",false,"x1.5 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }
        for(int i=0;i<4;i++){
            Oggetti current = new Oggetti("Sole (x Licantropo)",true,"-1 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }
        for(int i=0;i<1;i++){
            Oggetti current = new Oggetti("Pugnale d'Argento (x Licantropo)",true,"Elimina il personaggio");
            Oggetti.aggiungiCarta(current);
        }
        for(int i=0;i<10;i++){
            Oggetti current = new Oggetti("Pozione (x tutti)", false, "+3 Punti vita a tutti");
            Oggetti.aggiungiCarta(current);
        }
        
        //System.out.println(Tramogena);
        //System.out.println(Oggetti);
        
        //Test del Player
        System.out.println("\n La partita ha inizio! \n\n Pescate iniziali:");
        player.pescataIniziale(Tramogena);
        computer.pescataIniziale(Tramogena);
        int Turni=0;
        
        
        while (Turni<100) {
            if(computer.getLP()<=0){
                System.out.println("\n Ha vinto il Player Umano!");
                break;
            }
            else if(player.getLP()<=0){
                System.out.println("\n Ha vinto il Computer!");
                break;
            }
            else if(Tramogena.size()==0){
                System.out.println("\n Deck Personaggi finito!");
                if(player.getLP()<computer.getLP()){
                    System.out.println("\n Ha vinto il computer!");
                }
                else{
                    System.out.println("\n Ha vinto il player!");
                }
                break;
            }
            else if(Oggetti.size()==0){
                System.out.println("\n Deck Oggetti finito!");
                if(player.getLP()<computer.getLP()){
                    System.out.println("\n Ha vinto il computer!");
                }
                else{
                    System.out.println("\n Ha vinto il player!");
                }
                break;
            }
            else if(Turni==0){
                ArrayList manop1 = player.getMano();
                ArrayList manop2 = computer.getMano();
                //Mostra la pescata iniziale
                System.out.println("\n ----- PESCATA di "+player.getNome()+" ----- \n");
                System.out.println(player.getMano().toString());
                System.out.println("\n ----- PESCATA di "+computer.getNome()+" ----- \n");
                System.out.println(computer.getMano().toString());
                //Fa scegliere ai player con quale personaggio iniziare
                int flag=0;
                while(flag==0){
                    System.out.println("\n --- Scegliete la carta da mettere in gioco --- \n 0) "+manop1.get(0)+"\n 1) "+manop1.get(1)+"\n 2) "+manop1.get(2)+"\n 3) "+manop1.get(3)+"\n 4) "+manop1.get(4)+"\n Scelta: ");
                    int choice = input.readInt();
                    switch(choice){
                        case 0:{
                            player.setCartaInGioco((Carta) manop1.get(0));
                            flag=1;
                            break;
                        } 
                        case 1:{
                            player.setCartaInGioco((Carta) manop1.get(1));
                            flag=1;
                            break;
                        }
                        case 2:{
                            player.setCartaInGioco((Carta) manop1.get(2));
                            flag=1;
                            break;
                        }
                        case 3:{
                            player.setCartaInGioco((Carta) manop1.get(3));
                            flag=1;
                            break;
                        }
                        case 4:{
                            player.setCartaInGioco((Carta) manop1.get(4));
                            flag=1;
                            break;
                        }
                        default:{
                            System.out.println("\n ! Scelta non valida, riprovare !");
                        }
                    }
                }
                int rand3 = (int)(Math.random() * range3) + min3;
                computer.setCartaInGioco((Carta) manop2.get(rand3));
                System.out.println("\n ----- CARTE IN GIOCO ----- \n\n Player: "+player.getCartaInGioco()+"\n\n Computer: "+computer.getCartaInGioco());
                Turni ++;
            }
            else{  
                Turni++;
                System.out.println("\n ----- TURNO N." + Turni + " ----- ");
                System.out.println("\n Punti vita "+player.getNome()+": "+player.getLP());
                System.out.println("\n Punti vita "+computer.getNome()+": "+computer.getLP());
                System.out.println("\n ----- CARTE IN GIOCO ----- \n\n Player: "+player.getCartaInGioco()+"\n\n3"
                        + " Computer: "+computer.getCartaInGioco());
                
                    //Estrazione 2 (c'è la luna piena?) [10 = si]
                    int rand2 = (int)(Math.random() * range2) + min2;
                    //System.out.println("\n La moneta per il tempo mostra "+rand2+" !");
                    
                    //Se c'è la luna piena tutte le carte Licantropo in mano e nel tavolo vengono settate
                    if(rand2==10){
                        System.out.println("\n !!! C'e' la luna piena !!!");
                        int i=0;
                        ArrayList manop1 = player.getMano();
                        ArrayList manop2 = computer.getMano();
                        if(player.getCartaInGioco() instanceof Licantropo){
                            Licantropo current = (Licantropo) player.getCartaInGioco();
                            current.setLunaPiena(10);
                        }
                        else if(computer.getCartaInGioco() instanceof Licantropo){
                            Licantropo current = (Licantropo) computer.getCartaInGioco();
                            current.setLunaPiena(10);
                        }
                        else if(player.getCartaInGioco() instanceof Licantropo&&computer.getCartaInGioco() instanceof Licantropo){
                            Licantropo current = (Licantropo) player.getCartaInGioco();
                            current.setLunaPiena(10);
                            current = (Licantropo) computer.getCartaInGioco();
                            current.setLunaPiena(10);
                        }
                        
                        while(i<manop1.size()){
                            if(manop1.get(i) instanceof Licantropo){                        
                                Licantropo current = (Licantropo) manop1.get(i);
                                current.setLunaPiena(10);
                            }
                            i++;
                        }
                        while(i<manop2.size()){
                            if(manop2.get(i) instanceof Licantropo){                        
                                Licantropo current = (Licantropo) manop1.get(i);
                                current.setLunaPiena(10);
                            }
                            i++;
                        }
                    }
                    else{
                        //System.out.println("\n !!! Non c'è la luna piena !!!");
                        int i=0;
                        ArrayList manop1 = player.getMano();
                        ArrayList manop2 = computer.getMano();
                        if(player.getCartaInGioco() instanceof Licantropo){
                            Licantropo current = (Licantropo) player.getCartaInGioco();
                            current.setLunaPiena(0);
                        }
                        else if(computer.getCartaInGioco() instanceof Licantropo){
                            Licantropo current = (Licantropo) computer.getCartaInGioco();
                            current.setLunaPiena(0);
                        }
                        else if(player.getCartaInGioco() instanceof Licantropo&&computer.getCartaInGioco() instanceof Licantropo){
                            Licantropo current = (Licantropo) player.getCartaInGioco();
                            current.setLunaPiena(0);
                            current = (Licantropo) computer.getCartaInGioco();
                            current.setLunaPiena(0);
                        }
                        
                        while(i<manop1.size()){
                            if(manop1.get(i) instanceof Licantropo){                        
                                Licantropo current = (Licantropo) manop1.get(i);
                                current.setLunaPiena(0);
                            }
                            i++;
                        }
                        while(i<manop2.size()){
                            if(manop2.get(i) instanceof Licantropo){                        
                                Licantropo current = (Licantropo) manop1.get(i);
                                current.setLunaPiena(0);
                            }
                            i++;
                        }
                    }
                    
                    //Estrazione 1 (chi inizia?) [1 = player, 2 =  computer]
                    int rand1 = (int)(Math.random() * range1) + min1;
                    //System.out.println("\n La moneta per decidere chi inizia mostra "+rand1+" !");
                    if(rand1==1){
                        System.out.println("\n ----- Gioca il player -----");
                        player.turno(Tramogena,Oggetti,computer);
                        System.out.println("\n ----- Gioca il computer -----");
                        computer.turno(Tramogena,Oggetti,player);
                    }
                    else{
                        System.out.println("\n ----- Gioca il computer -----");
                        computer.turno(Tramogena,Oggetti,player);
                        System.out.println("\n ----- Gioca il player -----");
                        player.turno(Tramogena,Oggetti,computer);
                    }
                }

    }System.out.println("\n PARTITA TERMINATA PER TROPPI TURNI! PARITA'!");
}*/
}
