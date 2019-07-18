package com.youruikang.cms.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.youruikang.cms.core.Page;
import com.youruikang.cms.domain.Article;
import com.youruikang.cms.domain.User;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月28日 下午4:48:47
 */
public interface ArticleService {

	/**
	 * 功能说明：<br>
	 * @param conditions
	 * @param page
	 * @param orders  排序，默认按创建时间倒排序
	 * @return
	 * List<Article>
	 */
	public abstract List<Article> gets(Article conditions, Page page, LinkedHashMap<String, Boolean> orders);

	/**
	 * @param id
	 */
	public abstract void increaseHit(Integer id);

	/**
	 * @param id
	 * @return 
	 */
	public abstract Article selectByPrimaryKey(Integer id);
	

}