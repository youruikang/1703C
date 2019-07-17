/**
 * 
 */
package com.test.pack;

import java.util.Date;

import org.junit.Test;

import com.date.pack.DateUtil;

public class DateTest {

	@Test
	public void fun1() {
		Date date = new Date();
		DateUtil.getAge(date);
	}
	
}
