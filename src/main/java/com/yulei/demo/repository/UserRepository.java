package com.yulei.demo.repository;

import com.yulei.demo.common.BaseRepository;
import com.yulei.demo.model.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by lei.yu on 2016/4/22.
 */
public interface UserRepository extends BaseRepository<User,Long>{
    User findSectorById(Long id);

    User findByUserCodeAndDeleted(String userCode,String deleted);
    @Query(value = "select count(*) from user u where u.deleted=0",nativeQuery = true)
    int countNotDelete();

    List<User> findAllByDeleted(String undeleted);
}
