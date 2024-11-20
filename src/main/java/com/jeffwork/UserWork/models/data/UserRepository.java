package com.jeffwork.UserWork.models.data;

import com.jeffwork.UserWork.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {


}
