package com.simon.vhr.service;

import com.simon.vhr.bean.Position;
import com.simon.vhr.bean.RespBean;
import com.simon.vhr.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: Simon Lang
 * @Description: Think Twice, Code Once
 * @Date: 2021/2/10 10:44
 */
@Service
public class PositionService {
    @Autowired
    PositionMapper positionMapper;

    /**
     *查询
     */
    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions();
    }

    /**
     *添加
     */
    public Integer addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());
        return positionMapper.insertSelective(position);
    }

    public Integer updatePositions(Position position) {
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePosition(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer deletePositionByIds(Integer[] ids) {
        return positionMapper.deletePositionByIds(ids);
    }
}
