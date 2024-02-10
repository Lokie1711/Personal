package com.inter.user.repo;

import com.inter.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long> {
    UserEntity getUserById(Long id);
}
