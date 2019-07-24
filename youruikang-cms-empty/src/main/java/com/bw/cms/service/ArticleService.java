package com.bw.cms.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bw.cms.core.Page;
import com.bw.cms.domain.Article;
import com.bw.cms.domain.Comment;
import com.bw.cms.domain.User;

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

	/**
	 * @param article
	 * @return
	 */
	public abstract List<Article> queryAll(Article article);

	/**
	 * @param article
	 */
	public abstract void updateByKey(Article article);

	/**
	 * @param article
	 */
	public abstract void save(Article article);

	/**
	 * @param id
	 * @return 
	 */
	public abstract boolean remove(Integer id);

	/**
	 * @param id
	 * @return
	 */
	public abstract List<Comment> showMyComments(Integer id);
	

}