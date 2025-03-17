
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Utente
 */
public class Tavolo {
    
    //Attributi
    private int coperti;
    private int ntavolo;
    private ArrayList<Cibo> ordini ;
    private static int prog=1;
    private boolean occupato=false;
    private Menu menu;
    
    public Tavolo(int coperti){
        this.coperti=coperti;
        this.ntavolo=prog++;
        this.ordini= new ArrayList();
    }
    
    public void addMenuToTavolo(Menu menu){
        this.menu=menu;
    }
    
    public void iniziaOrdinazioni(){
        Scanner input= new Scanner(System.in);
        int fine=0;
        while(fine==0){
            this.addOrdine();
            System.out.println("\n Vuoi continuare? [sì=0 | no=1] \n");
            fine=input.nextInt();
        }
    }
    
    public void assegnaTavolo(int persone){
        if(persone==this.coperti&&this.occupato==false){
           this.occupato=true;
        }
        else if (persone!=this.coperti&&occupato==false){
            System.out.println("\n Operazione annullata: tavolo con posti diversi dal numero di persone! ");
        }
        else{
            System.out.println("Operazione annullata: tavolo occupato! ");
        }
    }
    
    public String liberaTavolo(){
        String esc=this.calcolaScontrino();
        this.occupato=false;
        return esc;
    }
    
    public int getCoperti(){
        return coperti;
    }
    
    public void addOrdine(){
        InputStreamReader mioInput=new InputStreamReader(System.in);
        BufferedReader input= new BufferedReader(mioInput);
        System.out.println("\n Inserire un ordine: \n ");
        try{
            String nome =input.readLine();
            System.out.println("\n Ordine ricevuto: "+nome);
            for(int i = 0; i < menu.getSizeMenu();i++ ){
            if(nome.equals(menu.getNomeCibo(i))){
                this.ordini.add(menu.getIndex(i));
                System.out.println("\n Ordine aggiunto! ");
            }
        }
        }catch(Exception nome){
            System.out.println("\n Errore di lettura! ");
        }
       
    }
    
    public void removeOrdine(Cibo ordine){
        this.ordini.remove(ordine);
    }
    
    public String calcolaScontrino(){
        double scontrino=0;
        String esc="\n ----- SCONTRINO TAVOLO "+ntavolo+" ----- \n";
        for(int i=0;i<ordini.size();i++){
            esc=esc+(ordini.get(i)).toString()+"\n";
            scontrino=scontrino+(ordini.get(i)).getPrezzo();
        }
        esc=esc+ "\n\n ----- TOTALE ----- \n     "+scontrino+"$";
        return esc;
    }
    
    public String toString(){
        String esc="";
        esc=esc+"\n Tavolo N."+ntavolo+"\n Coperti: "+coperti+" \n Occupato? "+occupato+"\n";
        for(int i=0;i<ordini.size();i++){
            esc=esc+(ordini.get(i)).toString();
        }
        return esc;
    }
    
}
