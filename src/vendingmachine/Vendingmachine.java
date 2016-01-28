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
    
    static void CoinInsertEvent(money mony,CoinSensingElement cse,double wgt,double size){
       cse.setWgt(wgt);
       cse.setSize(size);
       mony.ReadCoinAmtIncamt(cse.getWgt(), cse.getSize()); 
       displayedmessage=RetProperMessage(0,mony.RetAmount()); 
       msglog.Insertvals(displayedmessage,"" + util.customFormat("###.##",mony.RetAmount()), mony.RetCoiname(cse.getWgt(), cse.getSize()), "------", "------", "------");
    }
    
    static void KeyPadButtonPressEvent(int but,money mony,CoinSensingElement cse){
      double diff;
      DisplayedMessages dms;
      //    buttons   0 - cola,   1 - chips,  2 - candy
      diff = mony.RetDiffBetweenCostInert(but);
      if (diff >= 0.0){
        displayedmessage=RetProperMessage(2,-1.0); 
        mony.SubtractItemCostFromAmnt(but);
        msglog.Insertvals(displayedmessage,"" + util.customFormat("###.##",mony.RetAmount()), "------", mony.RetItemname(but),  "" + util.customFormat("###.##",diff), "------");
        displayedmessage=RetProperMessage(0,0.0); 
        mony.Changeamttozero();
        msglog.Insertvals(displayedmessage,"" + util.customFormat("###.##",mony.RetAmount()), "------", "------",  "------", "------");
      }
      else{
        displayedmessage=RetProperMessage(1,mony.RetItemCost(but)); 
        msglog.Insertvals(displayedmessage,"" + util.customFormat("###.##",mony.RetAmount()), "------", "------",  "------", "------");  
      }
    }
    
    static void RetMoneyButtonPressEvent(money mony){
      double howmuchreturned = mony.RetAmount();
      displayedmessage=RetProperMessage(0,0.0); 
      mony.Changeamttozero();
      msglog.Insertvals(displayedmessage,"" + util.customFormat("###.##",mony.RetAmount()), "------", "------",  "" + util.customFormat("###.##",howmuchreturned), "true");
    }
    
    public static void main(String[] args) {
        msglog.Setup();
        money mony = new money();
      CoinSensingElement cse = new CoinSensingElement();
      cse.setWgt(5.0);
      cse.setSize(5.0);
      displayedmessage=RetProperMessage(0,0.0);
      msglog.Insertvals(displayedmessage,"" + util.customFormat("###.##",mony.RetAmount()), "------", "------",  "------", "------");
      
      CoinInsertEvent(mony,cse,5.0,5.0);
      CoinInsertEvent(mony,cse,25.0,25.0);
      CoinInsertEvent(mony,cse,25.0,25.0);
      KeyPadButtonPressEvent(0,mony,cse);
      CoinInsertEvent(mony,cse,10.0,10.0);
      CoinInsertEvent(mony,cse,25.0,25.0);
      CoinInsertEvent(mony,cse,25.0,25.0);
      KeyPadButtonPressEvent(1,mony,cse);
      CoinInsertEvent(mony,cse,25.0,25.0);
      CoinInsertEvent(mony,cse,25.0,25.0);
      CoinInsertEvent(mony,cse,25.0,25.0);
      CoinInsertEvent(mony,cse,25.0,25.0);
      KeyPadButtonPressEvent(2,mony,cse);
      CoinInsertEvent(mony,cse,10.0,10.0);
      CoinInsertEvent(mony,cse,10.0,10.0);
      CoinInsertEvent(mony,cse,10.0,10.0);
      CoinInsertEvent(mony,cse,5.0,5.0);
      CoinInsertEvent(mony,cse,5.0,5.0);
      CoinInsertEvent(mony,cse,5.0,5.0);
      CoinInsertEvent(mony,cse,25.0,25.0);
      CoinInsertEvent(mony,cse,25.0,25.0);
      CoinInsertEvent(mony,cse,25.0,25.0);
      CoinInsertEvent(mony,cse,25.0,25.0);
      RetMoneyButtonPressEvent(mony);
      CoinInsertEvent(mony,cse,10.0,10.0);
      CoinInsertEvent(mony,cse,10.0,10.0);
      CoinInsertEvent(mony,cse,10.0,10.0);
      CoinInsertEvent(mony,cse,5.0,5.0);
      CoinInsertEvent(mony,cse,5.0,5.0);
      CoinInsertEvent(mony,cse,5.0,5.0);
      CoinInsertEvent(mony,cse,25.0,25.0);
      CoinInsertEvent(mony,cse,25.0,25.0);
      CoinInsertEvent(mony,cse,25.0,25.0);
      CoinInsertEvent(mony,cse,25.0,25.0);
      KeyPadButtonPressEvent(0,mony,cse);
      
      msglog.printoutvals(strarr);
        
    } 
}
