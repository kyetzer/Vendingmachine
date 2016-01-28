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
    static private money mony = new money();
    
    public static void main(String[] args) {
        msglog.Setup();
        CoinSensingElement cse = new CoinSensingElement();
        
        System.out.println(mony.RetCoiname(5.0, 5.0));
        System.out.println(mony.RetCoiname(10, 10));
        System.out.println(mony.RetCoiname(25, 25));
        System.out.println(mony.RetItemname(0));
        System.out.println(mony.RetItemname(1));
        System.out.println(mony.RetItemname(2));
    } 
}
