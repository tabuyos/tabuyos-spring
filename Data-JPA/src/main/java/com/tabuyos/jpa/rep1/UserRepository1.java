package com.tabuyos.jpa.rep1;

import com.tabuyos.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Tabuyos
 * @Time 2020/4/16 22:30
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Repository
public interface UserRepository1 extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    @Query(value = "select * from user", nativeQuery =true)
    @SuppressWarnings("unused")
    List<User> getObject();
}
