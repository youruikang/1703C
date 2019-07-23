/**
 * 
 */
package com.youruikang.cms.web.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.youruikang.cms.core.Page;
import com.youruikang.cms.domain.Article;
import com.youruikang.cms.domain.Category;
import com.youruikang.cms.domain.Channel;
import com.youruikang.cms.domain.User;
import com.youruikang.cms.service.ArticleService;
import com.youruikang.cms.service.UserService;
import com.youruikang.cms.utils.FileUploadUtil;
import com.youruikang.cms.utils.PageHelpUtil;
import com.youruikang.cms.web.Constant;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午2:40:38
 */
@Controller
@RequestMapping("/my")
public class UserController {

	@Autowired
	ArticleService articleService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(){
		return "user-space/home";
	}
	
	@RequestMapping({"/userdit"})
	public String profile(){
		return "redirect:/my/userinfo";
	}

	@RequestMapping("/blogs")
	public String blogs(Model model,HttpSession session,
			@RequestParam(value="page",defaultValue="1")Integer page) {
		Article article = new Article();
		
		//当前登录用户
		User user = (User) session.getAttribute(Constant.LOGIN_USER);
		article.setAuthor(user);
		
		//当前用户发布的所有文章
		List<Article> articles  = articleService.queryAll(article);
		
		//分页信息
		PageHelper.startPage(page,3);
		PageInfo<Article> pageInfo = new PageInfo<Article>(articles,3);
		String pageList = PageHelpUtil.page("blogs", pageInfo, null);
		
		//将查询到的数据传到前台
		model.addAttribute("blogs", articles);
		model.addAttribute("pageList", pageList);
		
		return "user-space/blog_list";
	}

	@RequestMapping("/blog/edit")
	public String edit(Integer id,Model model) {
		
		Article article = articleService.selectByPrimaryKey(id);
		
		model.addAttribute("blog", article);
		
		return "user-space/blog_edit";
	}
	
	//修改和发布
	@RequestMapping("/blog/save")
	public String save(Article article,MultipartFile file,HttpServletRequest request) {
		
		String upload = FileUploadUtil.upload(request, file);
		if(!upload.equals("")) {
			article.setPicture(upload);
		}
		
		Integer id = article.getId();
		if(id != null) {
			//修改文章
			articleService.updateByKey(article);
		}else {
			//发布文章
			article.setHits(0);//设置点击次数初始值为零
			article.setHot(true);//设置是否为热门文章
			article.setStatus(1);//设置是否通过审核
			article.setDeleted(false);//设置是否被删除
			article.setCreated(new Date());//设置创建时间
			
			User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
			article.setAuthor(user);//设置文章作者
			
			articleService.save(article);
		
		}
		return "redirect:/my/blogs";
	}
	
	@RequestMapping("/blog/remove")
	@ResponseBody
	public boolean remove(Integer id) {
		boolean b  = articleService.remove(id);
		
		return b;
	}
	
	@RequestMapping("/updated")
	public String update(User user) {
		userService.updateById(user);
		return "redirect:/my/userinfo";
	}
	
	@RequestMapping("/userinfo")
	public String userinfo(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constant.LOGIN_USER);
		User u = userService.selectById(user.getId());
		model.addAttribute("user", u);
		return "user-space/userdit";
	}
	
}
