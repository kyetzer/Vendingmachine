/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

public enum Products {
    COLA    (1.0,0),
    CHIPS   (0.50,1),
    CANDY   (0.65,2);

    private final double cost;   
    private final int but;
    Products(double cost,int but) {
        this.cost = cost;
        this.but = but;
    }
    public double cost() { return cost; }
    public int but(){ return but; }
    public String cname(){ return this.name(); }
}
