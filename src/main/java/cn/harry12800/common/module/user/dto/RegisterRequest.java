package cn.harry12800.common.module.user.dto;

import cn.harry12800.common.core.serial.Serializer;

/**
 * 注册请求
 * @author harry12800
 *
 */
public class RegisterRequest extends Serializer {

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String passward;

	public String getPlayerName() {
		return userName;
	}

	public void setPlayerName(String playerName) {
		this.userName = playerName;
	}

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}

	@Override
	protected void read() {
		this.userName = readString();
		this.passward = readString();
	}

	@Override
	protected void write() {
		writeString(userName);
		writeString(passward);
	}
}
