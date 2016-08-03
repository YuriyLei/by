package com.yulei.demo.repository;

import com.yulei.demo.BaseRepository;
import com.yulei.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lei.yu on 2016/4/22.
 */
public interface UserRepository extends BaseRepository<User, Long> {
    @Query("select u.sectorId from User u where u.id=:id")
    Long findSectorIdById(@Param("id") Long id);

    User findByUserCodeAndDeleted(String userCode, String deleted);

    @Query(value = "select count(*) from user u where u.deleted=:deleted and u.real_name like :search", nativeQuery = true)
    int countNotDelete(@Param("deleted") String deleted, @Param("search") String searchPhrase);

    @Query(value = "select * from user u where u.deleted=:deleted and u.real_name like :search limit :begin,:rowCount", nativeQuery = true)
    List<User> findAllByDeleted(@Param("deleted") String deleted, @Param("begin") int begin, @Param("rowCount") int rowCount, @Param("search") String searchPhase);

    User findOneByUserCode(String userCode);
}
