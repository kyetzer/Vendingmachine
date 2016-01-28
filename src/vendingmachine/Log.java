/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;



import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kyetz
 */
public class Log {
  List<List<String>> list = new ArrayList<>();
  
  public void Setup(){
     int i;           
     for (i=0;i<6;i++) list.add(new ArrayList<>()); 
  }
  
  public void Insertvals(String str1,String str2,String str3,String str4,String str5,String str6){
    
    list.get(0).add(str1); 
    list.get(1).add(str2);
    list.get(2).add(str3);
    list.get(3).add(str4);
    list.get(4).add(str5);
    list.get(5).add(str6);
  }
  
  public void printoutvals(String[] cols){
    int i,j;
    
    for (j=0;j<6;j++) System.out.print(cols[j] + "    ");
    System.out.println("");
    System.out.println("------------------------------------------------------------------------------------------------------------------");
    for (i=0;i<list.get(0).size();i++){
        System.out.print(list.get(0).get(i) + "       ");
        System.out.print(list.get(1).get(i) + "       ");
        for (j=2;j<6;j++){
            System.out.print(list.get(j).get(i) + "          ");
        }
        System.out.println("");
    }
  }
}

