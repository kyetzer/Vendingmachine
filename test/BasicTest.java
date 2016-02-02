
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import vendingmachine.CoinSensingElement;
import vendingmachine.Coins;
import vendingmachine.DisplayedMessages;
import vendingmachine.Log;
import vendingmachine.Products;
import vendingmachine.Vendingmachine;
import static vendingmachine.Vendingmachine.CoinInsertEvent;
import static vendingmachine.Vendingmachine.KeyPadButtonPressEvent;
import vendingmachine.money;
import vendingmachine.util;

public class BasicTest {

    public BasicTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("* MachineVendingTest:                     @BeforeClass method");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("* MachineVendingTest:                     @AfterClass method");
    }

    @Before
    public void setUp() {
        System.out.println("* MachineVendingTest:                     @Before Test method");
    }

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
    
    @Test
    public void TestItemNamePerButPress(){
        int i;
        String[] names = {"COLA","CHIPS","CANDY"};
        
        System.out.println("* MachineVendingTest:          Item Cost Given Keypad button number");
        for (i=0;i<names.length;i++){       
           assertEquals(money.RetItemname(i),names[i]);
        }
    }
    
    @Test
    public void TestIfItemisAvailable(){
        int i;
        boolean[] names = {true,true,true};
        
        System.out.println("* MachineVendingTest:          Item is available");
        for (i=0;i<names.length;i++){       
           assertEquals(money.RetItemAvail(i),names[i]);
        }
    }

    @Test
    public void TestChangeDollarAmount(){
        int i;
        double val=0.0;
        double[] names = {0.05,0.25,0.25,0.10};
        money mon = new money();
        
        System.out.println("* MachineVendingTest:          Total Dollar Value");
        for (i=0;i<names.length;i++){
            mon.Increaseamt(names[i]);
        }
        assertEquals(mon.RetAmount(),0.65,0.01);
        mon.SubtractItemCostFromAmnt(0.30);
        assertEquals(mon.RetAmount(),0.35,0.01);
        mon.Changeamttozero();
        assertEquals(mon.RetAmount(),0.0,0.0);
        mon.ReadCoinAmtIncamt(5.0, 5.0);            //  read in and store Nickel value
        assertEquals(mon.RetAmount(),0.05,0.01);
        mon.ReadCoinAmtIncamt(10.0, 10.0);            //  read in and store Dime value
        assertEquals(mon.RetAmount(),0.15,0.01);
        mon.ReadCoinAmtIncamt(25.0, 25.0);            //  read in and store Quarter value
        assertEquals(mon.RetAmount(),0.40,0.01);
        mon.Increaseamt(0.25);
        mon.Increaseamt(0.25);
        mon.SubtractItemCostFromAmnt(1);
        assertEquals(mon.RetAmount(),0.40,0.01);
    }
    
    @Ignore
    @Test
    public void TestVendingMachineMainProg(){
        int i;
        double val=0.0;
        Log msglog = new Log();
        msglog.Setup();
        money mony = new money();
        CoinSensingElement cse = new CoinSensingElement();
        Vendingmachine vm = new Vendingmachine();
        
        System.out.println("* MachineVendingTest:          Machine Main Program");
        vm.CoinInsertEvent(mony,cse,5.0,5.0);
        assertEquals(mony.RetAmount(),0.05,0.01);
        
        vm.CoinInsertEvent(mony,cse,5.0,5.0);
        vm.CoinInsertEvent(mony,cse,25.0,25.0);
        vm.CoinInsertEvent(mony,cse,25.0,25.0);
        assertEquals(mony.RetAmount(),0.60,0.01);
        vm.KeyPadButtonPressEvent(0,mony,cse);
        assertEquals(mony.RetAmount(),0.60,0.01);
        
        vm.CoinInsertEvent(mony,cse,10.0,10.0);
        vm.CoinInsertEvent(mony,cse,25.0,25.0);
        vm.CoinInsertEvent(mony,cse,25.0,25.0);
        assertEquals(mony.RetAmount(),1.20,0.01);
        vm.KeyPadButtonPressEvent(1,mony,cse);
        assertEquals(mony.RetAmount(),0.70,0.01);
        
        vm.CoinInsertEvent(mony,cse,25.0,25.0);
        vm.CoinInsertEvent(mony,cse,25.0,25.0);
        vm.CoinInsertEvent(mony,cse,25.0,25.0);
        vm.CoinInsertEvent(mony,cse,25.0,25.0);
        assertEquals(mony.RetAmount(),1.70,0.01);
        vm.KeyPadButtonPressEvent(2,mony,cse);
        assertEquals(mony.RetAmount(),1.05,0.01);
        
        vm.CoinInsertEvent(mony,cse,10.0,10.0);
        vm.CoinInsertEvent(mony,cse,10.0,10.0);
        vm.CoinInsertEvent(mony,cse,10.0,10.0);
        assertEquals(mony.RetAmount(),1.35,0.01);
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