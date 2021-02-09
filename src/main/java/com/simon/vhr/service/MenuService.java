package com.simon.vhr.service;

import com.simon.vhr.bean.Hr;
import com.simon.vhr.bean.Menu;
import com.simon.vhr.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Simon Lang
 * @Description: Think Twice, Code Once
 * @Date: 2021/1/24 16:47
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    public List<Menu> getMenusByHrId() {
        return menuMapper.getMenusByHrId(((Hr)SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                .getId());
    }

    /**
     * 获取菜单项对应的所有角色
     * @return
     */
    public List<Menu> getAllMenusWithRole(){
        return menuMapper.getAllMenusWithRole();
    }
}
