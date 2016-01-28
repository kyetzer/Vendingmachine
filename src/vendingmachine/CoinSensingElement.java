/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

public class CoinSensingElement {
   private double size=25,wgt=25; 
   
   public void setSize(double inval){
       this.size=inval;
   }
   
   public void setWgt(double inval){
       this.wgt=inval;
   }
   
   public double getSize(){
       return this.size;
   }
   
   public double getWgt(){
       return this.wgt;
   }
   
   public boolean coininserted(){
       return true;
   }
}

