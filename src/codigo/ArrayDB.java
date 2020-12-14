package codigo;
import java.util.*;
import java.io.*;

public class ArrayDB {
    ArrayList<Array> array = new ArrayList<Array>();
    String fileName = "save.txt";
    FileWriter fw;
    
    public ArrayDB(){
        newFile();
    }

    public int[] showArray(String id){
        readFile();
        int ax[] = null;
        for(int i = 0; i < array.size(); i++){
            if(array.get(i).getName().equals(id)) ax = array.get(i).getArray();
        }
        return ax;
    }

    public int showNumber(String id, int pos){
        readFile();
        int ax = 0;
        for(int i = 0; i < array.size(); i++){
            if(array.get(i).getName().equals(id)) ax = array.get(i).getNumber(pos);
        }
        return ax;
    }

    public void add(String id, int num, int pos){
        readFile();
        for(int i = 0; i < array.size(); i++){
            if(array.get(i).getName().equals(id)) array.get(i).addNumber(num, pos);
        }
        delFile();
        newFile();
        for(int i = 0; i < array.size(); i++) writeFile(array.get(i));
    }

    public void del(String id, int pos){
        readFile();
        for(int i = 0; i < array.size(); i++){
            if(array.get(i).getName().equals(id)) array.get(i).delNumber(pos);
        }
        delFile();
        newFile();
        for(int i = 0; i < array.size(); i++) writeFile(array.get(i));
    }

    /*
    * openFile abre el archivo de texto y añade cada linea que encuentre a una 
    * lista enlazada
    */
    public void readFile(){
        File file = new File(fileName);
        FileReader fr;
        try{
            fr = new FileReader(fileName);
            String s;
            BufferedReader input = new BufferedReader(fr);
            while( (s = input.readLine()) != null){
                StringTokenizer st = new StringTokenizer(s," ");
                String id = st.nextToken();
                int aux[] = {
                    Integer.valueOf(st.nextToken()),
                    Integer.valueOf(st.nextToken()),
                    Integer.valueOf(st.nextToken()),
                    Integer.valueOf(st.nextToken()),
                    Integer.valueOf(st.nextToken()),
                    Integer.valueOf(st.nextToken()),
                    Integer.valueOf(st.nextToken()),
                    Integer.valueOf(st.nextToken()),
                };
                array.add(new Array(id, aux));
            }
            input.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    /*
    * writeFile genera una linea de texto con el contenido del array. El argumento
    * es un tipo de dato Array
    */
    public void writeFile(Array aux){
        BufferedWriter output;
        try{
            output = new BufferedWriter(new FileWriter(fileName, true));
            output.write(
                aux.getName()+" "+
                aux.getArray()[0]+" "+
                aux.getArray()[1]+" "+
                aux.getArray()[2]+" "+
                aux.getArray()[3]+" "+
                aux.getArray()[4]+" "+
                aux.getArray()[5]+" "+
                aux.getArray()[6]+" "+
                aux.getArray()[7]+" "
            );
            output.newLine();
            output.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    /*
    * newFile crea el archivo de texto. En caso de que el archivo ya
    * exista imprime un mensaje
    */
    public void newFile(){
        File file = new File(fileName);
        FileReader fr;
        if(!file.exists()){
            try{
                fw = new FileWriter(fileName);
                System.out.println("Archivo creado");
            }
            catch(IOException e){
                System.out.println("Error al crear el archivo");
            }
        }
        else System.out.println("Archivo ya existe");
    }
    
    public void delFile(){
        File file = new File(fileName);
        if(file.delete()) System.out.println("Borrado exitosamente");
        else System.out.println("Error de borrado");
    }

}