package cn.harry12800.common.module;

/**
 * 聊天类型定义
 * @author harry12800
 *
 */
public interface ChatType {

	/**
	 * 广播消息
	 */
	public byte PUBLIC_CHAT = 0;

	/**
	 * 私聊消息
	 */
	public byte PRIVATE_CHAT = 1;
}
