package vn.uth.k22.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import vn.uth.k22.domain.User;
import vn.uth.k22.domain.dto.RegisterDTO;
import vn.uth.k22.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUser(){
        return this.userRepository.findAll();
    }

    public User getUserById(long id){
        return this.userRepository.findById(id);
    }

    public User saveUser(User user){
        return this.userRepository.save(user);
    }

    public void deleteAUser(long id){
        this.userRepository.deleteById(id);
    }

    public User registerDTOtoUser(RegisterDTO userDTO){
        User user = new User();
        user.setName(userDTO.getFirstName() + "" + userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        String hashPassword = this.passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(hashPassword);
        return user;
    }

}
