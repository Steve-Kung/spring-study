package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;
import java.util.List;

public interface UserMapper {
    public List<User> getUsers();
    public User getUserById(@Param("id") Long id);
    public void addUser(User user);
    public void deleteUser(@Param("id") Long id);
    public void updateUser(User user);
}
