package simple.framework.bean;

import java.util.Map;

import org.apache.commons.collections4.MapUtils;

import simple.framework.util.CastUtil;

public class Param {

	private Map<String, Object> paramMap;

	public Param(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}
	
	public long getLong(String name) {
		return CastUtil.castLong(paramMap.get(name));
	}
	
	public Map<String, Object> getMap() {
		return this.paramMap;
	}
	
	public boolean isEmpty() {
		return MapUtils.isEmpty(this.paramMap);
	}
}
