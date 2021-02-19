package com.simon.vhr.service;

import com.simon.vhr.bean.Hr;
import com.simon.vhr.bean.Menu;
import com.simon.vhr.mapper.MenuMapper;
import com.simon.vhr.mapper.MenuRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    MenuRoleMapper menuRoleMapper;
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

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    public List<Integer> getMidsByRid(Integer rid) {
        return menuMapper.getMidsByRid(rid);
    }

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        //先删除，后添加
        menuRoleMapper.deleteByRid(rid);
       Integer result= menuRoleMapper.insertRecord(rid,mids);
        return result==mids.length;
    }
}
