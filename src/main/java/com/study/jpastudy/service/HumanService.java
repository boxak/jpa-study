package com.study.jpastudy.service;

import com.study.jpastudy.entity.HumanEntity;
import com.study.jpastudy.repository.HumanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HumanService {
    @Autowired
    HumanRepository humanRepository;

    Logger log = LoggerFactory.getLogger(HumanService.class);

    public String insert(HumanEntity humanEntity) {
        String msg = "";
        try {
            humanRepository.save(humanEntity);
            msg = "입력이 완료되었습니다";
        } catch (Exception e) {
            msg = "입력에 실패했습니다!";
            log.info(e.getMessage());
        }
        return msg;
    }

    public String update(HumanEntity humanEntity) {
        String msg = "";
        try {
            System.out.println(humanEntity);
            humanRepository.updateHuman(humanEntity.get_id(),
                    humanEntity.getName(),
                    humanEntity.getAge(),
                    humanEntity.getMoney());
            msg = "업데이트가 완료되었습니다";
        } catch (Exception e) {
            msg = "업데이트에 실패했습니다!";
            log.info(e.getMessage());
        }
        return msg;
    }

    public List<HumanEntity> search(String key,String value) {
        List<HumanEntity> list = new ArrayList<>();
        if(key == null) {
            list = humanRepository.findAll();
        } else if("name".equals(key)) {
            list = humanRepository.findAllByName(value);
        } else if("age".equals(key)) {
            int temp = Integer.parseInt(value);
            list = humanRepository.findAllByAge(temp);
        } else if("money".equals(key)) {
            int temp = Integer.parseInt(value);
            list = humanRepository.findAllByMoney(temp);
        }
        return list;
    }

    public String delete(long _id) {
        String msg = "";
        try {
            humanRepository.deleteById(_id);
            msg = "삭제가 완료되었습니다";
        } catch (Exception e) {
            msg = "삭제에 실패했습니다!";
            log.info(e.getMessage());
        }
        return msg;
    }

    public HumanEntity selectOne(long _id) {
        return humanRepository.getOne(_id);
    }
}
