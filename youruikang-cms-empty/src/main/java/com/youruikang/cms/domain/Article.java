/**
 * 
 */
package com.youruikang.cms.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 说明:文章表(cms_article)
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月16日  下午8:34:11
 */
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**主键**/
	private Integer id;
	
	/**标题**/
	private String title;
	
	/**摘要：如果用户不填，就从内容里提取前面144个字**/
	private String summary;
	
	/**内容：大文本字段**/
	@NotNull(message = "内容不能空")
	@Size(min = 10, message = "内容至少10个字以上")
	private String content;
	
	/**默认图片：如果没有上传，则从正文中提取图片，如果正文中没有，则为空。**/
	private String picture;
	
	/**所属频道：可快速搜索频道下所有文章**/
	private Channel channel;
	
	/**所属分类**/
	private Category category;
	
	/**作者**/
	private User author;
	
	/**点击量**/
	private Integer hits;

	/**是否热门（是否上头条）**/
	private Boolean hot;
	
	/**状态：0:审核不通过，1:审核通过**/
	private Integer status;
	
	/**是否删除：true-删除，false-不删除**/
	private Boolean deleted;

	/**创建时间**/
	private Date created;
	
	/**更新时间**/
	private Date updated;

	/**关键字**/
	private String keywords;
	
	/**原文链接**/
	private String orglink;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", summary=" + summary + ", content=" + content + ", picture="
				+ picture + ", channel=" + channel + ", category=" + category + ", author=" + author + ", hits=" + hits
				+ ", hot=" + hot + ", status=" + status + ", deleted=" + deleted + ", created=" + created + ", updated="
				+ updated + ", keywords=" + keywords + ", orglink=" + orglink + "]";
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * @return the channel
	 */
	public Channel getChannel() {
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the author
	 */
	public User getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(User author) {
		this.author = author;
	}

	/**
	 * @return the hits
	 */
	public Integer getHits() {
		return hits;
	}

	/**
	 * @param hits the hits to set
	 */
	public void setHits(Integer hits) {
		this.hits = hits;
	}

	/**
	 * @return the hot
	 */
	public Boolean getHot() {
		return hot;
	}

	/**
	 * @param hot the hot to set
	 */
	public void setHot(Boolean hot) {
		this.hot = hot;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the updated
	 */
	public Date getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	/**
	 * @return the keywords
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the orglink
	 */
	public String getOrglink() {
		return orglink;
	}

	/**
	 * @param orglink the orglink to set
	 */
	public void setOrglink(String orglink) {
		this.orglink = orglink;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param id
	 * @param title
	 * @param summary
	 * @param content
	 * @param picture
	 * @param channel
	 * @param category
	 * @param author
	 * @param hits
	 * @param hot
	 * @param status
	 * @param deleted
	 * @param created
	 * @param updated
	 * @param keywords
	 * @param orglink
	 */
	public Article(Integer id, String title, String summary, String content, String picture, Channel channel,
			Category category, User author, Integer hits, Boolean hot, Integer status, Boolean deleted, Date created,
			Date updated, String keywords, String orglink) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.picture = picture;
		this.channel = channel;
		this.category = category;
		this.author = author;
		this.hits = hits;
		this.hot = hot;
		this.status = status;
		this.deleted = deleted;
		this.created = created;
		this.updated = updated;
		this.keywords = keywords;
		this.orglink = orglink;
	}

	/**
	 * 
	 */
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//---------------------------------------------------------------------

	
	
}
