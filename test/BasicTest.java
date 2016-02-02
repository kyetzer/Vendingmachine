
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import vendingmachine.Coins;
import vendingmachine.DisplayedMessages;
import vendingmachine.Products;
import vendingmachine.money;
import vendingmachine.util;

public class BasicTest {

    public BasicTest() {
    }

    @Ignore
    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("* MachineVendingTest:                     @BeforeClass method");
    }

    @Ignore
    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("* MachineVendingTest:                     @AfterClass method");
    }

    @Ignore
    @Before
    public void setUp() {
        System.out.println("* MachineVendingTest:                     @Before Test method");
    }

    @Ignore
    @After
    public void tearDown() {
        System.out.println("* MachineVendingTest:                     @After Test method");
    }
        
    @Test
    public void TestMessageEnum(){
        String[] msgs = {"Insert Coins","Price       ","Thank You   ","Sold Out    ","Exact Change Only"};
        String[] names = {"Insert","Price","Thankyou","Soldout","Exactchang"};
        int num=0;
        System.out.println("* MachineVendingTest:          Message  Enum  Test");
        for (DisplayedMessages dm : DisplayedMessages.values()){       
           if ((dm.Msgnumb() == num)){                                    
               assertEquals(dm.ModMessage(0.5),msgs[num] + " $0.5");
               assertEquals(dm.name(),names[num]);
               assertEquals(dm.Msgnumb(),num);
           }
           num++;
        }
    }
    
    @Test
    public void TestCoinEnum(){
        double[] amt = {0.05,0.10,0.25,0.0};
        double[] wgt = {5.0,10.0,25.0,0.0};
        double[] size = {5.0,10.0,25.0,0.0};
        String[] names = {"NICKEL","DIME","QUARTER","OTHER"};
        int num=0;
        System.out.println("* MachineVendingTest:          Coin  Enum  Test");
        for (Coins dm : Coins.values()){       
           if ((dm.name() == names[num])){                                    
               assertEquals(dm.dollaramt(),amt[num],0.01);
               assertEquals(dm.size(),size[num],0.01);
               assertEquals(dm.weight(),wgt[num],0.01);
               assertEquals(dm.name(),names[num]);
           }
           num++;
        }
    }
    
    @Test
    public void TestProductEnum(){
        double[] cost = {1.0,0.50,0.65};
        int[] but = {0,1,2};
        boolean[] avail = {true,true,true};
        String[] names = {"COLA","CHIPS","CANDY"};
        int num=0;
        System.out.println("* MachineVendingTest:          Product  Enum  Test");
        for (Products dm : Products.values()){       
           if ((dm.name() == names[num])){                                    
               assertEquals(dm.cost(),cost[num],0.01);
               assertEquals(dm.but(),but[num]);
               assertEquals(dm.itemavail(),avail[num]);
               assertEquals(dm.name(),names[num]);
           }
           num++;
        }
    }
    
    @Test
    public void TestUtil(){
        int i;
        double[] cost = {10.00,500.05,11.657};
        String[] strval = {"10","500.05","11.66"};
      
        System.out.println("* MachineVendingTest:          Util Floating Point Formatter");
        for (i=0;i<cost.length;i++){      
               assertEquals(util.customFormat("###.##", cost[i]),strval[i]);
        }
    }
    
    @Test
    public void TestRetCoinValue(){
        int i;
        double[] cost = {0.0,5.0,10.0,25.0};
        double[] val = {0.0,0.05,0.10,0.25};
        String[] strval = {"10","500.05","11.66"};
      
        System.out.println("* MachineVendingTest:          Coin amount given size and weight");
     
        for (i=0;i<cost.length;i++){
               assertEquals(money.RetCoinAmt(cost[i],cost[i]),val[i],0.01);
        }
    }
    
    @Test
    public void TestItemCostPerButPress(){
        int i;
        double[] cost = {1.0,0.50,0.65};
        
        System.out.println("* MachineVendingTest:          Item Cost Given Keypad button number");
        for (i=0;i<cost.length;i++){       
           assertEquals(money.RetItemCost(i),cost[i],0.01);
        }
    }
    
    @Test
    public void TestCoinName(){
        int i;
        String[] cname = {"NICKEL","DIME","QUARTER","OTHER"};
        double[] sizewgt = {5.0,10.0,25.0,0.0};
        
        System.out.println("* MachineVendingTest:          Coin name given size and weight");
        for (i=0;i<cname.length;i++){       
           assertEquals(money.RetCoiname(sizewgt[i],sizewgt[i]),cname[i]);
        }
    }

    @Ignore
    @Test(timeout = 1000)
    public void testWithTimeout() {
        System.out.println("* MachineVendingTest: test method 2 - testWithTimeout()");
    }

    @Ignore
    @Test (expected = IllegalArgumentException.class)
    public void checkExpectedException() {
        System.out.println("* MachineVendingTest: test method 3 - checkExpectedException()");
    }

    @Ignore
    @Test
    public void temporarilyDisabledTest() throws Exception {
        System.out.println("* MachineVendingTest: test method 4 - checkExpectedException()");
    }
}