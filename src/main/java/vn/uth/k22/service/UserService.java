package vn.uth.k22.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.uth.k22.domain.User;
import vn.uth.k22.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
        return this.userRepository.findAll();
    }

}