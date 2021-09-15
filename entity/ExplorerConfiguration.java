package granguil.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

/**
 * Entity implementation class for Entity: ExplorerConfiguration
 *
 */
@Entity
@Table(name="explorer_configuration")
public class ExplorerConfiguration implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID code;
	
	@Column(unique=true)
	private String name;
	
	private boolean displayAll;
	
	private boolean loadAll;
	
	private int cardNumber;
	
	private boolean withInfo;
	
	private boolean infoPopup;

	public ExplorerConfiguration(String name,boolean displayAll, boolean loadAll, int cardNumber,boolean withInfo, boolean infoPopup) {
		super();
		this.cardNumber=cardNumber;
		this.displayAll=displayAll;
		this.loadAll=loadAll;
		this.name=name;
		this.withInfo=withInfo;
		this.infoPopup=infoPopup;
	}
	
	public ExplorerConfiguration() {
		super();
	}

	
	
	public boolean isWithInfo() {
		return withInfo;
	}

	public void setWithInfo(boolean withInfo) {
		this.withInfo = withInfo;
	}

	public boolean isInfoPopup() {
		return infoPopup;
	}

	public void setInfoPopup(boolean infoPopup) {
		this.infoPopup = infoPopup;
	}

	public UUID getCode() {
		return code;
	}

	public void setCode(UUID code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDisplayAll() {
		return displayAll;
	}

	public void setDisplayAll(boolean displayAll) {
		this.displayAll = displayAll;
	}

	public boolean isLoadAll() {
		return loadAll;
	}

	public void setLoadAll(boolean loadAll) {
		this.loadAll = loadAll;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
   
}
