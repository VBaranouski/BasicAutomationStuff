

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {



    @BeforeTest
    public void startTest(){
        System.out.println("Start!");
    }

    @Test
    public void testOnePass(){
        assertTrue(true);

    }

    @Test
    public void testTwoFail(){
        assertTrue(false);
    }


    @Test
    public void testThreeNotReady(){
        assertTrue(true);
    }

    @Test
    public void testFourFail(){
        assertTrue(true);
    }

    @AfterTest
    public void stopTest(){
        System.out.println("Stop!");
    }
}
