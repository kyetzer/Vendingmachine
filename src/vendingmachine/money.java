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
   
   public Double RetCoinAmt(double wgt,double size){
        Double retval=0.0;
        
        for (Coins c : Coins.values()){
           if ((c.weight() == wgt) && (c.size() == size)){
               retval = c.dollaramt();
               break;
           }
        }
        return retval;
    }
   
    public Double RetItemCost(int but){
        Double retval=0.0;
        
        for (Products p : Products.values()){
           if ((p.but() == but)){
               retval = p.cost();
               break;
           }
        }
        return retval;
    }
    
    public String RetCoiname(double wgt,double size){
        String retval="";
        
        for (Coins c : Coins.values()){
           if ((c.weight() == wgt) && (c.size() == size)){
               retval = c.cname();
               break;
           }
        }
        return retval;
    }
    
    public String RetItemname(int but){
        String retval="";
        
        for (Products p : Products.values()){
           if ((p.but() == but)){
               retval = p.cname();
               break;
           }
        }
        return retval;
    }
    
    public boolean RetItemAvail(int but){
        boolean retval=false;
        
        for (Products p : Products.values()){
           if ((p.but() == but)){
               retval = p.itemavail();
               break;
           }
        }
        return retval;
    }
    
    public void Increaseamt(double inval){
     coinsadded++;
     this.accumamount= this.accumamount+inval; 
   }
   
   public void Changeamttozero(){
     this.accumamount=0;
   }
   
   public void SubtractItemCostFromAmnt(double inval){
     this.accumamount=this.accumamount-inval;
   }
   
   public double RetAmount(){
     return this.accumamount;
   }
   
   public void ReadCoinAmtIncamt(double wgt,double size){
     Increaseamt(RetCoinAmt(wgt,size));  
   }
   
   public double RetDiffBetweenCostInert(int but){
     double tmpv;
     
     tmpv = RetItemCost(but);
     return this.accumamount-RetItemCost(but);
   }
   
   public void SubtractItemCostFromAmnt(int but){
     double tmpv;
     
     tmpv = RetItemCost(but);
     this.accumamount=this.accumamount-tmpv;
   }
}
