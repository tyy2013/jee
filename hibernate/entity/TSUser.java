package entity;

// Generated 2013-4-3 10:50:57 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TSUser generated by hbm2java
 */
@Entity
@Table(name = "t_s_user", catalog = "jeecgv3")
public class TSUser implements java.io.Serializable {

	private String id;
	private String signaturefile;
	private String mobilephone;
	private String officephone;
	private String email;

	public TSUser() {
	}

	public TSUser(String id) {
		this.id = id;
	}

	public TSUser(String id, String signaturefile, String mobilephone,
			String officephone, String email) {
		this.id = id;
		this.signaturefile = signaturefile;
		this.mobilephone = mobilephone;
		this.officephone = officephone;
		this.email = email;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "signaturefile", length = 100)
	public String getSignaturefile() {
		return this.signaturefile;
	}

	public void setSignaturefile(String signaturefile) {
		this.signaturefile = signaturefile;
	}

	@Column(name = "mobilephone", length = 30)
	public String getMobilephone() {
		return this.mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	@Column(name = "officephone", length = 20)
	public String getOfficephone() {
		return this.officephone;
	}

	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
