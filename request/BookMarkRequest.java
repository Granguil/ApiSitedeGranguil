package granguil.data.request;

import java.util.UUID;

public class BookMarkRequest {
public UUID id;
public UUID universe;
public UUID book;
public UUID chapter;
public UUID scene;
public String user;
public String title;


public UUID getId() {
	return id;
}
public void setId(UUID id) {
	this.id = id;
}
public UUID getUniverse() {
	return universe;
}
public void setUniverse(UUID universe) {
	this.universe = universe;
}
public UUID getBook() {
	return book;
}
public void setBook(UUID book) {
	this.book = book;
}
public UUID getChapter() {
	return chapter;
}
public void setChapter(UUID chapter) {
	this.chapter = chapter;
}
public UUID getScene() {
	return scene;
}
public void setScene(UUID scene) {
	this.scene = scene;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}


}
