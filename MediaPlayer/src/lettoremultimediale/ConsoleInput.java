package lettoremultimediale;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Studente
 */
public class ConsoleInput {
     public BufferedReader input;
    
    public ConsoleInput(){
        InputStreamReader mioInput = new InputStreamReader(System.in);
        input = new BufferedReader(mioInput);
    }
    
    public int readInt()throws IOException{
        String numero;
        int num = 0;
            numero=input.readLine();
            try{
                num=Integer.parseInt(numero);    
            }catch (NumberFormatException e){
                System.out.println("\n Non hai inserito un numero! ");
            }
        return num;
    }
        
    public double readDouble(){
        String doubl="";
        double num;
        try {
            doubl = input.readLine();
        } catch (IOException ex) {
            System.out.println("\n Errore di input ! ");
        }
        num=Double.parseDouble(doubl);
         return num;
    }
    
    public String readLine() throws IOException{
        String stringa = input.readLine();
        return stringa;
    }
}
