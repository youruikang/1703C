/**
 * 
 */
package com.youruikang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youruikang.entity.Room;
import com.youruikang.entity.Shop;
import com.youruikang.mapper.ShopDao;

@Service
public class ShopServiceImpl implements ShopService {

	@Resource
	private ShopDao dao;

	@Override
	public List<Room> queryRoomList() {
		return dao.queryRoomList();
	}
	@Override
	public List<Shop> queryShopList() {
		return dao.queryShopList();
	}
}
