/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lettoremultimediale;

/**
 *
 * @author Studente
 */
public abstract class Multimedia implements Interfaccia {
    
    String nome;
    
    public Multimedia(String nome){
        this.nome=nome;
    }
    
    @Override
    public String toString(){
        return "\n Nome: "+ nome;
    }
    
}
