/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GiocoGrafica.grafica;

import GiocoGrafica.pacchettogioco.AutoPlayer;
import GiocoGrafica.pacchettogioco.ConsoleInput;
import GiocoGrafica.pacchettogioco.Player;
import GiocoGrafica.pacchettogioco.carte.Carta;
import GiocoGrafica.pacchettogioco.carte.Deck;
import GiocoGrafica.pacchettogioco.carte.Oggetti;
import GiocoGrafica.pacchettogioco.personaggi.Eroe;
import GiocoGrafica.pacchettogioco.personaggi.Licantropo;
import GiocoGrafica.pacchettogioco.personaggi.Vampiro;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Studente
 */
public final class Partita extends JFrame{
    
// finestra    
    private JFrame win; 
    private Window finestra;
    private JButton indietro;
    private JTextField nome;
    private JLabel scritta;
    
    //Panel
    private JPanel basePanel = new JPanel();
    private JPanel nome_inserisci;
    private JPanel visualizza_nome;
    private JPanel inizio;
    
    //Variabili utili
    private String nome_player;
    private Carta carta_ingiocoP;
    private Carta carta_ingiocoA;
    
    //Bottoni
    JButton online;
    JButton locale;
    JButton uscita;
    
        
        public Partita(Window finestra) {
            
            //BASE PANEL
            finestra.setVisibility(false);
            nome_inserisci = new JPanel();
            visualizza_nome = new JPanel();
            inizio = new JPanel();
            
            win = new JFrame("Partita"); // finestra
            win.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            win.setUndecorated(true);
            win.add(basePanel);
            
            //BOTTONI
            indietro = new JButton("Torna al Menù");
            indietro.addActionListener((ActionEvent e) -> {
                finestra.setVisibility(true);
                win.setVisible(false);
                dispose();
            });
            uscita = new JButton("Uscita");
            uscita.addActionListener((ActionEvent e) -> {
            if (JOptionPane.showConfirmDialog(this,"Vuoi uscire?","Gioco",
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                    System.exit(0);
            });
            
            //INIZIO
            scritta = new JLabel("La partita sta per iniziare!");
            inizio.add(scritta);
            inizio.add(indietro);
            this.switchto(inizio);
            
            //bottone di chiusura
            win.setSize(1000,1000);
            win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            win.setVisible(false); 
            
            nome();
            
        }
        
        public void setVisibility(boolean b){
            win.setVisible(b);
        }
        
        public void switchto(JPanel pannello){
            basePanel.removeAll();
            basePanel.add(pannello);
            basePanel.revalidate();
            basePanel.repaint();
        }
        
        public String getNome(){
            return nome_player;
        }
        
        public String nome(){
            
            nome = new JTextField(20);
            JPanel spazio = new JPanel();
            spazio.add(Box.createRigidArea(new Dimension(100, 100)));
            nome_inserisci.add(spazio);
            nome_inserisci.add(new JLabel("Inserisci il tuo nome: "));
            nome_inserisci.add(nome);
            JButton submit_name = new JButton("Conferma");
            nome_inserisci.add(submit_name,BorderLayout.CENTER);
            this.switchto(nome_inserisci);
            
            //Azioni bottoni
            submit_name.addActionListener((ActionEvent e) -> {
                
                JPanel centerPanel = new JPanel();
                BoxLayout boxlayout = new BoxLayout(centerPanel, BoxLayout.Y_AXIS);
                centerPanel.setLayout(boxlayout);
                centerPanel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
                
                this.nome_player=nome.getText();
                centerPanel.add(new JLabel("Iniziamo la partita "+nome.getText()+" !"),BorderLayout.NORTH);
                locale = new JButton("Gioca in LOCALE");
                online = new JButton("Gioca ONLINE");
                
                centerPanel.add(Box.createRigidArea(new Dimension(0, 40)));
                centerPanel.add(online);
                centerPanel.add(Box.createRigidArea(new Dimension(0, 40)));
                centerPanel.add(locale);
                centerPanel.add(Box.createRigidArea(new Dimension(0, 40)));
                centerPanel.add(indietro);
                centerPanel.add(Box.createRigidArea(new Dimension(0, 40)));
                centerPanel.add(uscita);
                
                //actionlistener
                online.addActionListener((ActionEvent f) -> {
                    online();
                });
                locale.addActionListener((ActionEvent f) -> {
                    locale();
                });
                
                visualizza_nome.add(centerPanel);
                this.switchto(visualizza_nome);

            });
           return nome.getText();
           
        }

    public void locale() {
        
         
        Deck Tramogena = new Deck();
        Deck Oggetti = new Deck();
        Player player = new Player(nome_player);
        AutoPlayer computer = new AutoPlayer("Avversario");

        
        for (int i = 0; i < 16; i++) {
            Carta current = new Eroe("Eroe");
            Tramogena.aggiungiCarta(current);
        }
        for (int i = 0; i < 14; i++) {
            Carta current = new Licantropo("Licantropo");
            Tramogena.aggiungiCarta(current);
        }
        for (int i = 0; i < 10; i++) {
            Carta current = new Vampiro("Vampiro");
            Tramogena.aggiungiCarta(current);
        }

        // Insert objects
        for (int i = 0; i < 7; i++) {
            Oggetti current = new Oggetti("Carta Panino (x Umano)", false, "+1 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }
        for (int i = 0; i < 7; i++) {
            Oggetti current = new Oggetti("Bolla di sangue (x Vampiro)", false, "+1 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }
        for (int i = 0; i < 3; i++) {
            Oggetti current = new Oggetti("Redbull (x Umano)", false, "x1.5 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }
        for (int i = 0; i < 3; i++) {
            Oggetti current = new Oggetti("Bolla di sangue (x Vampiro dalla Principessa)", false, "x1.5 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }
        for (int i = 0; i < 9; i++) {
            Oggetti current = new Oggetti("Gatto Nero (x Umano)", true, "-1 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }
        for (int i = 0; i < 9; i++) {
            Oggetti current = new Oggetti("Aglio (x Vampiro)", true, "-1 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }
        for (int i = 0; i < 1; i++) {
            Oggetti current = new Oggetti("Paletto d'Argento (x Vampiro)", true, "Elimina il personaggio");
            Oggetti.aggiungiCarta(current);
        }
        for (int i = 0; i < 1; i++) {
            Oggetti current = new Oggetti("Fulmine (x Umano)", true, "Elimina il personaggio");
            Oggetti.aggiungiCarta(current);
        }
        for (int i = 0; i < 3; i++) {
            Oggetti current = new Oggetti("Carne (x Licantropo)", false, "+1 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }
        for (int i = 0; i < 2; i++) {
            Oggetti current = new Oggetti("Luna (x Licantropo)", false, "x1.5 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }
        for (int i = 0; i < 4; i++) {
            Oggetti current = new Oggetti("Sole (x Licantropo)", true, "-1 Punti attacco");
            Oggetti.aggiungiCarta(current);
        }
        for (int i = 0; i < 1; i++) {
            Oggetti current = new Oggetti("Pugnale d'Argento (x Licantropo)", true, "Elimina il personaggio");
            Oggetti.aggiungiCarta(current);
        }
        for (int i = 0; i < 10; i++) {
            Oggetti current = new Oggetti("Pozione (x tutti)", false, "+3 Punti vita a tutti");
            Oggetti.aggiungiCarta(current);
        }

        player.pescataIniziale(Tramogena);
        computer.pescataIniziale(Tramogena);
        int Turni = 0;

        
        //---------------------------pannello di scelta---------------------------------------------------
        JPanel locale = new JPanel();
        JPanel manoPlayer = new JPanel();
        JPanel manoAvv = new JPanel();
        JPanel label1 = new JPanel();
        JPanel label2 = new JPanel();
        
        JLabel avvlabel = new JLabel("L'avversario sta scegliendo la sua carta...");
        JLabel playerlabel = new JLabel(nome_player+", scegli la tua carta!");
        
        locale.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
        BoxLayout verticale1 = new BoxLayout(locale, BoxLayout.Y_AXIS);
        BoxLayout orizzontale1 = new BoxLayout(manoPlayer, BoxLayout.X_AXIS);
        BoxLayout orizzontale2 = new BoxLayout(manoAvv, BoxLayout.X_AXIS);

        locale.setLayout(verticale1);
        manoPlayer.setLayout(orizzontale1);
        manoAvv.setLayout(orizzontale2);

        avvlabel.setFont(new Font("Arial", Font.PLAIN, 24));
        playerlabel.setFont(new Font("Arial", Font.PLAIN, 24));
        
        label2.add(avvlabel);
        label1.add(playerlabel);
        label1.add(Box.createRigidArea(new Dimension(40, 40)));
        label2.add(Box.createRigidArea(new Dimension(40, 40)));
        
        ArrayList<Carta> manoplayer = player.getMano();
        ArrayList<Carta> manoavv = computer.getMano();
        for (int i = 0; i < 5; i++) {
            
            JButton cartap = new JButton(manoplayer.get(i).toString());
            cartap.setFont(new Font("Arial", Font.PLAIN, 17));
            manoPlayer.add(Box.createRigidArea(new Dimension(40, 40)));
            manoPlayer.add(cartap);
            
            JButton cartaa = new JButton(manoavv.get(i).toString());
            cartaa.setFont(new Font("Arial", Font.PLAIN, 17));
            manoAvv.add(Box.createRigidArea(new Dimension(40, 40)));
            manoAvv.add(cartaa);
            
            final Carta carta_corrente = manoplayer.get(i);
            
            cartap.addActionListener((ActionEvent f) -> {
                carta_ingiocoP = carta_corrente;
                locale_partita(Tramogena,Oggetti,computer,player,carta_ingiocoP);
            });
            
        }        
        
        locale.add(label2);
        locale.add(manoAvv);
        
        //panel intermedio
        JPanel spazio = new JPanel();
        spazio.add(Box.createRigidArea(new Dimension(40, 200)));
        locale.add(spazio);
        
        locale.add(label1);
        locale.add(manoPlayer);
        
        JPanel sceglicarte = new JPanel();
        sceglicarte.add(locale, BorderLayout.CENTER);
        
        this.switchto(sceglicarte);
    }

    private void locale_partita(Deck Tramogena, Deck Oggetti, AutoPlayer computer, Player player,Carta carta_ingiocoP) {
        
        //Pannello effettivo di gioco
        //-------------------------------------PANNELLO GIOCO-------------------------------------------
        //Pannelli
        JPanel pannello_gioco = new JPanel();
        pannello_gioco.setBorder(new EmptyBorder(new Insets(150,200,150,200)));
        JPanel sinistra = new JPanel();
        JPanel destra = new JPanel();
        JPanel centrale = new JPanel();
        //Boxlayout
        BoxLayout layout = new BoxLayout(pannello_gioco,BoxLayout.X_AXIS);
        pannello_gioco.setLayout(layout);
        BoxLayout layoutsinistra = new BoxLayout(sinistra,BoxLayout.Y_AXIS);
        sinistra.setLayout(layoutsinistra);
        BoxLayout layoutdestra = new BoxLayout(destra,BoxLayout.Y_AXIS);
        destra.setLayout(layoutdestra);
        BoxLayout layoutcentrale = new BoxLayout(centrale,BoxLayout.Y_AXIS);
        centrale.setLayout(layoutcentrale);
        //-----------------------------------PANNELLO GIOCO sinistra-----------------------------------
        //ESCI
        JPanel esci = new JPanel();
        JButton menu = new JButton("Menu");
        menu.addActionListener((ActionEvent e) -> {
            if (JOptionPane.showConfirmDialog(this,"<html>Tornare al menù?<br>I tuoi progressi non verranno salvati!</html>","Gioco",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                this.switchto(visualizza_nome);
            }    
        });
        esci.add(menu);
        esci.add(uscita);
        sinistra.add(esci);
        //MONETA E GIORNO/NOTTE
        
        pannello_gioco.add(sinistra);
        pannello_gioco.add(Box.createRigidArea(new Dimension(40, 40)));
        pannello_gioco.add(centrale);
        pannello_gioco.add(Box.createRigidArea(new Dimension(40, 40)));
        pannello_gioco.add(destra);
        
        //Da qui c'è la schermata di gioco vera e propria, ma prima una transizione
        //Ci serve, cambiare pannello: sapere chi inzia e il dado della notte o giorno quanto ha dato
        //------------------------------------CHI INIZIA E GIORNO E NOTTE----------------------------------------------
        ImageIcon giorno_notte; ImageIcon moneta;
        JPanel chiquando = new JPanel();
        JLabel monetaLabel;
        chiquando.setBorder(new EmptyBorder(new Insets(150,200,150,200)));
        BoxLayout box = new BoxLayout(chiquando,BoxLayout.Y_AXIS);
        chiquando.setLayout(box);
        
        JButton continua = new JButton("Continua");
        continua.addActionListener((ActionEvent e) -> {
                this.switchto(pannello_gioco);
        });
        
            //Scritta di chi inizia
            JLabel chi = new JLabel("");
            int max1=2; int min1=1;
            int range1 = max1 - min1 + 1;
            int risultato_chi = (int)(Math.random() * range1) + min1;
            if(risultato_chi==1){
                chi.setText("<html>La moneta mostra "+risultato_chi+"!<br> Inizi tu,"+nome_player+"!</html>");
                moneta = new ImageIcon("img\\inizia1.png");
                monetaLabel = new JLabel(moneta);
            }
            else{
                chi.setText("<html>La moneta mostra "+risultato_chi+"!<br> Inizia l'avversario!</html>");
                moneta = new ImageIcon("img\\inizia2.png");
                monetaLabel = new JLabel(moneta);
            }        
            //Scritta della luna piena
            JLabel luna = new JLabel("");
            int risultato_luna = estrazioneLuna(player,computer);
            if(risultato_luna==10){
                luna.setText("<html>Il dado mostra "+risultato_luna+"!<br> C'è la luna piena, i Licantropi si trasformano in mostri!</html>");
            }
            else{
                luna.setText("<html>Il dado mostra "+risultato_luna+"!<br> Non c'è la luna piena!</html>");
            }
        
        chi.setFont(new Font("Arial", Font.PLAIN, 24));
        luna.setFont(new Font("Arial", Font.PLAIN, 24));
        chi.setSize(400,200);
        luna.setSize(400,200);
        chiquando.add(Box.createRigidArea(new Dimension(40, 40)));
        chiquando.add(chi,BorderLayout.CENTER);
        chiquando.add(monetaLabel,BorderLayout.CENTER);
        chiquando.add(Box.createRigidArea(new Dimension(40, 40)));
        chiquando.add(luna,BorderLayout.CENTER);
        chiquando.add(Box.createRigidArea(new Dimension(40, 40)));
        chiquando.add(continua);
        switchto(chiquando);
        

        
        
        
    }
        
    public void online(){
            JPanel online = new JPanel();
            JLabel scritta1 = new JLabel("La modalità online non è ancora disponibile!");
            JButton menu = new JButton("Torna al Menù");
            
            BoxLayout boxlayout = new BoxLayout(online, BoxLayout.Y_AXIS);
            online.setLayout(boxlayout);
            online.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
            menu.addActionListener((ActionEvent f) -> {
                  this.switchto(visualizza_nome);  
            });
            
            online.add(scritta1, BorderLayout.CENTER);
            online.add(menu,BorderLayout.CENTER);
            
            this.switchto(online);
        }
    
    public int estrazioneLuna(Player player, AutoPlayer computer){
                    
        //Variabili utili
        int max2=10; int min2=1;
        int range2 = max2 - min2 + 1;

        
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
        return rand2;
    } 
}
