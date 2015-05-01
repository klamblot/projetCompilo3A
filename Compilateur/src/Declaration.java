

public class Declaration {

	private int offSet = 0; 	//Offset courant : Position de l'élément en sommet de pile
	private String saveName;	//Variable pour sauvegarder un nom pour créer un Ident ensuite
	

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
	 * Créer un nouvel IdVar à partir du type et met son offset en sommet de pile
	 * Décale l'offset
	 */
	public Ident createIdentVar(String type){
		offSet-=2;
		return new IdVar(type,offSet);
	}
	
	/**
	 * @param type
	 * @param offset
	 * @return IdVar
	 * Créer un nouvel IdVar à partir du type et son offset
	 */
	public Ident createIdentVar(String type, int offset){
		return new IdVar(type,offSet);
	}
	
	
	/**
	 * @param type
	 * @param valeur
	 * @return IdConst
	 * Créer un IdConst à partir de son type et de sa valeur
	 */
	public Ident createIdentConst(String type, int valeur){
		return new IdConst(type, valeur);
	}
	
	/**
	 * @param type
	 * @return IdFonctt
	 * Créer un IdFonct à partir du type de son retour
	 */
	public Ident createIdentFonc(String type){
		return new IdFonc(type);
	}
	
	
}
