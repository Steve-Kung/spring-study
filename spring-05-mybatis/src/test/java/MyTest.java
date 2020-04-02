import mapper.UserMapper;
import mapper.UserMapperImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    @Test // 测试Mybatis模块
    public void test() throws IOException {
        String resources = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resources);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(User.builder().id(3L).deleted(0).build());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test // 测试Spring-Mybatis集合模块
    public void springMybatis(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapperImpl = context.getBean("userMapperImpl", UserMapper.class);
        List<User> users = userMapperImpl.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test // 测试事务
    public void testTransaction(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapperImpl = context.getBean("userMapperImpl", UserMapper.class);
        userMapperImpl.addUser(User.builder().name("steve07").build());
    }
}
