package simple.framework.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

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

	public static void copy(InputStream is, OutputStream os) {
		try {
			int length;
			byte[] buffer = new byte[4 * 1024];
			while ((length = is.read(buffer, 0, buffer.length)) != -1) {
				os.write(buffer, 0, length);
			}
			os.flush();
		} catch (IOException e) {
			LOG.error("copy io failed", e);
			throw new RuntimeException(e);
		} finally {
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				LOG.error("close io stream failed", e);
				throw new RuntimeException(e);
			}
		}
	}
	
}
