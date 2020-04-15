package com.yangtao.springcloud.provider.user.dao;

import com.yangtao.springcloud.provider.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

}
