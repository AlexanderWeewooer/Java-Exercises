/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lettoremultimediale;

/**
 *
 * @author Studente
 */
public interface Interfaccia {
    public void show();
    public void play();
            
    public void weaker(int volume);
    public void louder(int volume);
            
    public void darker(int decrease);
    public void brighter(int increase);
}
