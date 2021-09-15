package granguil.data.request;

public class BlockRequest {

	public String id;
	
	public String content;
	
	public int order;

	public BlockRequest() {
		super();
	}

	public BlockRequest(String id,String content, int order) {
		super();
		this.id=id;
		this.content = content;
		this.order = order;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
		
}
