package simple.framework.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import simple.framework.bean.FormParam;
import simple.framework.bean.Param;
import simple.framework.consts.ConfigConstant;
import simple.framework.util.CodecUtil;
import simple.framework.util.IOUtil;

public class RequestHelper {

	public static Param createParam(HttpServletRequest request) throws IOException {
		List<FormParam> formParamList = new ArrayList<FormParam>();
		formParamList.addAll(parseParameterNames(request));
		formParamList.addAll(parseInputstreamNames(request));
		return new Param(formParamList);
	}

	private static List<FormParam> parseParameterNames(
			HttpServletRequest request) {
		List<FormParam> formParamList = new ArrayList<FormParam>();
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String fieldName = paramNames.nextElement();
			String[] fieldValues = request.getParameterValues(fieldName);
			if (ArrayUtils.isNotEmpty(fieldValues)) {
				Object fieldValue = null;
				if (fieldValues.length == 1) {
					fieldValue = fieldValues[0];
				} else {
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < fieldValues.length; i++) {
						sb.append(fieldValues[i]);
						if (i != fieldValues.length - 1) {
							sb.append(ConfigConstant.SEPARATOR);
						}
					}
					fieldValue = sb.toString();
				}
				formParamList.add(new FormParam(fieldName, fieldValue));
			}
		}
		return formParamList;
	}
	
	private static List<FormParam> parseInputstreamNames (
			HttpServletRequest request) throws IOException  {
		List<FormParam> formParamList = new ArrayList<FormParam>();
		String body = CodecUtil.decodeUrl(IOUtil.getString(request.getInputStream()));
		if (StringUtils.isNotEmpty(body)) {
			String[] kvs = body.split("&");
			if (ArrayUtils.isNotEmpty(kvs)) {
				for (String kv : kvs) {
					String[] array = kv.split("=");
					if (ArrayUtils.isNotEmpty(array) && array.length == 2) {
						String fieldName = array[0];
						String fieldValue = array[1];
						formParamList.add(new FormParam(fieldName, fieldValue));
					}
				}
			}
		}
		return formParamList;
	}
	
	
}
