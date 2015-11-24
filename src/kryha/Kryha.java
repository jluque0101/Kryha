/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryha;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jose
 */
public class Kryha {

    /**
     * @param args the command line arguments
     */
    static String cifrado(String texto, int[] engranaje, int desplazamiento, 
            ArrayList<Character> arrayInterior, ArrayList<Character> arrayExterior){
        String resultado = "";
        
        System.out.println(" --- Cifrando ---");
        
        char[] arrayTexto = texto.toCharArray();
        int posicionesMovidas = engranaje[desplazamiento];
        
        for(int i = 0; i < texto.length(); i++){
            posicionesMovidas = engranaje[desplazamiento];
            System.out.println("Letra a cifrar: "+ arrayTexto[i]);
            System.out.println("Desplazamiento: "+ desplazamiento);
            for(int j = 0; j < posicionesMovidas+4; j++){
                arrayInterior.add(0, arrayInterior.get(arrayInterior.size()-1));
                arrayInterior.remove(arrayInterior.size()-1);
            }
            
         
            System.out.println("La letra cifrada es: "+arrayInterior.get(
                    arrayExterior.indexOf(arrayTexto[i])));
            
            resultado += arrayInterior.get(
                    arrayExterior.indexOf(arrayTexto[i]));
            
            if(desplazamiento>=16)
                desplazamiento=0;
            else
                desplazamiento++;
        }
        
        return resultado;
        
        
    }
    
    public static void main(String[] args) {
        Character[] letrasInterior = {
            'W','G','M','K','R',
            'U','Y','T','B','Z',
            'H','C','N','X','F',
            'D','J','L','P','E',
            'V','O', 'A','Q','S',
            'I', 'W','G','M','K',
            'R', 'U','Y','T','B',
            'Z', 'H','C','N','X',
            'F', 'D','J','L','P',
            'E', 'V','O', 'A','Q',
            'S', 'I'
        };
        
        Character[] letrasExterior = {
            'A','B','C','D','E',
            'F','G','H','I','J',
            'K','L','M','N','O',
            'P','Q','R','S','T',
            'U','V','W','X','Y',
            'Z'
        };
        
        int[] engranaje = {
            5, 3, 2, 3, 1, 2, 3, 2, 4, 2, 6, 1, 2, 1, 3, 2, 1
        };
        
        ArrayList<Character> arrayInterior = new ArrayList<Character>(
                Arrays.asList(letrasInterior)
        );
        
        ArrayList<Character> arrayExterior = new ArrayList<Character>(
                Arrays.asList(letrasExterior)
        );      
        
        System.out.println("--- Estado Inicial ---");
        
        for(int i = 0; i < 26; i++){
            System.out.print(arrayInterior.get(i));
        }
        
        System.out.println();
        
        for(int i = 0; i < 26; i++){
            System.out.print(arrayExterior.get(i));
        }
        
        System.out.println();
            
        
        String textoCifrado = cifrado("HELP", engranaje, 0, arrayInterior, arrayExterior);
        System.out.println("--- Texto cifrado ---");
        System.out.println(textoCifrado);
    }
    
}
