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
        
        cse.setWgt(5);
        cse.setSize(5);
        mony.ReadCoinAmtIncamt(cse.getWgt(), cse.getSize());
        cse.setWgt(25);
        cse.setSize(25);
        mony.ReadCoinAmtIncamt(cse.getWgt(), cse.getSize());
        cse.setWgt(10);
        cse.setSize(10);
        mony.ReadCoinAmtIncamt(cse.getWgt(), cse.getSize());
        
        System.out.println(mony.RetAmount());
     
    } 
}
