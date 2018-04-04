import com.example.dao.UserDao;
import com.example.util.MyBatisSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UserTest {

    private SqlSession session;
    private UserDao userDao;

    @Before
    public void setUp() {
        SqlSessionFactory sessionFactory = MyBatisSessionFactory.getSessionFactory();
        session = sessionFactory.openSession();
        userDao = session.getMapper(UserDao.class);
    }

    @Test
    public void getAllUsersCount() {
        int count = userDao.getAllUsersCount();
        Assert.assertEquals(count, 1);
    }

    @After
    public void tearDown() {
        session.close();
    }
}