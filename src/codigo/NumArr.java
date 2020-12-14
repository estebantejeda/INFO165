/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.*;

/**
 *
 * @author HP
 */
public class NumArr {
    
    ArrayList <NumArr> array = new ArrayList<NumArr>(); //array -> pesrsonas
    //ArrayList <Array> array = new ArrayList<Array>();
    public ArrayList <NumArr> getNumArr(){return array;}
    public void setLista(ArrayList <NumArr> array){this.array = array;}

    Editor edit;
    
    public NumArr (Editor edit){
        this.edit = edit;
    }
    
    
    public void ingresarArray(String id,int n1, int n2,int n3,int n4,int n5,int n6,int n7,int n8){
        //int aux[] ={n1,n2,n3, n4,n5,n6,n7,n8};
        
    }
    public void ingresarArr(String id,int n1,int n2,int n3,int n4,int n5,int n6,int n7,int n8){
        edit.setConsola(id);
    }                       


    public void miraArr(String id) {
        
    }

    void ingresarArr(String id, int n1, int n2, int n3, int n4, int n5, int n6, int n7) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
