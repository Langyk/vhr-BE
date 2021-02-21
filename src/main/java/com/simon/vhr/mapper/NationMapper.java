package com.simon.vhr.mapper;

import com.simon.vhr.bean.Nation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Nation record);

    int insertSelective(Nation record);

    Nation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nation record);

    int updateByPrimaryKey(Nation record);

    List<Nation> getAllNations();
}