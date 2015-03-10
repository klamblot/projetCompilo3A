package src;

public class IdConst extends Ident{
	
	int valeur;

	public IdConst(String type, int val ) {
		super(type);
		valeur=val;
	}
	
	public String getType() {
		return super.getType();
	}
	
	public int getValeur(){
		return valeur;
	}

}
