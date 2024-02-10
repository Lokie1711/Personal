package com.inter.user.service;

import com.inter.user.entity.UserEntity;
import com.inter.user.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserEntity updateUser(Long id, UserEntity updatedUser) {
        Optional<UserEntity> existingUserOptional = userRepository.findById(id);

        if (existingUserOptional.isPresent()) {
            UserEntity existingUser = existingUserOptional.get();
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setEmailId(updatedUser.getEmailId());
            existingUser.setMobile(updatedUser.getMobile());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setJobRole(updatedUser.getJobRole());

            return userRepository.save(existingUser);
        } else {
           log.info("No User Found !!!");
            return null;
        }
    }
}
