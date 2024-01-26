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
    public User getUser(Long userId) {
        User user = userRepo.findById(userId).orElse(null);
        if(null == user){
            throw new UserNotFoundException("User Not Found");
        }
        return user;
    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        if(null == userRepo.findById(user.getId()).orElse(null)){
            throw new EntityNotFoundException("User Not Found");
        }
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        if(null == userRepo.findById(userId).orElse(null)){
            throw new EntityNotFoundException("User Not Found");
        }
        userRepo.deleteById(userId);
    }
}
