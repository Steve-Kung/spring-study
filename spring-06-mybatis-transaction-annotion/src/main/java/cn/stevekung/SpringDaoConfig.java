package cn.stevekung;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:db.properties", encoding = "utf8")
public class SpringDaoConfig {
    @Value("${password}")
    private String password;
    @Value("${user}")
    private String username;
    @Value("${url}")
    private String url;
    @Value("${driver-class-name}")
    private String driverClassName;
    @Value("${type}")
    private String type;

    @Bean
    public DataSource druid(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setDbType(type);

        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(20);
        dataSource.setMaxWait(60000);

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(druid());
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }


    // 事务
    /*
    使用基于注解版的事务
 1、想要使用基于注解版的事务管理，需要添加
  @EnableTransactionManagement 注解开启事务管理功能
     但是只添加注解不配置事务管理器会报 NoSuchBeanDefinitionException，
     所以需要配置事务管理器
      org.springframework.beans.factory.NoSuchBeanDefinitionException:
       No qualifying bean of type 'org.springframework.transaction.
       PlatformTransactionManager'
  2、在容器中添加事务管理器 DataSourceTransactionManager
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(druid());
    }


}
