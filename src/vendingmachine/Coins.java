/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

public enum Coins {
    NICKEL    (0.05, 5.0, 5.0),
    DIME      (0.10, 10.0, 10.0),
    QUARTER   (0.25, 25.0, 25.0),
    OTHER     (0.0, 0.0, 0.0);

    private final double dollaramt;   
    private final double weight; 
    private final double size;
    
    Coins(double dollaramt,double weight,double size) {
        this.dollaramt = dollaramt;
        this.weight = weight;
        this.size = size;
    }
    public double dollaramt() { return dollaramt; }
    public double weight() { return weight; }
    public double size(){ return size; }
    public String cname(){ return this.name(); }
}
