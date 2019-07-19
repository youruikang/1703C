/**
 * 
 */
package com.youruikang.cms.web.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.youruikang.cms.domain.Category;
import com.youruikang.cms.domain.Channel;
import com.youruikang.cms.service.ChannelCategoryService;

@Controller
public class ChannelController {

	@Resource
	private ChannelCategoryService channelCategoryService;
	
	@RequestMapping("queryAllChannel")
	@ResponseBody
	public List<Channel> queryAllChannel() {
		return channelCategoryService.getChannels();
	}
	
	@RequestMapping("queryCategoryByChannelId")
	@ResponseBody
	public List<Category> queryCategoryByChannelId(Integer channel) {
		return channelCategoryService.getCategories(channel);
	}
	
	
}
