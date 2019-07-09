/**
 * 
 */
package com.youruikang.service;

import java.util.List;

import com.youruikang.entity.Room;
import com.youruikang.entity.Shop;

public interface ShopService {

	/**
	 * @return
	 */
	List<Room> queryRoomList();

	/**
	 * @return
	 */
	List<Shop> queryShopList();

}
