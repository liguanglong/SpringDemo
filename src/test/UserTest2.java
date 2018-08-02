import com.example.dao.UserDao;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author LiGuanglong
 * @date 2018/6/26
 */
//表示继承了SpringJUnit4ClassRunner类
@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(MockitoJUnitRunner.class)
//Spring整合JUnit4测试时，使用该注解引入多个配置文件
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest2 {

    @Mock
    private UserDao userDao;

    @Mock
    private List mockList;

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    private User user;

    @Before
    public void setUp() throws Exception {
        //用于初始化@Mock注解修饰的组件
        MockitoAnnotations.initMocks(this);
//        user = new User(5, "abc5", "abc5", "abc5@abc.com");
    }

    @Test
    public void testService() {
//        doReturn(new User(1,"123","1213","123")).when(userDao).addEntity(any(User.class));
//        System.out.println(userDao.addEntity(new User()));

        User user = new User();
        user.setId(1);
        user.setName("123");
        user.setPassword("123");

        doReturn(user).when(userDao).findUserById(1);


        //step2 运行待测试模块
        User user1 = userService.getUserById(1);

        user1 = userService.getUserByName("abc");

        System.out.println(user1);

        //step3 验证测试结果
        assertNotNull(user1);
    }


    @Test
    public void testMock() {
        List mock = mock(List.class);
        mock.add(1);
        mock.clear();

        verify(mock).add(1);
        verify(mock).clear();

    }

    @Test
    public void testMock1() {
        Iterator iterator = mock(Iterator.class);
        when(iterator.next()).thenReturn("Hello").thenReturn("World");
        String result = iterator.next()+" " + iterator.next() +" "+ iterator.next();
        assertEquals("Hello World World", result);
    }

    @Test
    @Transactional
    public void testException() throws IOException {
//        OutputStream outputStream = mock(OutputStream.class);
//        doThrow(new IOException()).when(outputStream).close();
//        outputStream.close();
//        doReturn(new User(1,"123","123","123")).when(userDao).addEntity(any(User.class));
        userDao.addEntity(new User());
        verify(userDao).addEntity(new User());
        verify(userDao, atLeast(1));
//        spy(userDao);
        System.out.println(userDao.addEntity(new User()));

        when(userDao.addEntity(any(User.class))).thenReturn(new User());
        System.out.println(userDao.addEntity(new User()));



    }

    @Test
    public void testMockList(){
//        List mocklist1 = mock(List.class);
//        when(mockList.add(1)).thenReturn(true);
////        mockList.add(1);
//        assertEquals(mockList.add(1), true);
//
////        verify(mockList).add(1);

        assertTrue(mockList instanceof List);
    }


}
