package simple.framework.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;

import simple.framework.consts.ConfigConstant;
import simple.framework.util.CastUtil;

public class Param {
	
	private List<FormParam> formParamList;
	private List<FileParam> fileParamList;
	
	public Param(List<FormParam> formParamList) {
		this.formParamList = formParamList;
	}
	
	public Param(List<FormParam> formParamList, List<FileParam> fileParamList) {
		this.formParamList = formParamList;
		this.fileParamList = fileParamList;
	}

	public Map<String, Object> getFieldMap() {
		Map<String, Object> fieldMap = new HashMap<String, Object>();
		if (CollectionUtils.isNotEmpty(formParamList)) {
			for (FormParam formParam : formParamList) {
				String fieldName = formParam.getFieldName();
				Object fieldValue = formParam.getFieldValue();
				if (fieldMap.containsKey(fieldName)) {
					fieldValue = fieldMap.get(fieldName) + ConfigConstant.SEPARATOR + fieldValue;
				}
				fieldMap.put(fieldName, fieldValue);
			}
		}
		return fieldMap;
	}
	
	public Map<String, List<FileParam>> getFileMap() {
		Map<String, List<FileParam>> fileMap = new HashMap<String, List<FileParam>>();
		for (FileParam fileParam : fileParamList) {
			String fieldName = fileParam.getFieldName();
			List<FileParam> fileParamList;
			if (fileMap.containsKey(fieldName)) {
				fileParamList = fileMap.get(fieldName);
			} else {
				fileParamList = new ArrayList<FileParam>();
			}
			fileParamList.add(fileParam);
			fileMap.put(fieldName, fileParamList);
		}
		return fileMap;
	}

	public List<FileParam> getFileList(String fieldName) {
		return getFileMap().get(fieldName);
	}
	
	public FileParam getFile(String fieldName) {
		FileParam fileParam = null;
		List<FileParam> fileList = getFileList(fieldName);
		if (CollectionUtils.isNotEmpty(fileList)) {
			fileParam = fileList.get(0);
		}
		return fileParam;
	}

	
	public boolean isEmpty() {
		return CollectionUtils.isEmpty(formParamList)
				&& CollectionUtils.isEmpty(fileParamList);
	}
	
	public String getString(String name) {
		return CastUtil.castString(getFieldMap().get(name));
	}
	
}
