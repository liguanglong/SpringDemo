import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.*;

/**
 * @author LiGuanglong
 * @date 2018/7/12
 */
public class ExternalizableDemo implements Externalizable {

    public String userName;

    public int age;


    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("123");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(userName);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        userName = (String) in.readObject();
    }




}
