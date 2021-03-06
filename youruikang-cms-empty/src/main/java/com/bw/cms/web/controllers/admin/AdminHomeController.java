/**
 * 
 */
package com.bw.cms.web.controllers.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.cms.web.controllers.PassportController;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月29日 下午6:54:11
 */
@Controller
@RequestMapping("/admin")
public class AdminHomeController {

	public static Logger log = LoggerFactory.getLogger(PassportController.class);
	
	@RequestMapping({"/", "/index"})
	public String home(){
		return "admin/home";
	}
}
