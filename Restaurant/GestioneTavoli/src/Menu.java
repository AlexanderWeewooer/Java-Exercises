
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Utente
 */
public class Menu {
    
    private ArrayList<Cibo> menu;
    
    public Menu(){
        this.menu = new ArrayList();
    }
    
    public int getSizeMenu(){
        return this.menu.size();
    }
    
    public Cibo getIndex(int i){
        return this.menu.get(i);
    }
    
    public String getNomeCibo(int i){
        return (this.menu.get(i)).getNome();
    }
    
    public void addToMenu(Cibo item){
        this.menu.add(item);
    }
    
    public void removeFromMenu(Cibo item){
        this.menu.remove(item);
    }
    
    public String toString(){
        String esc=" \n Menu' \n ---------- \n";
        String bevande=" \n ----- BEVANDE ----- \n ";
        String piatti=" \n ----- PIATTI ----- \n ";
        for(int i=0;i<menu.size();i++){
            if(menu.get(i) instanceof Bevande){
                bevande=bevande+(menu.get(i)).toString();
            }
            else{
                piatti=piatti+(menu.get(i)).toString();
            }
        }
        esc=esc+bevande+piatti+" \n\n ---------- \n ";
        return esc;
    }
    
}
