/**
 * 
 */
package com.bw.cms.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bw.cms.core.Page;
import com.bw.cms.domain.Article;
import com.bw.cms.domain.Comment;


/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月16日 下午9:18:02
 */
public interface ArticleMapper {

	/**
	 * 功能说明：保存文章<br>
	 * @param article
	 * void
	 */
	public void save(Article article);
	

	/**
	 * 功能说明：递增访问量<br>
	 * @param id
	 * void
	 */
	public void increaseHit(int id);
	
	
	/**
	 * 功能说明：查询文章<br>
	 * @return
	 * List<Article>
	 */
	public List<Article> selects(@Param("article") Article article, @Param("order") LinkedHashMap<String, Boolean> orders, @Param("page") Page page);
	
	
	/**
	 * 功能说明：统计<br>
	 * @param article
	 * @return
	 * int
	 */
	public int count(@Param("article") Article article);


	/**
	 * @param id
	 * @return 
	 */
	public Article selectByPrimaryKey(Integer id);


	/**
	 * @param article
	 * @return 
	 */
	public List<Article> queryAll(@Param("article")Article article);


	/**
	 * @param article
	 */
	public void updateByKey(Article article);


	/**
	 * @param id
	 * @return 
	 */
	public Integer delete(Integer id);


	/**
	 * @param id
	 * @return
	 */
	public List<Comment> showMyComments(Integer id);

}
