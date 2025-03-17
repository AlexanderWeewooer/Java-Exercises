/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GiocoGrafica.pacchettogioco.carte;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Studente
 */
public class Deck {
    
    //ATTRIBUTI
    private ArrayList<Carta> deck;
    Carta carta_pescata;
    
    //COSTRUTTORE
    public Deck(){
        deck=new ArrayList();
    }
    
    //GET
    public ArrayList getDeck(){return deck;}
    
    //SET
    public void aggiungiCarta(Carta c){deck.add(c);}
    public void eliminaCarta(Carta c){deck.remove(c);}
    
    //METODI
    public Carta pescaCarta(){
        Collections.shuffle(deck);
        Carta current=deck.get(0);
        deck.remove(deck.get(0));
        return current;
    }
    public int size(){
        return deck.size();
    }
    
    //TOSTRING
    @Override
    public String toString(){
        return deck.toString();
    }
}
