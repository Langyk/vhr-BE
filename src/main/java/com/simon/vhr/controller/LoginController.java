package com.simon.vhr.controller;

import com.simon.vhr.bean.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Simon Lang
 * @Description: Think Twice, Code Once
 * @Date: 2021/1/23 11:03
 */
@RestController
public class LoginController {
    @GetMapping(value = "/login")
    public RespBean login(){
        return RespBean.error("尚未登录，请登录");
    }
}
