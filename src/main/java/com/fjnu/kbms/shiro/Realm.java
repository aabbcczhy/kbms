package com.fjnu.kbms.shiro;

import com.fjnu.kbms.bean.User;
import com.fjnu.kbms.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class Realm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	/**
	 * 获取授权信息
	 * @param principals 凭证
	 * @return 授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取登录凭证
		String username = (String) principals.getPrimaryPrincipal();
		// 根据用户名获取用户信息
		User user = userService.getUserByName(username);
		// 授权
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// 1是管理员，0是普通会员
		authorizationInfo.addRole(String.valueOf(user.getRole()));
		return authorizationInfo;
	}

	/**
	 * 获取认证信息
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		if(token.getPrincipal() == null){
			return null;
		}
		// 获取用户信息
		String username = token.getPrincipal().toString();
		User user = userService.getUserByName(username);
		if(user == null) {
			return null;
		}else{
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,user.getPassword(),getName());
			authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(username));
			return authenticationInfo;
		}
	}

}
