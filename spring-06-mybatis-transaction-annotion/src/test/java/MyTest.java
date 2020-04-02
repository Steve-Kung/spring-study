import cn.stevekung.AppConfig;
import cn.stevekung.mapper.UserMapper;
import cn.stevekung.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserMapper userMapperImpl = context.getBean("userMapperImpl", UserMapper.class);
//        List<User> users = userMapperImpl.getUsers();
//        for (User user : users) {
//            System.out.println(user);
//        }
//        int i = userMapperImpl.updateUser(User.builder().id(9L).name("gj").build());
//        System.out.println(i);
        userMapperImpl.addUser(User.builder().name("steve").build());
    }
}
