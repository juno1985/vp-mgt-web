package org.softcits.mgt.auth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 用来确定哪些方法由哪些角色访问
 * 属性有一个role:如果role的值为""表示这个方法可以被所有的登录用户访问
 * 其他可能值为
 * staff - 3
 * manager - 2
 * admin - 1

 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthMethod {
	public String roleId() default "";
}
