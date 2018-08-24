package com.wj5633.pms.repository;

import com.wj5633.pms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wj
 * @create 2018-08-24 15:46
 **/

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
