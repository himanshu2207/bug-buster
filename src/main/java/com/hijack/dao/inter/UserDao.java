package com.hijack.dao.inter;

import com.hijack.entity.daoEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface UserDao extends JpaRepository<User,Long> {

    User findByUsername(String username);

}
