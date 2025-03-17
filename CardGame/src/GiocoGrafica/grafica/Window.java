/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GiocoGrafica.grafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Studente
 */
public class Window{
    
    JFrame win = new JFrame("Gioco"); // finestra   
    JLabel scritta = new JLabel("Benvenuto!"); // scritta iniziale
    JPanel centro = new JPanel();
    JButton start = new JButton("START");
    JButton manuale = new JButton("Manuale del Player");
    JButton uscita = new JButton("Uscita");
    Partita partita = new Partita(this);
    Manuale manuale_player = new Manuale(this);
    
    public Window(){
        
        BoxLayout boxlayout = new BoxLayout(centro, BoxLayout.Y_AXIS);
        centro.setLayout(boxlayout);
        centro.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
        
        //BOTTONI MENU'
        //bottoni
        start.addActionListener((ActionEvent e) -> {
            partita.setVisibility(true);
            win.setVisible(false);
        });
        manuale.addActionListener((ActionEvent e) -> {
            manuale_player.setVisibility(true);
            win.setVisible(false);
        });
        uscita.addActionListener((ActionEvent e) -> {
            if (JOptionPane.showConfirmDialog(win,"Vuoi uscire?","Gioco",
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                    System.exit(0);
        });
        //aggiungo ai panel
        centro.add(Box.createRigidArea(new Dimension(0, 40)));
        centro.add(scritta);
        centro.add(Box.createRigidArea(new Dimension(0, 40)));
        centro.add(start);
        centro.add(Box.createRigidArea(new Dimension(0, 40)));
        centro.add(manuale);
        centro.add(Box.createRigidArea(new Dimension(0, 40)));
        centro.add(uscita);
        //aggiungo alla finestra     
        win.add(centro);
        win.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        win.setUndecorated(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
        
    }

    public void setVisibility(boolean b) {
        win.setVisible(b);
    }

}
