

import java.util.HashMap;


public class TabIdent {
	private HashMap<String,Ident> globaux;
	private HashMap<String,Ident> locaux;
	
	public TabIdent(){
		globaux = new HashMap<String,Ident>();
		locaux = new HashMap<String,Ident>();
	}
	
	public static Ident chercheIdent(String clef){
		return table.get(clef);
	}
	
	public boolean existeIdent(String clef){
		return table.containsKey(clef);
	}
	
	public void rangeIdent(String cle, Ident id){
		table.put(cle, id);
	}
	
	public void clear(){
		locaux.clear();
	}
}
