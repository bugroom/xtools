package simple.framework.helper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simple.framework.bean.FileParam;
import simple.framework.bean.FormParam;
import simple.framework.bean.Param;
import simple.framework.consts.ConfigConstant;
import simple.framework.util.FileUtil;
import simple.framework.util.IOUtil;

public class UploadHelper {

	private static final Logger LOG = LoggerFactory.getLogger(UploadHelper.class);
	
	private static ServletFileUpload servletFileUpload;
	
	public static void init(ServletContext servletContext) {
		File repository = (File)servletContext.getAttribute("javax.servlet.context.tempdir");
		servletFileUpload = new ServletFileUpload(
				new DiskFileItemFactory(DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD,	repository));
		int uploadLimit = ConfigHelper.getAppUploadLimit();
		if (uploadLimit != 0) {
			servletFileUpload.setFileSizeMax(uploadLimit);
		}
	}
	
	public static boolean isMultipart(HttpServletRequest request) {
		return ServletFileUpload.isMultipartContent(request);
	}
	
	public static Param createParam(HttpServletRequest request) throws IOException {
		List<FormParam> formParamList = new ArrayList<FormParam>();
		List<FileParam> fileParamList = new ArrayList<FileParam>();
		try {
			Map<String, List<FileItem>> fileItemListMap = servletFileUpload.parseParameterMap(request);
			if (MapUtils.isNotEmpty(fileItemListMap)) {
				for (Map.Entry<String, List<FileItem>> fileItemListEntry : fileItemListMap.entrySet()) {
					String fieldName = fileItemListEntry.getKey();
					List<FileItem> fileItemList = fileItemListEntry.getValue();
					if (CollectionUtils.isNotEmpty(fileItemList)) {
						for (FileItem fileItem : fileItemList) {
							if (fileItem.isFormField()) {
								String fieldValue = fileItem.getString(ConfigConstant.CHARSET_UTF8);
								formParamList.add(new FormParam(fieldName, fieldValue));
							} else {
								String fileName = FileUtil.getRealFileName(
										new String(fileItem.getName().getBytes(), ConfigConstant.CHARSET_UTF8));
								if (StringUtils.isNotEmpty(fileName)) {
									long fileSize = fileItem.getSize();
									String contentType = fileItem.getContentType();
									InputStream is = fileItem.getInputStream();
									fileParamList.add(new FileParam(fieldName, fileName, fileSize, contentType, is));
								}
							}
						}
					}
				}
			}
		} catch (FileUploadException e) {
			LOG.error("create param failed", e);
			throw new RuntimeException(e);
		}
		return new Param(formParamList, fileParamList);
	}
	
	
	public static void uploadFile(String basePath, FileParam fileParam) {
		try {
			if (fileParam != null) {
				String filePath = basePath + fileParam.getFileName();
				FileUtil.createFile(filePath);
				InputStream is = new BufferedInputStream(fileParam.getInputStream());
				OutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				IOUtil.copy(is, os);
			}
		} catch (Exception e) {
			LOG.error("upload file failed", e);
			throw new RuntimeException(e);
		}
	}
	
	public static void uploadFile(String basePath, List<FileParam> fileParamList) {
		if (CollectionUtils.isNotEmpty(fileParamList)) {
			for (FileParam fileParam : fileParamList) {
				uploadFile(basePath, fileParam);
			}
		}
	}
	
	
}
