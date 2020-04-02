import cn.stevekung.pojo.People;
import cn.stevekung.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        People people = context.getBean("people", People.class);
        System.out.println(people);

        UserService userServiceImpl = context.getBean("userServiceImpl", UserService.class);
        userServiceImpl.getUserService();
    }
}
