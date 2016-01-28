/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author kyetz
 */
public class Vendingmachine {
    static private String[] strarr = {"Display Message","Total Amount","Coin Type","Item Purchased","Amount Returned","Return Money Button Pressed"};
    static private String displayedmessage="";
    static private Log msglog = new Log();
    
    public static void main(String[] args) {
        msglog.Setup();
        CoinSensingElement cse = new CoinSensingElement();
        
//        msglog.Insertvals("1","2", "3", "4",  "5", "6");
//        msglog.printoutvals(strarr);
        
        cse.setSize(50.0);
        cse.setWgt(120.0);
        System.out.println(cse.getSize() + "  " + cse.getWgt());
    }
    
}
