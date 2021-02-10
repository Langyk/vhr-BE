package com.simon.vhr.controller.config;

import com.simon.vhr.bean.Menu;
import com.simon.vhr.bean.Position;
import com.simon.vhr.bean.RespBean;
import com.simon.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Simon Lang
 * @Description: Think Twice, Code Once
 * @Date: 2021/1/24 16:44
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {

    @Autowired
    MenuService menuService;

    //不使用前端传进来的ID。使用保存在内存中的用户信息进行获取
    @GetMapping("/menu")
    public List<Menu> getMenusByHrId(){
      return   menuService.getMenusByHrId();
    }


}
