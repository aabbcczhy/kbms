package com.fjnu.kbms.config;

import com.fjnu.kbms.shiro.Realm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //排除的页面
        filterChainDefinitionMap.put("/static/**", "anon");
        //anon表示可以匿名访问，authc表示需要认证通过才可以访问
        filterChainDefinitionMap.put("/user/**", "authc");
        filterChainDefinitionMap.put("/content/**", "authc");
        filterChainDefinitionMap.put("/manager/**", "authc");
        filterChainDefinitionMap.put("/comment/**", "authc");
        filterChainDefinitionMap.put("/index", "authc");
        filterChainDefinitionMap.put("/publish", "authc");
        filterChainDefinitionMap.put("/welcome", "authc");
        //如果拦截到的用户未登陆则自动跳转到登陆界面
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * @return
     * @description 开启shiro的注解（如@RequiresRoles，@RequiresPermissions）
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 该配置将允许使用注解 @RequiresPermissions @RequiresRoles 来进行角色、权限检查
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 自定义ManagerRealm
     * @return ManagerRealm
     */
    @Bean
    public Realm getRealm() {
        Realm realm = new Realm();
        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        return realm;
    }

    /**
     * Shiro核心组件SecurityManager
     * @return securityManager
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置Realm
        securityManager.setAuthenticator(new ModularRealmAuthenticator());
        securityManager.setRealm(getRealm());
        return securityManager;
    }

    /**
     * 配置加密规则，采用md5二次加密，并且在Realm中也通过SimpleAuthenticationInfo返回了加密时使用的盐。
     * @return hashedCredentialsMatcher
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }
}
