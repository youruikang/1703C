/**
 * 
 */
package com.bw.cms.web.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.cms.domain.Category;
import com.bw.cms.domain.Channel;
import com.bw.cms.service.ChannelCategoryService;

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
