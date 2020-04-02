import dao.UserDaoImpl;
import cn.stevekung.service.UserServiceImpl;

public class MyTest {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();

        userService.setUserDao(new UserDaoImpl());

        userService.getUser();
    }
}
