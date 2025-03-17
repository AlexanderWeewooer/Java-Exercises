
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Utente
 */
public class Ristorante {
    
    //Classe che gestisce l'ArrayList Ristorante, potenzialmente ottimizzabile per la gestione di più ristoranti
    
    //Attributi
    private ArrayList<Tavolo> ristorante;
    private String nome="";
    private int anno=0;             //la variabile nome, anno e Proprietario vengono usare per abbellire la stampa
    private String Proprietario="";
    
    public Ristorante(String nome, int anno, String prop){
        this.nome=nome;
        this.anno=anno;
        this.Proprietario=prop;
        this.ristorante = new ArrayList();
    }
    
    public void addTavolo(Tavolo tavolo){
        this.ristorante.add(tavolo);
    }
    
    public void removeTavolo(Tavolo tavolo){
        this.ristorante.remove(tavolo);
    }
    
    public String toString(){
        String esc="\n ---------- \n";
        esc=esc+" \n "+nome+" \n "+Proprietario+" \n Dal "+anno+ " \n ";
        esc=esc+"\n ---------- \n";
        for(int i=0;i<ristorante.size();i++){
            esc=esc+(ristorante.get(i)).toString();
        }
        esc=esc+"\n ---------- \n";
        return esc;
    }
    
}
