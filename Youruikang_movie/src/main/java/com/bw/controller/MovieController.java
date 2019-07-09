package com.bw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.service.MovieService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author 陈楠
 *
 *         2019年6月11日
 */
@Controller
public class MovieController {

	@Resource
	private MovieService movieService;

	@RequestMapping("list.do")
	public String findList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "") String mname,
			@RequestParam(defaultValue = "") String dname, @RequestParam(defaultValue = "0") int year,
			@RequestParam(defaultValue = "") String dlow, @RequestParam(defaultValue = "") String dhigh,
			@RequestParam(defaultValue = "") String plow, @RequestParam(defaultValue = "") String phigh,
			@RequestParam(defaultValue = "") String hlow, @RequestParam(defaultValue = "") String hhigh,
			@RequestParam(defaultValue = "") String horder, @RequestParam(defaultValue = "") String yorder,
			@RequestParam(defaultValue = "") String dorder, Model model) {
		// 創建一个map集合，将所有条件存入map集合中
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mname", mname);
		map.put("dname", dname);
		map.put("year", year);
		map.put("dlow", dlow);
		map.put("dhigh", dhigh);
		map.put("plow", plow);
		map.put("phigh", phigh);
		map.put("hlow", hlow);
		map.put("hhigh", hhigh);
		map.put("horder", horder);
		map.put("yorder", yorder);
		map.put("dorder", dorder);

		// 开启分页插件
		PageHelper.startPage(page, 3);

		// 获取符合条件的list集合
		List<Map<String, Object>> list = movieService.findList(map);

		// 将集合放入分页对象中
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);

		// 讲存放所有条件的集合放入model 中
		model.addAttribute("map", map);
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", pageInfo);

		return "list";
	}

	@RequestMapping("delete.do")
	@ResponseBody
	public String delete(String ids) {
//		调用删除的方法
		int i = movieService.delete(ids);
		return "redirect:list.do";
	}

	@RequestMapping("updateStatus.do")
	public String updateStatus(Integer status, Integer mid) {
//		 創建一个map集合，将所有条件存入map集合中
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", status);
		map.put("mid", mid);
//		调用修改方法
		int i = movieService.updateStatus(map);
		return "redirect:list.do";
	}

}
