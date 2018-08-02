/**
 * @author LiGuanglong
 * @date 2018/6/11
 */
public class UnitTest {

    public static double div(double d1, double d2) throws Exception{

        double res = 0;

        if (d2 == 0) {
            throw new Exception();
        } else {
            return d1 / d2;
        }
    }
}
