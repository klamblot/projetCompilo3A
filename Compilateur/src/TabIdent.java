

import java.util.HashMap;
import java.util.Map.Entry;


public class TabIdent {
	private static HashMap<String,Ident> globaux;
	private static HashMap<String,Ident> locaux;
	
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
	
	public static void update(int nb){
		for(Entry<String, Ident> entry : locaux.entrySet()) {
			int offsetCour = ((IdVar)entry.getValue()).getOffset();
			((IdVar)entry.getValue()).setOffset( nb + 4 - (2*offsetCour));
		}
	}
}
