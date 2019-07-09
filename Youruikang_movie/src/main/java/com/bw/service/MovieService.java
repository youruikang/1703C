package com.bw.service;

import java.util.List;
import java.util.Map;

/**
 * @author 陈楠
 *
 * 2019年6月11日
 */
public interface MovieService {

	List<Map<String, Object>> findList(Map<String, Object> map);

	int updateStatus(Map<String, Object> map);

	int delete(String ids);

}
