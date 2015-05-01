

public class Declaration {

	private int offSet = 0; 	//Offset courant : Position de l'�l�ment en sommet de pile
	private String saveName;	//Variable pour sauvegarder un nom pour cr�er un Ident ensuite
	

	public int getOffSet() {
		return offSet;
	}

	public void setOffSet(int offSet) {
		this.offSet = offSet;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	
	
	/**
	 * @param type
	 * @return IdVar
	 * Cr�er un nouvel IdVar � partir du type et met son offset en sommet de pile
	 * D�cale l'offset
	 */
	public Ident createIdentVar(String type){
		offSet-=2;
		return new IdVar(type,offSet);
	}
	
	/**
	 * @param type
	 * @param offset
	 * @return IdVar
	 * Cr�er un nouvel IdVar � partir du type et son offset
	 */
	public Ident createIdentVar(String type, int offset){
		return new IdVar(type,offSet);
	}
	
	
	/**
	 * @param type
	 * @param valeur
	 * @return IdConst
	 * Cr�er un IdConst � partir de son type et de sa valeur
	 */
	public Ident createIdentConst(String type, int valeur){
		return new IdConst(type, valeur);
	}
	
	/**
	 * @param type
	 * @return IdFonctt
	 * Cr�er un IdFonct � partir du type de son retour
	 */
	public Ident createIdentFonc(String type){
		return new IdFonc(type);
	}
	
	
}
