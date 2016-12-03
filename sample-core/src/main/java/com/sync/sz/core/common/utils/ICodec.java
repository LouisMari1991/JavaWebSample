package com.sync.sz.core.common.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public interface ICodec {

  ObjectMapper getMapper();

  <T> T decode(byte[] json) throws JsonParseException, JsonMappingException, IOException;

  <T> T decode(String json) throws JsonParseException, JsonMappingException, IOException;

  <T> T decode(InputStream in) throws JsonParseException, JsonMappingException, IOException;

  String encode(Object value) throws JsonProcessingException;

  byte[] encodeByte(Object value) throws JsonProcessingException;
}
