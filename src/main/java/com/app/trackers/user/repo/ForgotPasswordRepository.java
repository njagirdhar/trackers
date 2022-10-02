package com.app.trackers.user.repo;

import com.app.trackers.user.ForgotEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForgotPasswordRepository extends MongoRepository<ForgotEntity,Long> {
}
