package cn.harry12800.common.module.user.dto;

import cn.harry12800.common.core.serial.Serializer;

/**
 * 玩家信息
 * @author -harry12800-
 *
 */
public class UserResponse extends Serializer {

	/**
	 * id
	 */
	private long id;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 等级
	 */
	private int level;

	/**
	 * 经验值
	 */
	private int exp;

	public long getId() {
		return id;
	}

	public void setId(long playerId) {
		this.id = playerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String playerName) {
		this.userName = playerName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	@Override
	protected void read() {
		this.id = readLong();
		this.userName = readString();
		this.level = readInt();
		this.exp = readInt();
	}

	@Override
	protected void write() {
		writeLong(id);
		writeString(userName);
		writeInt(level);
		writeInt(exp);
	}

	@Override
	public String toString() {
		return "UserResponse [id=" + id + ", userName=" + userName + ", level=" + level + ", exp=" + exp + "]";
	}
	
}
