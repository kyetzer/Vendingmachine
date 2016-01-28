/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

public enum Products {
    COLA    (1.0,0,true),
    CHIPS   (0.50,1,true),
    CANDY   (0.65,2,true);

    private final double cost;   
    private final int but;
    private final boolean avail;
    Products(double cost,int but,boolean avail) {
        this.cost = cost;
        this.but = but;
        this.avail = avail;
    }
    public double cost() { return cost; }
    public int but(){ return but; }
    public String cname(){ return this.name(); }
    public boolean itemavail(){ return avail; }
}
