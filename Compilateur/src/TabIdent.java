

import java.util.HashMap;


public class TabIdent {
	static HashMap<String,Ident> table;
	
	public TabIdent(){
		table = new HashMap<String,Ident>();
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
}
