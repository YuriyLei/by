package com.yulei.demo.repository;

import com.yulei.demo.BaseRepository;
import com.yulei.demo.model.Sector;

import java.util.List;

/**
 * Created by lei.yu on 2016/5/16.
 */
public interface SectorRepository extends BaseRepository<Sector,Long> {
    List<Sector> findAllByDeleted(String deleted);
}
