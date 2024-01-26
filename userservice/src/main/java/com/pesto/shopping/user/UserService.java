package com.pesto.shopping.user;

public interface UserService {

    public UserBean getUser(Long userId);

    public UserBean addUser(UserBean userBean);

    public UserBean updateUser(UserBean userBean);

    public void deleteUser(Long userId);
}
