package com.app.trackers.user.repo;

import com.app.trackers.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    Optional<AppUser> findByEmail(String email);

    Optional<AppUser> findByMobileNumber(String mobileNumber);

    @Modifying
    @Query(value = "update user_tbl t set t.password =:newPassword where t.mail = :email" , nativeQuery = true)
    void resetPassword(@Param("email") String email, @Param("newPassword") String newPassword);
}
