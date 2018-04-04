

import com.example.pojo.User;
import com.example.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;

//表示继承了SpringJUnit4ClassRunner类
@RunWith(SpringJUnit4ClassRunner.class)
//Spring整合JUnit4测试时，使用该注解引入多个配置文件
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest1 {

    @Resource      //@Autowired
    private UserService userService;

    @Test
    public void findUserById() {
        int id = 2;
        System.out.println(userService);

        User user = userService.getUserById(id);
        System.out.println(user);
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getId(), id);
    }

}