package com.bw.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author 陈楠
 *
 * 2019年6月11日
 */
public interface MovieMapperDao {

	List<Map<String, Object>> selectList(Map<String, Object> map);

	int updateStatus(Map<String, Object> map);

	int delete(String ids);

}
