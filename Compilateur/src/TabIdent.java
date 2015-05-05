import java.util.HashMap;
import java.util.Map.Entry;


/**
 * Classe qui gère les Ident qui sont déclarés
 */
/**
 * @author Alexandre
 *
 */
public class TabIdent {
	private static HashMap<String,Ident> globaux; //HashMap des Ident globaux cad les IdFonc
	private static HashMap<String,Ident> locaux; //HashMap des Ident locaux cad les IdConst et IdVar déclarés dans les fonctions

/*-----------Constructeur--------------*/
	public TabIdent(){
		globaux = new HashMap<String,Ident>();
		locaux = new HashMap<String,Ident>();
	}

/*
 * Méthodes pour récupérer un Ident dans les HashMap à partir du nom de l'Ident 	
 */
	public Ident chercheIdentLoc(String clef){
		return locaux.get(clef);
	}
	
	public Ident chercheIdentGlob(String clef){
		return globaux.get(clef);
	}
	
/*
 * Méthodes pour savoir si un Ident existe dans les HashMap à partir du nom de l'Ident 
 */
	public static boolean existeIdentGlob(String clef){
		return globaux.containsKey(clef);
	}
	
	public static boolean existeIdentLoc(String clef){
		return locaux.containsKey(clef);
	}
/*
 * 	Méthodes pour ajouter un Ident et son nom dans les HashMap
 */
	public static void rangeIdentGlob(String cle, Ident id){
		globaux.put(cle, id);
	}
	
	public static void rangeIdentLoc(String cle, Ident id){
		locaux.put(cle, id);
	}
	
	
	/**
	 * Vide la HashMap des Ident locaux
	 */
	public static void clear(){
		locaux.clear();
	}
	
	
	/**
	 * Met à jour les offset des Ident locaux à partir du nombre total d'Ident locaux déclarés
	 * @param nombre total d'Ident locaux déclarés
	 */
	public static void update(int nb){
		for(Entry<String, Ident> entry : locaux.entrySet()) {
			int offsetCour = ((IdVar)entry.getValue()).getOffset();
			((IdVar)entry.getValue()).setOffset( 2*nb + 4 - (2*offsetCour));
		}
	}
}
