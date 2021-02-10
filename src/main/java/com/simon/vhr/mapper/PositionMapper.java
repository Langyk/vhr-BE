package com.simon.vhr.mapper;

import com.simon.vhr.bean.Position;
import com.simon.vhr.bean.RespBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> getAllPositions();


}