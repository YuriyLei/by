package com.yulei.demo.model;

import com.yulei.demo.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by lei.yu on 2016/5/16.
 */
@Entity
@Table(name = "sector")
public class Sector extends BaseEntity<Long> implements Serializable {
    @Column
    private String sectorName;
    private String sectorIntro;

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getSectorIntro() {
        return sectorIntro;
    }

    public void setSectorIntro(String sectorIntro) {
        this.sectorIntro = sectorIntro;
    }
}
