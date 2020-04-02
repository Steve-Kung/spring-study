package cn.stevekung.service;

import dao.UserDao;

public class UserServiceImpl implements UserService {

//    private UserDao userDao = new UserDaoImpl();
//    private UserDao userDao = new UserDaoImpl2();

    private UserDao userDao;

    // 使用set进行动态值的注入
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }


    public void getUser() {
        userDao.getUser();
    }
}
