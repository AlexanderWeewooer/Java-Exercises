/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GiocoGrafica.grafica;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Studente
 */
public class Manuale extends JFrame{

    JFrame win; // finestra
    Window finestra;
    JButton indietro = new JButton("Torna al Menù");
    
        public Manuale(Window finestra) {
            
            //Azioni bottoni
            indietro.addActionListener((ActionEvent e) -> {
                finestra.setVisibility(true);
                win.setVisible(false);
            });
            
            //FINESTRA
            finestra.setVisibility(false);
            win = new JFrame("Manuale del Player"); // finestra
            
            //panels
            JPanel nord = new JPanel();
            
            //labels
            JLabel scritta = new JLabel("Regole del gioco!");
            
            //aggiungo ai panels e alla finestra
            nord.add(scritta);
            nord.add(indietro);
            win.add(nord,BorderLayout.NORTH);
            
            //bottone di chiusura
            win.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            win.setUndecorated(true);
            win.setSize(1000,1000);
            win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            win.setVisible(false);
            
        }
        
        public void setVisibility(boolean b){
            win.setVisible(b);
        }
    
}
