import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void testOnePass(){
        assertTrue(true);

    }

    @Test
    public void testTwoFail(){
        assertTrue(true);
    }

    @Ignore
    @Test
    public void testThreeNotReady(){
        assertTrue(true);
    }

    @Test
    public void testFourFail(){
        assertTrue(true);
    }
}
