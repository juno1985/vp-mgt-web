package org.softcits.mgt.auth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 用来确定哪些方法由哪些角色访问
 * 其他可能值为
 * staff - 3
 * manager - 2
 * admin - 1 默认管理员可以访问所有controller

 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthMethod {
	public String roleId() default "";
}
