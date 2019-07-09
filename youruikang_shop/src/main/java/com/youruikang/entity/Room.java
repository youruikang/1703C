/**
 * 
 */
package com.youruikang.entity;


public class Room {
	private Integer rid;
	private String rname;
	private String rdate;
	
	private String sname;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Room [rid=" + rid + ", rname=" + rname + ", rdate=" + rdate + ", sname=" + sname + "]";
	}

	/**
	 * @return the rid
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * @param rid the rid to set
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * @return the rname
	 */
	public String getRname() {
		return rname;
	}

	/**
	 * @param rname the rname to set
	 */
	public void setRname(String rname) {
		this.rname = rname;
	}

	/**
	 * @return the rdate
	 */
	public String getRdate() {
		return rdate;
	}

	/**
	 * @param rdate the rdate to set
	 */
	public void setRdate(String rdate) {
		this.rdate = rdate;
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
	 * @param rid
	 * @param rname
	 * @param rdate
	 * @param sname
	 */
	public Room(Integer rid, String rname, String rdate, String sname) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.rdate = rdate;
		this.sname = sname;
	}

	/**
	 * 
	 */
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
