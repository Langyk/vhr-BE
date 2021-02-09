package com.simon.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @Author: Simon Lang
 * @Description: Think Twice, Code Once
 * @Date: 2021/2/9 12:33
 */
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        //ConfigAttribute就是在CustomFilterInvocationSecurityMetadataSource类中查找到的所有角色的集合
        for (ConfigAttribute configAttribute : configAttributes) {
            String needRole = configAttribute.getAttribute();
            //如果是"ROLE_LOGIN"，则是登录后可访问
            if ("ROLE_LOGIN".equals(needRole)) {
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("尚未登录，请登录!");
                }else {
                    return;
                }
            }
            //Authentication是访问菜单页需要满足的角色
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            //循环遍历，查找用户需要的角色是否在以查找的角色集合中
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足，请联系管理员!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
