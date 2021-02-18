package com.simon.vhr.mapper;

import com.simon.vhr.bean.JobLevel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface JobLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobLevel record);

    int insertSelective(JobLevel record);

    JobLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobLevel record);

    int updateByPrimaryKey(JobLevel record);

    List<JobLevel> getAllJobLevels();
}