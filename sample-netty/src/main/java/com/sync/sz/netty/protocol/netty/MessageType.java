package com.sync.sz.netty.protocol.netty;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public enum MessageType {

  SERVICE_REQ((byte) 0),
  SERVER_RESP((byte) 1),
  ONE_WAY((byte) 2),
  LOGIN_REQ((byte) 3),
  LOGIN_RESP((byte) 4),
  HEARTBEAT_REQ((byte) 5),
  HEARTBEAT_RESP((byte) 6);

  private byte value;

  private MessageType(byte value) {
    this.value = value;
  }

  public byte value() {
    return this.value;
  }

}
