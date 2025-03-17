/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Studente
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GestioneClient {
    
    /*1:Echo Server ToUpperCase
    2:Calcolo aree di figure geometriche
    3:Conversione da euro a dollaro/bitcoin/etherium/dogecoin/oro.*/

    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 3268); //avvia il socket del client
            System.out.println("Connesso al server");

            //input per il server e dal server:
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); //prende dal terminale
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            //inizio del menù
            int flag=0;

            while(flag==0){
                //input menù
                System.out.println("Scegli a quale servizio vuoi accedere! \n1=toUpperCase \n2=Calcolo Aree Geometriche \n3=Conversione valute[da euro a x] \n4=Chiudi \nInput: ");
                String line = input.readLine();
                output.println(line);
                //risposte dal server
                String responses;
                while ((responses = serverInput.readLine()) != null) {
                    System.out.println(responses);
                    if(responses.equals("Fine")){
                        flag=1;
                        return;
                    }
                    switch(line){
                        //fatto a scuola dove Java non prende più case in una sola riga
                        case "1": output.println(input.readLine()); break;
                        case "2": output.println(input.readLine()); break;
                        case "3": output.println(input.readLine()); break;
                        case "4": output.println(input.readLine()); break;
                        default: output.println("Input non corretto, riprovare!"); break;
                    }
                }
            }

            socket.close();

        }catch(IOException e){ //se il socket del client da errore
            e.printStackTrace();
        }
    }

}