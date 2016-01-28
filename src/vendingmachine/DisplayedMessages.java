/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

public enum DisplayedMessages {
    Insert    ("Insert Coins",0),     //  $0.00
    Price     ("Price       ",1),
    Thankyou  ("Thank You   ",2),
    Soldout   ("Sold Out    ",3),
    Exactchang ("Exact Change Only",4);

    private final String msg; 
    private final int msgnumb;
    
    DisplayedMessages(String msg,int msgnumb) {
        this.msg = msg;
        this.msgnumb = msgnumb;
    }
    public int Msgnumb(){ return msgnumb; }
    public String BasicMessage() { return msg; }
    public String ModMessage(double inval){ 
        if (inval < 0.0) return msg + "     ";
        else return msg + " $" + util.customFormat("###.##",inval);
    } 
}
