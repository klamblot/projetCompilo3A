

/*
 * Classe pour les variables cad un Ident avec un offset correspondant à son emplacement dans la pile
 */
public class IdVar extends Ident {
	
	int offset;
	
	//Constructeur
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
	
	public void setOffset(int i){
		offset=i;;
	}

}
