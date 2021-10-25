package com.example.educationalcenter.service.ServiceImpl;

import com.example.educationalcenter.entity.User;
import com.example.educationalcenter.repository.UserRepository;
import com.example.educationalcenter.service.UserSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserSer {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public User add(User user) throws Exception {
        if (user.getId() == null) {
            return userRepository.save(user);
        }else {
            throw new RuntimeException("id kerakmas");
        }
    }

    @Override
    public void update(User user) throws Exception {
        if (user.getId() != null)
            userRepository.save(user);
        throw new RuntimeException("id kerakmas");
    }

    @Override
    public void delete() {
        userRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }


}
