import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.stevekung.pojo.Hello;
import cn.stevekung.service.UserService;

public class MyTest {
    @Test
    public void test(){
        //获取Spring的上下文对象！
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello hello = (Hello) context.getBean("hello");
        hello.show();

        UserService userServiceImpl = (UserService) context.getBean("userServiceImpl");
        userServiceImpl.getUser();
    }
}
