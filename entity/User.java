package granguil.data.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="user_list")
public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	@Column(name="user_code")
	private UUID userCode;
	
	@Column(name="key_user")
	private int key=0;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="connexion_date")
	private Date connexionDate = new Date(System.currentTimeMillis());

	private String mail="nc";

	@Column(name="mail_valid")
	private int mailValid=0;

	private String md;

	private int newsletter=0;

	@Column(unique = true)
	private String pseudo;
	
	@Column(name="is_tester")
	private Boolean isTester=false;

	private String token1;
	
	@OneToOne
	@JoinColumn(name="role")
	private Role role;
	
	private String language="Fra";
	
	@Column(name="url_home")
	private String urlHome;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	@JsonBackReference
	private List<BookMark> bookmarks;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	@JsonBackReference
	private List<ReadUser> readUser;
	
	public User() {
		super();
	}

	
	
	public String getUrlHome() {
		return urlHome;
	}



	public void setUrlHome(String urlHome) {
		this.urlHome = urlHome;
	}



	public UUID getCode() {
		return userCode;
	}

	public void setCode(UUID code) {
		this.userCode = code;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Date getConnexionDate() {
		return connexionDate;
	}

	public void setConnexionDate(Date connexionDate) {
		this.connexionDate = connexionDate;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getMailValid() {
		return mailValid;
	}

	public void setMailValid(int mailValid) {
		this.mailValid = mailValid;
	}

	public String getMd() {
		return md;
	}

	public void setMd(String md) {
		this.md = md;
	}

	public int getNewsletter() {
		return newsletter;
	}

	public void setNewsletter(int newsletter) {
		this.newsletter = newsletter;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Boolean getIsTester() {
		return isTester;
	}

	public void setIsTester(Boolean isTester) {
		this.isTester = isTester;
	}

	public String getToken1() {
		return token1;
	}

	public void setToken1(String token1) {
		this.token1 = token1;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UUID getUserCode() {
		return userCode;
	}

	public void setUserCode(UUID userCode) {
		this.userCode = userCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<BookMark> getBookmarks() {
		return bookmarks;
	}

	public void setBookmarks(List<BookMark> bookmarks) {
		this.bookmarks = bookmarks;
	}

	public List<ReadUser> getReadUser() {
		return readUser;
	}

	public void setReadUser(List<ReadUser> readUser) {
		this.readUser = readUser;
	}
   
	
}
