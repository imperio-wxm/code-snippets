package com.wxmimperio.jetty.utils;

import org.apache.commons.lang.StringUtils;

public class FolderUtil {

	private static String local_log_path = "c:";//默认路径
	
	static{
		String prop_path = PropertyUtil.getInstance().getProperty("local.log.path");
		if (StringUtils.isNotBlank(prop_path)) {
			local_log_path = prop_path;
		}
	}
	public static String getLogPath() {
		return local_log_path;
	}
}
