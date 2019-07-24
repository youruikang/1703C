/**
 * 
 */
package com.bw.cms.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bw.cms.core.Page;
import com.bw.cms.dao.ArticleMapper;
import com.bw.cms.domain.Article;
import com.bw.cms.domain.Comment;
import com.bw.cms.service.ArticleService;

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

	/* (non-Javadoc)
	 * @see com.youruikang.cms.service.ArticleService#queryAll(com.youruikang.cms.domain.Article)
	 */
	@Override
	public List<Article> queryAll(Article article) {
		return articleMapper.queryAll(article);
	}

	/* (non-Javadoc)
	 * @see com.youruikang.cms.service.ArticleService#updateByKey(com.youruikang.cms.domain.Article)
	 */
	@Override
	public void updateByKey(Article article) {
		articleMapper.updateByKey(article);
	}

	/* (non-Javadoc)
	 * @see com.youruikang.cms.service.ArticleService#save(com.youruikang.cms.domain.Article)
	 */
	@Override
	public void save(Article article) {
		articleMapper.save(article);
	}

	/* (non-Javadoc)
	 * @see com.youruikang.cms.service.ArticleService#remove(java.lang.Integer)
	 */
	@Override
	public boolean remove(Integer id) {
		Integer integer = articleMapper.delete(id);
		if(integer>0) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.youruikang.cms.service.ArticleService#showMyComments(java.lang.Integer)
	 */
	@Override
	public List<Comment> showMyComments(Integer id) {
		return articleMapper.showMyComments(id);
	}
	
	
}
