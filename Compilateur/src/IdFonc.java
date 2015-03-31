
public class IdFonc extends Ident {

	int offset;
	
	//Constructeur
	public IdFonc(String type, int offset) {
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
