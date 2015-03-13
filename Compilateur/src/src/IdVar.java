package src;


public class IdVar extends Ident {
	
	int offset;
	
	public IdVar(String type, int offset) {
		super(type);
		this.offset=offset;
	}

	@Override
	public String getType() {
		return super.getType();
	}
	
	public int getOffset(){
		return offset;
	}

}
