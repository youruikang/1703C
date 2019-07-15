/**
 * 
 */
package com.youruikang.common.test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.youruikang.common.utils.AssertUtil;
import com.youruikang.common.utils.Runtime;

//测试类
public class Test1 {
		
		@Test
		public void isTrue() {
			try {
				AssertUtil.isTrue(true, "这不是true");
			} catch (Runtime e) {
				e.printStackTrace();
			}
		}
		//假
		@Test
		public void isFalse() {
			try {
				AssertUtil.isFalse(true, "这不是false");
			} catch (Runtime e) {
				e.printStackTrace();
			}
		}

		//不为空
		public void notNull() {
			try {
				AssertUtil.notNull(null, "为空");
			} catch (Runtime e) {
				e.printStackTrace();
			}
		}
	
		//断言对象必须空
		public void isNull() {
			try {
				AssertUtil.isNull(null, "不为空");
			} catch (Runtime e) {
				e.printStackTrace();
			}
		}
	
		//断言集合不为空，对象不能空
		public void notEmpty() {
			List<Object> list = new ArrayList<Object>();
			try {
				AssertUtil.notEmpty(list, "集合为空");
			} catch (Runtime e) {
				e.printStackTrace();
			}
		}

		//断言集合不为空，对象不能空
		public void notEmptyMap() {
			Map<?, ?> map = new HashMap<>();
			try {
				AssertUtil.notEmpty(map, "map为空");
			} catch (Runtime e) {
				e.printStackTrace();
			}
		}
	
		@org.junit.Test
		public void hasText() {
			try {
				AssertUtil.hasText("", "不为空");
			} catch (Runtime e) {
				e.printStackTrace();
			}
		}
	
}
