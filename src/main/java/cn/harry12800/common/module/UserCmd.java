package cn.harry12800.common.module;

import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;

/**
 * 用户模块
 * @author harry12800
 *
 */
public interface UserCmd {

	/**
	 * 创建并登录帐号
	 */
	short REGISTER_AND_LOGIN = 1;

	/**
	 * 登录帐号
	 */
	short LOGIN = 2;
	short SHOW_ALL_USER = 3;
	short PULL_MSG = 4;
	public static void main(String[] args) {
		int x = Math.max(1, SystemPropertyUtil.getInt("io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));
		System.out.println(x);
		 int y = NettyRuntime.availableProcessors() * 2;
		 System.out.println(y);
	}
}
