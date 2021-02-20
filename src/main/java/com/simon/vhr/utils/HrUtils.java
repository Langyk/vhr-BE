package com.simon.vhr.utils;

import com.simon.vhr.bean.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author: Simon Lang
 * @Description: Think Twice, Code Once
 * @Date: 2021/2/20 11:50
 */
public class HrUtils {
    public static Hr getCurrentHr() {
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
