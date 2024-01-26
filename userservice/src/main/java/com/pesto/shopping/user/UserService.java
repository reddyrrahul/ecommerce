package com.pesto.shopping.user;

public interface UserService {

    public User getUser(Long userId);

    public User addUser(User user);

    public User updateUser(User user);

    public void deleteUser(Long userId);
}
