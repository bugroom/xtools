package simple.framework.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simple.framework.consts.ConfigConstant;

public final class CodecUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(CodecUtil.class);

	public static String encodeUrl(String source) {
		String targe = null;
		try {
			targe = URLEncoder.encode(source, ConfigConstant.CHARSET_UTF8);
		} catch (UnsupportedEncodingException e) {
			LOG.error("encode url failed", e);
			throw new RuntimeException(e);
		}
		return targe;
	}
	
	public static String decodeUrl(String source) {
		String targe = null;
		try {
			targe = URLDecoder.decode(source, ConfigConstant.CHARSET_UTF8);
		} catch (UnsupportedEncodingException e) {
			LOG.error("decode url failed", e);
			throw new RuntimeException(e);
		}
		return targe;
	}
	
}
