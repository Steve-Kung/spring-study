package cn.stevekung;

import cn.stevekung.mapper.UserMapper;
import cn.stevekung.mapper.UserMapperImpl;
import cn.stevekung.pojo.User;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Configuration
@Import(SpringDaoConfig.class)
@MapperScan("cn.stevekung.mapper")
@ComponentScan("cn.stevekung")
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public UserMapperImpl userMapperImpl(){
        return new UserMapperImpl();
    }

}
