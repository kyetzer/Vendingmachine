
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import vendingmachine.Coins;
import vendingmachine.DisplayedMessages;

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