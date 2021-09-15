package granguil.data.request;

import java.util.UUID;

import granguil.data.Enum.ReadType;

public class ReadTypeRequest {

	public ReadType readType;
	
	public UUID parent;
	
	public boolean isInserted;
	
	public boolean isUpdated;
	
	public boolean isAdded;
	
	public String title;
	
	public String info;
	
	public int numero;

	public ReadType getReadType() {
		return readType;
	}

	public void setReadType(ReadType readType) {
		this.readType = readType;
	}

	public UUID getParent() {
		return parent;
	}

	public void setParent(UUID parent) {
		this.parent = parent;
	}

	public boolean isInserted() {
		return isInserted;
	}

	public void setInserted(boolean isInserted) {
		this.isInserted = isInserted;
	}

	public boolean isUpdated() {
		return isUpdated;
	}

	public void setUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
	}

	public boolean isAdded() {
		return isAdded;
	}

	public void setAdded(boolean isAdded) {
		this.isAdded = isAdded;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ReadTypeRequest() {
		super();
	}

	public ReadTypeRequest(ReadType readType, UUID parent, boolean isInserted, boolean isUpdated, boolean isAdded,
			String title, String info, int numero) {
		super();
		this.readType = readType;
		this.parent = parent;
		this.isInserted = isInserted;
		this.isUpdated = isUpdated;
		this.isAdded = isAdded;
		this.title = title;
		this.info = info;
		this.numero = numero;
	}
	
	
}
