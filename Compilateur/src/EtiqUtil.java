import java.util.Stack;


/**
 * Classe utilis�e pour les it�rations et les conditionnelles. Elle permet de g�rer le cas de conditionnelles et des it�rations imbriqu�es.
 * On assigne � chaque boucle ou it�ration, ce num�ro est mis � leurs �tiquettes afin de les diff�rencier dans le code YVM et assembleur.  
 */
public class EtiqUtil {
	private Stack<Integer> stack; //pile qui contient les num�ros des boucles pas encore ferm�e et dans l'ordre dans lequel elles ont �t� ouvertes
	private int compteur; 
	
/*-------- Constructeur --------------*/ 
	public EtiqUtil () {
		stack = new Stack<Integer>();
		compteur = 0;
	}
	
	/**
	 * Incr�mente le compteur
	 */
	private void incCompteur() {
		compteur++;
	}
	
	/**
	 * D�pile stack et retourne la valeur
	 * @return Valeur en sommet de pile
	 */
	public int pop(){
		return stack.pop();
	}
	
	/**
	 * Ajoute un num�ro dans la pile
	 */
	public void push(){
		incCompteur();
		stack.push(compteur);
	}
	
	
	/**
	 * @return Valeur en sommet de pile sans la retirer
	 */
	public int peek(){
		return stack.peek();
	}
}
