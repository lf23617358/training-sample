package com.iisigroup.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

public class BeanUtils {
	public static <INPUT, OUTPUT> OUTPUT convertObj(INPUT obj, Class<OUTPUT> targetClass) {
		if (obj == null)
			return null;
		OUTPUT returnObj = null;
		try {
			returnObj = targetClass.newInstance();
			org.springframework.beans.BeanUtils.copyProperties(obj, returnObj);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return returnObj;
	}

	public static <INPUT, OUTPUT> List<OUTPUT> convertList(List<INPUT> objs, Class<OUTPUT> targetClass) {
		if (ObjectUtils.isEmpty(objs))
			return null;
		List<OUTPUT> returnObjs = new ArrayList<OUTPUT>();
		for (INPUT obj : objs) {
			returnObjs.add(convertObj(obj, targetClass));
		}
		return returnObjs;
	}

}
