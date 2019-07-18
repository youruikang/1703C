/**
 * 
 */
package com.youruikang.cms.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.youruikang.cms.core.Page;
import com.youruikang.cms.dao.ArticleMapper;
import com.youruikang.cms.domain.Article;
import com.youruikang.cms.service.ArticleService;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年4月21日 下午9:06:07
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Resource
	ArticleMapper articleMapper;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<Article> gets(Article conditions, Page page, LinkedHashMap<String, Boolean> orders) {
		List<Article> articles = articleMapper.selects(conditions, orders, page);
		if(page != null && page.getPageCount() == 0){
			int totalCount = articleMapper.count(conditions);
			page.setTotalCount(totalCount);
		}
		return articles;
	}

	/* (non-Javadoc)
	 * @see com.youruikang.cms.service.ArticleService#showById(java.lang.Integer)
	 */
	@Override
	public void increaseHit(Integer id) {
		articleMapper.increaseHit(id);
	}

	/* (non-Javadoc)
	 * @see com.youruikang.cms.service.ArticleService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public Article selectByPrimaryKey(Integer id) {
		return articleMapper.selectByPrimaryKey(id);
	}
	
	
}
