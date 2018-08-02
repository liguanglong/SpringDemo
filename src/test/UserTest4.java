import com.example.dao.UserDao;
import com.example.pojo.User;
import com.example.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author LiGuanglong
 * @date 2018/7/2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest4 {

    @Resource
    UserDao userDao;

    @Resource
    UserService userService;

    @Autowired
    WebApplicationContext  context;

    MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//        mockMvc = MockMvcBuilders.standaloneSetup(context).setMessageConverters(new MappingJackson2SmileHttpMessageConverter()).build();

    }


    @Test
    public void test() {
        Map<String, Object> cond = new HashMap<>();

//        cond.put("emailSort", "DESC");
//        cond.put("loginSort", "DESC");
        List<User> userList = userDao.findEntityByCond(cond);

        for (User user : userList) {
            System.out.println(user.getName());
        }

    }


    @Test
    public void testController() throws Exception {

//        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
//        multiValueMap.add("username", "abc");
//        multiValueMap.add("password","123");
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/user/abc")
                .param("username", "abc")
                .param("password", "123")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
//                .params(multiValueMap))
                .andDo(print())
                .andExpect(status().isOk());

        MvcResult mvcResult = resultActions.andReturn();
//        Assert.assertNotNull(mvcResult.getResponse());

//        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("=====客户端获得反馈数据:" + mvcResult.getResponse());
    }

    @Test
    public void testAddUser(){
        userService.getUserById(1).toString();
    }

}
