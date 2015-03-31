

import java.util.HashMap;


public class TabIdent {
	private HashMap<String,Ident> globaux;
	private HashMap<String,Ident> locaux;
	
	public TabIdent(){
		globaux = new HashMap<String,Ident>();
		locaux = new HashMap<String,Ident>();
	}
	
	public Ident chercheIdentLoc(String clef){
		return locaux.get(clef);
	}
	
	public Ident chercheIdentGlob(String clef){
		return globaux.get(clef);
	}
	
	public boolean existeIdentGlob(String clef){
		return globaux.containsKey(clef);
	}
	
	public boolean existeIdentLoc(String clef){
		return locaux.containsKey(clef);
	}
	
	public void rangeIdentGlob(String cle, Ident id){
		globaux.put(cle, id);
	}
	
	public void rangeIdentLoc(String cle, Ident id){
		locaux.put(cle, id);
	}
	
	public void clear(){
		locaux.clear();
	}
}
