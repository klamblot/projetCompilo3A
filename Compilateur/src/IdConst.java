

/*
 * Classe pour les constantes cad un Ident avec sa valeur
 */
public class IdConst extends Ident{
	
	int valeur;

	//Constructeur
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
