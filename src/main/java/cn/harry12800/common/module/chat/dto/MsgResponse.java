package cn.harry12800.common.module.chat.dto;

import java.util.Arrays;
import java.util.Date;

import cn.harry12800.common.core.serial.Serializer;

public class MsgResponse extends Serializer {
	private long id;
	private int online;
	private String fromId;
	private String toId;
	private Date sendTime;
	private int dataType;
	private byte[] data;

	@Override
	protected void read() {
		id = readLong();
		online = readInt();
		fromId = readString();
		toId = readString();
		sendTime = new Date(readLong());
		dataType = readInt();
		data = readString().getBytes();
	}

	@Override
	protected void write() {
		writeLong(id);
		writeInt(online);
		writeString(fromId);
		writeString(toId);
		writeLong(sendTime.getTime());
		writeInt(dataType);
		writeString(new String(data));
	}

	public long getId() {
		return id;
	}

	public MsgResponse setId(long id) {
		this.id = id;
		return this;
	}

	public int getOnline() {
		return online;
	}

	public MsgResponse setOnline(int online) {
		this.online = online;
		return this;
	}

	public String getFromId() {
		return fromId;
	}

	public MsgResponse setFromId(String fromId) {
		this.fromId = fromId;
		return this;
	}

	public String getToId() {
		return toId;
	}

	public MsgResponse setToId(String toId) {
		this.toId = toId;
		return this;
	}

	public Date getSendTime() {
		return sendTime;
	}

	@Override
	public String toString() {
		return "MsgResponse [id=" + id + ", fromId=" + fromId + ", toId=" + toId + ", sendTime=" + sendTime + ", dataType=" + dataType + ", data=" + Arrays.toString(data)
				+ "]";
	}

	public MsgResponse setSendTime(Date sendTime) {
		this.sendTime = sendTime;
		return this;
	}

	public int getDataType() {
		return dataType;
	}

	public MsgResponse setDataType(int dataType) {
		this.dataType = dataType;
		return this;
	}

	public byte[] getData() {
		return data;
	}

	public MsgResponse setData(byte[] data) {
		this.data = data;
		return this;
	}

}
