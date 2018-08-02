/**
 * @author LiGuanglong
 * @date 2018/7/5
 */
public class Main {

    public static void main(String[] args) {

        Integer obj1 = new Integer(1);

        Integer obj2 = new Integer(2);

        System.out.print("Values of obj1 & obj2 before wrapper modification: ");

        System.out.println("obj1 = " + obj1.intValue() + " ; obj2 = " + obj2.intValue());

        modifyWrappers(obj1, obj2);

        System.out.print("Values of obj1 & obj2 after wrapper modification: ");

        System.out.println("obj1 = " + obj1.intValue() + " ; obj2 = " + obj2.intValue());

    }

    private static void modifyWrappers(Integer x, Integer y) {
        x = x + 2;
        y = new Integer(10);
        System.out.println("obj1 = " + x.intValue() + " ; obj2 = " + y.intValue());
    }


}
