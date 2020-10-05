package com.study.jpastudy.repository;

import com.study.jpastudy.entity.HumanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface HumanRepository extends JpaRepository<HumanEntity,Long> {
    List<HumanEntity> findAllByName(String name);
    List<HumanEntity> findAllByAge(int age);
    List<HumanEntity> findAllByMoney(int money);
    @Transactional
    @Modifying
    @Query("UPDATE HumanEntity h SET h.name=?2, h.age=?3, h.money=?4 WHERE h._id=?1")
    int updateHuman(Long _id,String name,int age,int money);
}
