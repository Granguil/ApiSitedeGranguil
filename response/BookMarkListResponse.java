package granguil.data.response;

import java.util.ArrayList;
import java.util.List;

public class BookMarkListResponse {
public List<BookMarkResponse> bookmarks= new ArrayList<BookMarkResponse>();

public BookMarkListResponse() {
	
}

public BookMarkListResponse(List<BookMarkResponse> liste) {
	this.bookmarks=liste;
}
}
