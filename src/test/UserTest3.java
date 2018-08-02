import com.example.dao.UserDao;
import com.example.pojo.User;
import com.example.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest3 {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Resource
    private UserService userService;

    @Test
    public void getAllUsersCount() {
        int count = userDao.getAllUsersCount();
        Assert.assertEquals(count, 1);
    }

    @Test
    public void testAop(){
        User user = userDao.getUserByName("abc");
        System.out.println(user.getName());
    }


    @Test
    public void testTransaction(){
        List<User> userList = new ArrayList<User>();
//        User user1 = new User(5,"abc5","abc5","abc5@abc.com");
//        User user2 = new User(4,"abc4","abc4","abc4@abc.com");
//        userList.add(user1);
//        userList.add(user2);
        userService.addUserList(userList);

    }


}