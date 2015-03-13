package src;


public class Declaration {
	
	private int offSet = 0;
	private String saveName;
	
	public Ident createIdentVar(String type, int offset){
		offSet-=2;
		return new IdVar(type,offSet);
	}
	
	public Ident createIdentConst(String type, int valeur){
		return new IdConst(type, valeur);
	}
	
}
