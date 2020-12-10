/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Charly Ponce
 */
public class Principal {
    public static void main(String[] args) throws Exception {
        String folderPath = System.getProperty(("user.dir"));
    	
        String r1 = folderPath.concat("/src/codigo/Lexer.flex");
        String r2 = folderPath.concat("/src/codigo/LexerCup.flex");
        String r3 = folderPath.concat("/src/codigo/Sintax.cup");
        
        String[] rS = {"-parser", "Sintax", r3};
        
        generar(r1, r2, rS);
    }
    
    public static void generar(String r1, String r2, String[] rS) throws IOException, Exception{
    	String folderPath = System.getProperty(("user.dir"));    	
    	File archivo = new File(r1);
        JFlex.Main.generate(archivo);
        File archivo2 = new File(r2);
        JFlex.Main.generate(archivo2);
        java_cup.Main.main(rS);
        
        Path rSym = Paths.get(folderPath.concat("/src/codigo/sym.java"));
        if (Files.exists(rSym)) Files.delete(rSym);
        Files.move(
                Paths.get(folderPath.concat("/sym.java")), 
                Paths.get(folderPath.concat("/src/codigo/sym.java"))
        );
        Path rSin = Paths.get(folderPath.concat("/src/codigo/Sintax.java"));
        if (Files.exists(rSin)) Files.delete(rSin);
        Files.move(
        		Paths.get(folderPath.concat("/Sintax.java")),
                Paths.get(folderPath.concat("/src/codigo/Sintax.java"))
        );
    }
}