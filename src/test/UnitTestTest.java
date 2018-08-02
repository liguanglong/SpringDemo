import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author LiGuanglong
 * @date 2018/6/11
 */
public class UnitTestTest {

    @Test(expected = Exception.class)
    public void div() throws Exception {
        double res = UnitTest.div(10, 0);
        Assert.fail("not throws exception");
    }

    @Test(timeout = 2000)
    public void testDiv() throws Exception {
        double res = UnitTest.div(10, 2);
        //delta代表实际值和预期值最大的误差范围
        assertEquals(5.00, res, 0);
    }

    @Test
    public void testSame() throws Exception {
        double res = UnitTest.div(10, 2);
        assertNotNull(res);
    }
}