package cn.harry12800.common.module.chat.dto;

import cn.harry12800.common.core.serial.Serializer;

/**
 * 私聊请求
 * @author harry12800
 *
 */
public class ShakeRequest extends Serializer {
	/**
	 * 要向哪个会话发消息
	 */
	private long targetPlayerId; 
	@Override
	protected void read() {
		this.targetPlayerId = readLong();
	}

	@Override
	protected void write() {
		writeLong(targetPlayerId);
	}

	public long getTargetPlayerId() {
		return targetPlayerId;
	}

	public void setTargetPlayerId(long targetPlayerId) {
		this.targetPlayerId = targetPlayerId;
	}
	
}
