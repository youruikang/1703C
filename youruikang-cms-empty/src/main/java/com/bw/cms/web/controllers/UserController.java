/**
 * 
 */
package com.bw.cms.web.controllers;

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

import com.bw.cms.core.Page;
import com.bw.cms.domain.Article;
import com.bw.cms.domain.Category;
import com.bw.cms.domain.Channel;
import com.bw.cms.domain.Comment;
import com.bw.cms.domain.User;
import com.bw.cms.service.ArticleService;
import com.bw.cms.service.CommentService;
import com.bw.cms.service.UserService;
import com.bw.cms.utils.FileUploadUtil;
import com.bw.cms.utils.PageHelpUtil;
import com.bw.cms.web.Constant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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

	@RequestMapping({"comments"})
	public String comments() {
		return "redirect:/my/mycomments";
	}
	
	
	
	//文章列表
	@RequestMapping("/blogs")
	public String blogs(Model model,HttpSession session,
			@RequestParam(defaultValue="1")Integer pageNum) {
		
		Article article = new Article();
		
		//当前登录用户
		User user = (User) session.getAttribute(Constant.LOGIN_USER);
		article.setAuthor(user);
		
		//当前用户发布的所有文章
		List<Article> articles  = articleService.queryAll(article);
		
		//分页信息
		PageHelper.startPage(pageNum,1);
		PageInfo<Article> page = new PageInfo<Article>(articles);
		
		//将查询到的数据传到前台
		model.addAttribute("blogs", articles);
		model.addAttribute("page", page);
		
		return "user-space/blog_list";
	}

	//修改文章
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
	
	//删除文章
	@RequestMapping("/blog/remove")
	@ResponseBody
	public boolean remove(Integer id) {
		boolean b  = articleService.remove(id);
		
		return b;
	}
	
	//修改个人信息
	@RequestMapping("/updated")
	public String update(User user) {
		userService.updateById(user);
		return "redirect:/my/userinfo";
	}
	
	//修改个人信息
	@RequestMapping("/userinfo")
	public String userinfo(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constant.LOGIN_USER);
		User u = userService.selectById(user.getId());
		model.addAttribute("user", u);
		return "user-space/userdit";
	}
	
	//查看评论
	@RequestMapping("/mycomments")
	public String showMyComments(HttpSession session,Model model) {
		User user = (User) session.getAttribute(Constant.LOGIN_USER);
		Integer id = user.getId();
		List<Comment> comments = articleService.showMyComments(id);
		model.addAttribute("comment", comments);
		return "user-space/comments";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
