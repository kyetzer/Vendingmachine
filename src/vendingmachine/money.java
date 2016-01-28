/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

public class money {
   private double accumamount=0;
   private int coinsadded=0;
   private int coinsrejected=0;
   
   Double RetCoinAmt(double wgt,double size){
        Double retval=0.0;
        
        for (Coins c : Coins.values()){
           if ((c.weight() == wgt) && (c.size() == size)){
               retval = c.dollaramt();
               break;
           }
        }
        return retval;
    }
   
    Double RetItemCost(int but){
        Double retval=0.0;
        
        for (Products p : Products.values()){
           if ((p.but() == but)){
               retval = p.cost();
               break;
           }
        }
        return retval;
    }
}
