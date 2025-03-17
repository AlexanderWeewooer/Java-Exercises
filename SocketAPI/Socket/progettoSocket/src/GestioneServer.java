/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Studente
 */
//librerie
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.lang.Math;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Double.*;

public class GestioneServer {
    
    /*1:Echo Server ToUpperCase
    2:Calcolo aree di figure geometriche
    3:Conversione da euro a dollaro/bitcoin/etherium/dogecoin/oro.*/

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(3268)) {
            System.out.println("Server avviato sulla porta 3268");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connesso");
                try (
                        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true)
                ) {
                    String line;
                    while ((line = input.readLine()) != null) {
                        switch (line) {
                            case "1": { // Echo Server ToUpperCase
                                output.println("Hai scelto il toUpperCase, inserisci la stringa da convertire: ");
                                String lowercase = input.readLine();
                                if (lowercase != null && !lowercase.isEmpty()) {
                                    output.println("Risultato: " + lowercase.toUpperCase());
                                } else {
                                    output.println("Errore: Stringa non valida.");
                                }
                                output.println("Fine");
                                break;
                            }

                            case "2": { // Calcolo aree geometriche
                                output.println("Calcola le aree di queste figure geometriche! 1=Quadrato 2=Cerchio 3=Triangolo");
                                String figura = input.readLine();
                                switch (figura) {
                                    case "1": {
                                        output.println("Hai scelto il Quadrato! Inserisci la misura del lato: ");
                                        try {
                                            int lato = Integer.parseInt(input.readLine());
                                            output.println("Area del quadrato: " + (lato * lato));
                                        } catch (NumberFormatException e) {
                                            output.println("Errore: Inserisci un numero valido.");
                                        }
                                        break;
                                    }
                                    case "2": {
                                        output.println("Hai scelto il Cerchio! Inserisci la misura del raggio: ");
                                        try {
                                            int raggio = Integer.parseInt(input.readLine());
                                            output.println("Area del cerchio: " + (Math.PI * raggio * raggio));
                                        } catch (NumberFormatException e) {
                                            output.println("Errore: Inserisci un numero valido.");
                                        }
                                        break;
                                    }
                                    case "3": {
                                        output.println("Hai scelto il Triangolo! Inserisci base e altezza separatamente:");
                                        try {
                                            int base = Integer.parseInt(input.readLine());
                                            int altezza = Integer.parseInt(input.readLine());
                                            output.println("Area del triangolo: " + (base * altezza / 2));
                                        } catch (NumberFormatException e) {
                                            output.println("Errore: Inserisci numeri validi.");
                                        }
                                        break;
                                    }
                                    default:
                                        output.println("Errore: Scelta non valida.");
                                        break;
                                }
                                output.println("Fine");
                                break;
                            }

                            case "3": { // Conversione valute

                                output.println("Immetti l'importo in euro da convertire: ");
                                try {
                                    double importo = Double.parseDouble(input.readLine());
                                    output.println("In quale valuta vuoi convertirlo? 1=Dollari 2=Bitcoin 3=Ethereum 4=Dogecoin");
                                    String valuta = input.readLine();
                                    switch (valuta) {
                                        case "1":
                                            TassiCambio tasso_dollari= new TassiCambio("USD");
                                            double tasso1 = tasso_dollari.getTasso();
                                            output.println("Importo convertito: " + (importo * tasso1) + " $");
                                            break;
                                        case "2":
                                            double tasso2 = 0.000025;
                                            output.println("Importo convertito: " + (importo * tasso2) + " BTC");
                                            break;
                                        case "3":
                                            double tasso3 = 0.00035;
                                            output.println("Importo convertito: " + (importo * tasso3) + " ETH");
                                            break;
                                        case "4":
                                            double tasso4 = 0.15;
                                            output.println("Importo convertito: " + (importo * tasso4) + " DOGE");
                                            break;
                                        default:
                                            output.println("Errore: Scelta non valida.");
                                            break;
                                    }
                                } catch (NumberFormatException e) {
                                    output.println("Errore: Inserisci un numero valido.");
                                }
                                output.println("Fine");
                                break;
                            }

                            default:
                                output.println("Errore: Comando non valido.");
                                output.println("Fine");
                                break;
                        }
                    }
                } finally {
                    clientSocket.close();
                    System.out.println("Client disconnesso");
                }
            }
        }
    }


    }
