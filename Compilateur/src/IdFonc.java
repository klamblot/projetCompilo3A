import java.util.ArrayList;

/**
 * Classe pour les fonctions cad un Ident avec une liste des type des paramètres d'entrée
 */
/**
 * @author Alexandre
 *
 */
public class IdFonc extends Ident {

	private ArrayList<String> param; //liste des types des paramètres d'entrée
	
	//Constructeur
	public IdFonc(String type) {
			super(type); /* Type du retour de l'IdFonc */
			param = new ArrayList<String>();
	}

	/**
	 * @param type à ajouter
	 */
	public void addParam(String type){
		param.add(type);
	}
	
	//Getter
	@Override
	public String getType() {
			return super.getType();
	}
	
	
	/**
	 * @param i
	 * @return le ième type de paramètre
	 */
	public String getParam(int i){
		return param.get(i);
	}

	/**
	 * @return le nmbre de paramètre
	 */
	public int getNbParam(){
		return param.size();
	}
	
	/**
	 * @param nom
	 * @return le nom de la fonction avec ses types des paramètres
	 */
	public String affiche(String nom){
		String s=nom;
		if(getNbParam()!=0){
		s=s+"("+getParam(0);
		for(int i = 1; i<getNbParam();i++){
			s+=","+getParam(i);
		}
		s+=")";
		}else s+="()";
		return s;
		
	}
	

}
