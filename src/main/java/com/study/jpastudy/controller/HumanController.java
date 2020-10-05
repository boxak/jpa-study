package com.study.jpastudy.controller;

import com.study.jpastudy.entity.HumanEntity;
import com.study.jpastudy.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/human")
public class HumanController {
    @Autowired
    HumanService humanService;

    @PostMapping("/insert")
    public String insert(HumanEntity humanEntity) {
        return humanService.insert(humanEntity);
    }

    @PostMapping("/update")
    public String update(HumanEntity humanEntity,long _id) {
        humanEntity.set_id(_id);
        return humanService.update(humanEntity);
    }

    @GetMapping("/list")
    public List<HumanEntity> search(String key, String value) {
        return humanService.search(key,value);
    }

    @GetMapping("/delete")
    public String delete(long _id) {
        return humanService.delete(_id);
    }

    @GetMapping("/selectOne")
    public HumanEntity selectOne(long _id) {
        return humanService.selectOne(_id);
    }
}
