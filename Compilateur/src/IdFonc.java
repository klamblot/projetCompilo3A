import java.util.ArrayList;


public class IdFonc extends Ident {

	private ArrayList<String> param;
	
	//Constructeur
	public IdFonc(String type) {
			super(type); /* Type du retour de l'IdFonc */
			param = new ArrayList<String>();
	}

	public void addParam(String type){
		param.add(type);
	}
	
	
	@Override
	public String getType() {
			return super.getType();
	}
		
	public String getParam(int i){
		return param.get(i);
	}

	public int getNbParam(){
		return param.size();
	}
	
	public String affiche(String nom){
		String s=nom+"("+getParam(0);
		for(int i = 1; i<getNbParam();i++){
			s+=","+getParam(i);
		}
		s+=")";
		return s;
		
	}
	

}
