package com.bw.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.mapper.MovieMapperDao;

/**
 * @author 陈楠
 *
 * 2019年6月11日
 */
@Service
public class MovieServiceImp implements MovieService{
	@Resource
	private MovieMapperDao movieMapperDao;

	@Override
	public List<Map<String, Object>> findList(Map<String, Object> map) {
		return movieMapperDao.selectList(map);
	}

	@Override
	public int updateStatus(Map<String, Object> map) {
		return movieMapperDao.updateStatus(map);
	}

	@Override
	public int delete(String ids) {
		return movieMapperDao.delete(ids);
	}
}
