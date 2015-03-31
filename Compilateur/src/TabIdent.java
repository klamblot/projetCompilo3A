

import java.util.HashMap;


public class TabIdent {
	private static HashMap<String,Ident> globaux;
	private static HashMap<String,Ident> locaux;
	
	public TabIdent(){
		globaux = new HashMap<String,Ident>();
		locaux = new HashMap<String,Ident>();
	}
	
	public static Ident chercheIdentLoc(String clef){
		return locaux.get(clef);
	}
	
	public static Ident chercheIdentGlob(String clef){
		return globaux.get(clef);
	}
	
	public static boolean existeIdentGlob(String clef){
		return globaux.containsKey(clef);
	}
	
	public static boolean existeIdentLoc(String clef){
		return locaux.containsKey(clef);
	}
	
	public static void rangeIdentGlob(String cle, Ident id){
		globaux.put(cle, id);
	}
	
	public static void rangeIdentLoc(String cle, Ident id){
		locaux.put(cle, id);
	}
	
	public static void clear(){
		locaux.clear();
	}
}
