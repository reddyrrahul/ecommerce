package com.pesto.shopping.user;

import com.pesto.shopping.user.exception.UserNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserBean getUser(Long userId) {
        UserBean user = userRepo.findById(userId).orElse(null);
        if(null == user){
            throw new UserNotFoundException("User Not Found");
        }
        return user;
    }

    @Override
    public UserBean addUser(UserBean userBean) {
        return userRepo.save(userBean);
    }

    @Override
    public UserBean updateUser(UserBean userBean) {
        if(null == userRepo.findById(userBean.getId()).orElse(null)){
            throw new EntityNotFoundException("User Not Found");
        }
        return userRepo.save(userBean);
    }

    @Override
    public void deleteUser(Long userId) {
        if(null == userRepo.findById(userId).orElse(null)){
            throw new EntityNotFoundException("User Not Found");
        }
        userRepo.deleteById(userId);
    }
}
