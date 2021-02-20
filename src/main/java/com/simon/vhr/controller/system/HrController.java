package com.simon.vhr.controller.system;

import com.simon.vhr.bean.Hr;
import com.simon.vhr.bean.RespBean;
import com.simon.vhr.bean.Role;
import com.simon.vhr.service.HrService;
import com.simon.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Simon Lang
 * @Description: Think Twice, Code Once
 * @Date: 2021/2/20 11:41
 */
@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;
    @GetMapping("/")
    public List<Hr> getAllHrs() {
        return hrService.getAllHrs();
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRole(Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
//
//    @DeleteMapping("/{id}")
//    public RespBean deleteHrById(@PathVariable Integer id) {
//        if (hrService.deleteHrById(id) == 1) {
//            return RespBean.ok("删除成功!");
//        }
//        return RespBean.error("删除失败!");
//    }
}
