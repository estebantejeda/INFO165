package codigo;
public class Array{
    String name;
    int[] arrayNumber;
    
    public Array(String name, int[] arrayNumber){
        this.name = name;
        this.arrayNumber = arrayNumber;
    }

    public String getName(){
        return name;
    }
    
    public int getNumber(int pos){
        return arrayNumber[pos-1];
    }

    public int[] getArray(){
        return arrayNumber;
    }

    public void addNumber(int num, int pos){
        if(arrayNumber[pos-1] == 0) arrayNumber[pos-1] = num;
        else{
            int[] arrayAux = new int[8];
            for(int i = 0; i<8; i++) arrayAux[i] = arrayNumber[i];
            arrayNumber[pos-1] = num;
            for(int i = pos; i < 8; i++) arrayNumber[i] = arrayAux[i-1];
        }
    }

    public void delNumber(int pos){
        int arrayAux[] = {0,0,0,0,0,0,0,0};
        for(int i = 0; i < 8-pos; i++) arrayAux[i] = arrayNumber[pos+i];
        arrayNumber[pos-1] = 0;
        for(int i = 0; i < 8-pos; i++) arrayNumber[i+pos-1] = arrayAux[i];
        arrayNumber[7] = 0;
    }

}