package com.yulei.demo.repository;

import com.yulei.demo.common.BaseRepository;
import com.yulei.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lei.yu on 2016/4/22.
 */
public interface UserRepository extends BaseRepository<User, Long> {
    User findSectorById(Long id);

    User findByUserCodeAndDeleted(String userCode, String deleted);

    @Query(value = "select count(*) from user u where u.deleted=:deleted and u.real_name like :search", nativeQuery = true)
    int countNotDelete(@Param("deleted") String deleted, @Param("search") String searchPhrase);

    @Query(value = "select * from user u where u.deleted=:deleted and u.real_name like :search limit :begin,:rowCount", nativeQuery = true)
    List<User> findAllByDeleted(@Param("deleted") String deleted, @Param("begin") int begin, @Param("rowCount") int rowCount, @Param("search") String searchPhase);

    @Query(value = "update user u set u.updated_by=:id1,u.deleted=1 where u.id=:id", nativeQuery = true)
    void lockUser(@Param("id") Long id, @Param("id1") Long id1);
}
