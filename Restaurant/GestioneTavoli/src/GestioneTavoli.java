/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Studente
 */
public class GestioneTavoli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Ristorante LaFenice= new Ristorante("LaFenice",1982,"Max Frosinone");
       // System.out.println(LaFenice.toString());
        
        Tavolo tavolo1 = new Tavolo(5);
       // System.out.println(tavolo1.toString());
        
        LaFenice.addTavolo(tavolo1);
        System.out.println(LaFenice.toString());
        
        Menu menu= new Menu();
        Cibo Caffe= new Bevande("Caffe'",3.5,"Media",false);
        Cibo Pasta= new Piatti("Pasta",5.0,false,"Primo piatto");
        
        tavolo1.assegnaTavolo(5);
        menu.addToMenu(Caffe);
        menu.addToMenu(Pasta);

        System.out.println(menu.toString());
        tavolo1.addMenuToTavolo(menu);
        tavolo1.iniziaOrdinazioni();
        System.out.println(tavolo1.liberaTavolo());
    }
    
}
