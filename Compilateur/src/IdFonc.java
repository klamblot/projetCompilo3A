import java.util.ArrayList;


public class IdFonc extends Ident {

	private ArrayList<String> param;
	
	//Constructeur
	public IdFonc(String type) {
			super(type);
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
	

}
