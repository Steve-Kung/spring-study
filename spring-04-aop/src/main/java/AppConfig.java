import cn.stevekung.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import cn.stevekung.service.UserServiceImpl;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 参考https://juejin.im/post/5dbffe37f265da4d17138615
@Configuration
@ComponentScan("cn.stevekung")
@EnableAspectJAutoProxy // 开启@AspectJ注解配置方式
public class AppConfig {
    @Bean
    public UserService userServiceImpl(){
        return new UserServiceImpl();
    }
}
