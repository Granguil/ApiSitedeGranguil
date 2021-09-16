package granguil.data.request;

import granguil.data.Enum.BlockState;

public class BlockRequest {

	public String id;
	
	public String content;
	
	public int order;
	
	public BlockState status;

	public BlockRequest() {
		super();
	}

	public BlockRequest(String id,String content, int order,BlockState status) {
		super();
		this.id=id;
		this.content = content;
		this.order = order;
		this.status=status;
	}

	
	
	public BlockState getStatus() {
		return status;
	}

	public void setStatus(BlockState status) {
		this.status = status;
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
