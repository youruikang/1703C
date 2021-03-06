/**
 * 
 */
package com.youruikang.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import org.aspectj.bridge.Message;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.youruikang.common.utils.AssertUtil;
import com.youruikang.common.utils.Runtime;
import com.youruikang.entity.Room;
import com.youruikang.entity.Shop;
import com.youruikang.service.ShopService;

@Controller
public class ShopController {

	@Resource
	private ShopService service;
	
	@RequestMapping("list.do")
	public String queryRoomList(Model model,@RequestParam(required=false,defaultValue="1")Integer pageNum){
		Page<Object> startPage = PageHelper.startPage(pageNum,3);
		List<Room> rlist = service.queryRoomList();
		PageInfo<Room> page = new PageInfo<Room>(rlist);
		List<Shop> slist = service.queryShopList();
		model.addAttribute("page", page);
		model.addAttribute("slist", slist);
		model.addAttribute("rlist", rlist);
		return "list";
	}
	@Test
	public void istrue() {
		String username = "";
		try {
			AssertUtil.isNull("username", "用户名为空");
		} catch (Runtime e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
