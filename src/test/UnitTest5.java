import com.example.controller.LoginController;
import com.example.pojo.User;
import com.example.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author LiGuanglong
 * @date 2018/7/9
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UnitTest5 {

    @Mock
    UserService userService;

    @InjectMocks
    LoginController loginController;

    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;


    @Before
    public void setUp() {

//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        ReflectionTestUtils.setField(loginController,"userService",userService);

//        mockMvc = MockMvcBuilders.standaloneSetup(wac)
//                .setMessageConverters(new MappingJackson2HttpMessageConverter()).build();

        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();

        MockitoAnnotations.initMocks(this);
    }


    /**
     * 模拟测试接口请求
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        User user = new User();
        user.setId(1);
        user.setPassword("123");
        user.setName("abc");
        user.setEmail("email");
        user.setLastLogin(new Date());

        List<User> list = new ArrayList<>();
        list.add(user);

        doReturn(list).when(userService).getUserList();
//        when(userService.getUserList()).thenReturn(list);

//        MvcResult mvcResult = mockMvc.perform(post("/user/getList.do").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.handler().handlerType(LoginController.class))
//                .andExpect(MockMvcResultMatchers.handler().methodName("getUserList"))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andReturn();




        mockMvc.perform(post("/user/getList.do"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("abc"));

    }


    /**
     * 直接测试controller
     */
    @Test
    public void testController() {
        User user = new User();
        user.setId(1);
        user.setName("abc");
        user.setEmail("email");
        List<User> list = new ArrayList<>();
        list.add(user);

        when(userService.getUserList()).thenReturn(list);

//        Map<String, Object> res = (Map<String, Object>) loginController.getUserList();
//        assertEquals("abc", ((List<User>) res.get("res")).get(0).getName());


        Map<String, Object> cond = new HashMap<>();




    }


}
