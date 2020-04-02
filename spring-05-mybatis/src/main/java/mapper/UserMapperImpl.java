package mapper;

import org.mybatis.spring.SqlSessionTemplate;
import pojo.User;
import java.util.List;

public class UserMapperImpl implements UserMapper{

//    @Autowired
//    public SqlSessionTemplate sqlSessionTemplate;

    // set方法注入
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<User> getUsers() {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.getUsers();
    }

    public User getUserById(Long id) {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.getUserById(id);
    }

    public void addUser(User user) {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        mapper.addUser(user);
//        mapper.deleteUser(1L);
    }

    public void deleteUser(Long id) {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        mapper.deleteUser(id);
    }

    public void updateUser(User user) {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        mapper.updateUser(user);
    }
}
