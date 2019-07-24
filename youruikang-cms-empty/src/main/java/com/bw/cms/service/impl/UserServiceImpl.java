/**
 * 
 */
package com.bw.cms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.cms.dao.UserMapper;
import com.bw.cms.domain.User;
import com.bw.cms.service.UserService;

/**
 * 说明:用户服务
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月27日 下午1:10:12
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	protected UserMapper userMapper;
	
	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.UserService#get(int)
	 */
	@Override
	public User get(int id){
		return userMapper.selectById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.UserService#get(java.lang.String)
	 */
	@Override
	public User get(String username){
		return userMapper.selectByUsername(username);
	}

	@Override
	public int count(User conditions) {
		return userMapper.count(conditions);
	}

	/* (non-Javadoc)
	 * @see com.youruikang.cms.service.UserService#selectById(java.lang.Integer)
	 */
	@Override
	public User selectById(Integer id) {
		return userMapper.selectById(id);
	}

	/* (non-Javadoc)
	 * @see com.youruikang.cms.service.UserService#updateById(com.youruikang.cms.domain.User)
	 */
	@Override
	public void updateById(User user) {
		userMapper.updateById(user);
	}

	
}
