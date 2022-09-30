package com.app.trackers.user.repo;

import com.app.trackers.user.ForgotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForgotPasswordRepository extends JpaRepository<ForgotEntity,Long> {
}
