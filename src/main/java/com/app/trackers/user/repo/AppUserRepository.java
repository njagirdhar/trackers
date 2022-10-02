package com.app.trackers.user.repo;

import com.app.trackers.user.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends MongoRepository<AppUser,Long> {
    Optional<AppUser> findByEmail(String email);

    Optional<AppUser> findByMobileNumber(String mobileNumber);
}