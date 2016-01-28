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
    
    static String RetProperMessage(int num,double inval){
        String retval="";
        
        for (DisplayedMessages dm : DisplayedMessages.values()){
           if ((dm.Msgnumb() == num)){
               retval = dm.ModMessage(inval);
               break;
           }
        }
        return retval;
    }
    
    public static void main(String[] args) {
        msglog.Setup();
        
        System.out.println(RetProperMessage(0,0.0));
        System.out.println(RetProperMessage(1,0.0));
        System.out.println(RetProperMessage(2,0.0));
    } 
}
