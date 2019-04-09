package simple.framework.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtil {

	private static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);
	
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	public static <T> String toJson(T obj) {
		String json = null;
		try {
			json = OBJECT_MAPPER.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			LOG.error("convert Ojbect to JSON failed", e);
			throw new RuntimeException(e);
		}
		return json;
	}
	
	public static <T> T fromJson(String json, Class<T> type) {
		T obj = null;
		try {
			obj = OBJECT_MAPPER.readValue(json, type);
		} catch (IOException e) {
			LOG.error("convert JSON to Ojbect failed", e);
			throw new RuntimeException(e);
		}
		return obj;
	}
	
}
