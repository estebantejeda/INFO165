/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;

/**
 *
 * @author HP
 */
public class Principal {
	
    public static void main(String[] args) {
    	String lexerPath = System.getProperty(("user.dir"))+"/src/codigo/Lexer.flex";    	
        generarLexer(lexerPath);
    }
    
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
    
}

