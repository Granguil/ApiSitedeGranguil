package granguil.data.response;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BlockListResponse {
public List<BlockResponse> blocks;



public List<BlockResponse> getBlocks() {
	return blocks;
}



public void setBlocks(List<BlockResponse> blocks) {
	this.blocks = blocks;
}



public BlockListResponse() {
	this.blocks=new ArrayList<BlockResponse>();
}
}
