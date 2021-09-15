package granguil.data.request;

public class ExplorerConfigurationRequest {
public String name;
public boolean displayAll;
public boolean loadAll;
public boolean withInfo;
public boolean infoPopup;
public ExplorerConfigurationRequest() {
	super();
}
public ExplorerConfigurationRequest(String name, boolean displayAll, boolean loadAll, boolean withInfo, boolean infoPopup) {
	super();
	this.name = name;
	this.displayAll = displayAll;
	this.loadAll = loadAll;
	this.withInfo=withInfo;
	this.infoPopup=infoPopup;
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


}
