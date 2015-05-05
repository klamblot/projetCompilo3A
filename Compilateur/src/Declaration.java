

/**
 * Classe qui g�re les variables utilis�es pour la d�claration des variables, des constantes et des fonctions
 */
public class Declaration {

	private int offSet = 0; 	//Offset courant : Position de l'�l�ment en sommet de pile
	private String saveName;	//Variable pour sauvegarder un nom pour cr�er un Ident ensuite
	
/*-------Getters/Setters-------------*/
	

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
	
/*-------------------------------------*/
	
	/**
	 * @param type
	 * @return IdVar
	 * Cr�e un nouvel IdVar � partir du type et met son offset en sommet de pile
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
	 * Cr�e un nouvel IdVar � partir du type et son offset
	 */
	public Ident createIdentVar(String type, int off){
		return new IdVar(type,off);
	}
	
	
	/**
	 * @param type
	 * @param valeur
	 * @return IdConst
	 * Cr�e un IdConst � partir de son type et de sa valeur
	 */
	public Ident createIdentConst(String type, int valeur){
		return new IdConst(type, valeur);
	}
	
	/**
	 * @param type
	 * @return IdFonctt
	 * Cr�e un IdFonct � partir du type de son retour
	 */
	public Ident createIdentFonc(String type){
		return new IdFonc(type);
	}
	
	
	/**
	 * Met � zero l'offset
	 */
	public void clearOffset(){
		offSet = 0;
	}
	
	
}
