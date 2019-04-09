package simple.framework.util;

import org.apache.commons.lang3.StringUtils;

public final class CastUtil {

	public static String castString(Object obj) {
		return castString(obj, "");
	}
	
	public static String castString(Object obj, String defaultValue) {
		return obj != null ? String.valueOf(obj) : defaultValue;
	}
	
	public static double castDouble(Object obj) {
		return castDouble(obj, 0);
	}
	
	public static double castDouble(Object obj, double defaultValue) {
		double value = defaultValue;
		if (obj != null) {
			String objStr = castString(obj);
			if (StringUtils.isNotEmpty(objStr)) {
				try {
					value = Double.parseDouble(objStr);
				} catch (NumberFormatException e) {
					value = defaultValue;
				}
			}
		}
		return value;
	}
	
	public static long castLong(Object obj) {
		return castLong(obj, 0);
	}
	
	public static long castLong(Object obj, long defaultValue) {
		long value = defaultValue;
		if (obj != null) {
			String objStr = castString(obj);
			if (StringUtils.isNotEmpty(objStr)) {
				try {
					value = Long.parseLong(objStr);
				} catch (NumberFormatException e) {
					value = defaultValue;
				}
			}
		}
		return value;
	}
	
	public static int castInt(Object obj) {
		return castInt(obj, 0);
	}
	
	public static int castInt(Object obj, int defaultValue) {
		int value = defaultValue;
		if (obj != null) {
			String objStr = castString(obj);
			if (StringUtils.isNotEmpty(objStr)) {
				try {
					value = Integer.parseInt(objStr);
				} catch (NumberFormatException e) {
					value = defaultValue;
				}
			}
		}
		return value;
	}
	
	public static boolean castBoolean(Object obj) {
		return castBoolean(obj, false);
	}
	
	public static boolean castBoolean(Object obj, boolean defaultValue) {
		boolean value = defaultValue;
		if (obj != null) {
			value = Boolean.parseBoolean(castString(obj));
		}
		return value;
	}
}
