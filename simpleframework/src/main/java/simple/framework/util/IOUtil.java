package simple.framework.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class IOUtil {

	private static final Logger LOG = LoggerFactory.getLogger(IOUtil.class);
	
	public static String getString(InputStream is) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			LOG.error("read String from InputStream failed", e);
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
	
}
