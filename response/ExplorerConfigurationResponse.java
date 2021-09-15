package granguil.data.response;

import java.util.UUID;

public class ExplorerConfigurationResponse {
	public UUID code;
	
	public String name;
	
	public boolean displayAll;
	
	public boolean loadAll;
	
	public int cardNumber;
	
	public boolean withInfo;
	
	public boolean infoPopup;

	
	
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
