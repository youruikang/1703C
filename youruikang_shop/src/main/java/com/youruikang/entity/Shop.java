/**
 * 
 */
package com.youruikang.entity;


public class Shop {
	private Integer sid;
	private String sname;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Shop [sid=" + sid + ", sname=" + sname + "]";
	}
	/**
	 * @return the sid
	 */
	public Integer getSid() {
		return sid;
	}
	/**
	 * @param sid the sid to set
	 */
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}
	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}
	/**
	 * @param sid
	 * @param sname
	 */
	public Shop(Integer sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}
	/**
	 * 
	 */
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
