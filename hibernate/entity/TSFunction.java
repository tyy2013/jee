package entity;

// Generated 2013-4-3 16:34:56 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TSFunction generated by hbm2java
 */
@Entity
@Table(name = "t_s_function", catalog = "jeecgv3")
public class TSFunction implements java.io.Serializable {

	private String id;
	private String iconid;
	private String parentfunctionid;
	private String functionname;
	private Short functionlevel;
	private String functionurl;
	private String iconpath;
	private String functionorder;
	private Short functioniframe;

	public TSFunction() {
	}

	public TSFunction(String id, String functionname) {
		this.id = id;
		this.functionname = functionname;
	}

	public TSFunction(String id, String iconid, String parentfunctionid,
			String functionname, Short functionlevel, String functionurl,
			String iconpath, String functionorder, Short functioniframe) {
		this.id = id;
		this.iconid = iconid;
		this.parentfunctionid = parentfunctionid;
		this.functionname = functionname;
		this.functionlevel = functionlevel;
		this.functionurl = functionurl;
		this.iconpath = iconpath;
		this.functionorder = functionorder;
		this.functioniframe = functioniframe;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "iconid", length = 32)
	public String getIconid() {
		return this.iconid;
	}

	public void setIconid(String iconid) {
		this.iconid = iconid;
	}

	@Column(name = "parentfunctionid", length = 32)
	public String getParentfunctionid() {
		return this.parentfunctionid;
	}

	public void setParentfunctionid(String parentfunctionid) {
		this.parentfunctionid = parentfunctionid;
	}

	@Column(name = "functionname", nullable = false, length = 50)
	public String getFunctionname() {
		return this.functionname;
	}

	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}

	@Column(name = "functionlevel")
	public Short getFunctionlevel() {
		return this.functionlevel;
	}

	public void setFunctionlevel(Short functionlevel) {
		this.functionlevel = functionlevel;
	}

	@Column(name = "functionurl", length = 100)
	public String getFunctionurl() {
		return this.functionurl;
	}

	public void setFunctionurl(String functionurl) {
		this.functionurl = functionurl;
	}

	@Column(name = "iconpath", length = 65535)
	public String getIconpath() {
		return this.iconpath;
	}

	public void setIconpath(String iconpath) {
		this.iconpath = iconpath;
	}

	@Column(name = "functionorder", length = 10)
	public String getFunctionorder() {
		return this.functionorder;
	}

	public void setFunctionorder(String functionorder) {
		this.functionorder = functionorder;
	}

	@Column(name = "functioniframe")
	public Short getFunctioniframe() {
		return this.functioniframe;
	}

	public void setFunctioniframe(Short functioniframe) {
		this.functioniframe = functioniframe;
	}

}