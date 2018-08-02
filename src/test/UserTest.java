import com.example.controller.LoginController;
import com.example.dao.UserDao;
import com.example.pojo.User;
import com.example.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//表示继承了SpringJUnit4ClassRunner类
@RunWith(SpringJUnit4ClassRunner.class)
//Spring整合JUnit4测试时，使用该注解引入多个配置文件
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {

    private static Logger logger = Logger.getLogger(UserTest.class);

    @Resource      //@Autowired
    private UserService userService;

    @Resource
    private UserDao userDao;

    @Resource
    private LoginController loginController;

    private MockMvc mockMvc;


    //测试controller
    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }

    @Test
    public void testLoginController() throws Exception {

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/user/abc").
                        param("username","abc").param("password","123")
                )
                .andDo(print())
                ;
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("=====客户端获得反馈数据:" + result);
        // 也可以从response里面取状态码，header,cookies...
        System.out.println(mvcResult.getResponse().getStatus());
    }


    @Test
    public void findUserById() {
        int id = 4;
        System.out.println(userService);

        User user = userService.getUserById(id);
        System.out.println(user);
        Assert.assertNotNull(user);
        assertEquals(user.getId(), id);
    }

    @Test
    public void testAdd() {
        User user = new User();
        user.setId(4);
        user.setName("haha");
        user.setPassword("123123");
        user.setEmail("abc@abc.com");
        userDao.addEntity(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(4);
        user.setName("dfadfasd");
        user.setPassword("456111");
        user.setEmail("123@abc.com");
        userDao.updateEntity(user);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testAddUser() {
//        User user = new User(6, "abc5", "abc5", "abc5@abc.com");
//        userDao.addEntity(user);
        assertEquals(userService.getUserById(5).getId(), 5);
    }

    @Test
    public void testUnitRollback(){
//        User user = new User(5, "abc5", "abc5", "abc5@abc.com");
//        userDao.addEntity(user);
        assertEquals(userDao.findUserById(5).getId(), 5);
    }


    @Test
    public void testJudegName(){
        assertEquals(1,userService.judgeByUserNameAndPassWord("abc","123"));
    }



    @Test
    @Rollback(value = false)
    @Transactional
    public void testDelete(){
//        User user = new User(5, "abc5", "abc5", "abc5@abc.com");
//        userDao.deleteEntity(user);
        assertNull(userDao.findUserById(5));
    }

}