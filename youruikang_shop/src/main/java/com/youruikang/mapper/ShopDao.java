/**
 * 
 */
package com.youruikang.mapper;

import java.util.List;

import com.youruikang.entity.Room;
import com.youruikang.entity.Shop;

public interface ShopDao {

	List<Room> queryRoomList();
	List<Shop> queryShopList();
}
