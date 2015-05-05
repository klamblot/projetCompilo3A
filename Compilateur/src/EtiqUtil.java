import java.util.Stack;


/**
 * Classe utilisée pour les itérations et les conditionnelles. Elle permet de gérer le cas de conditionnelles et des itérations imbriquées.
 * On assigne à chaque boucle ou itération, ce numéro est mis à leurs étiquettes afin de les différencier dans le code YVM et assembleur.  
 */
public class EtiqUtil {
	private Stack<Integer> stack; //pile qui contient les numéros des boucles pas encore fermée et dans l'ordre dans lequel elles ont été ouvertes
	private int compteur; 
	
/*-------- Constructeur --------------*/ 
	public EtiqUtil () {
		stack = new Stack<Integer>();
		compteur = 0;
	}
	
	/**
	 * Incrémente le compteur
	 */
	private void incCompteur() {
		compteur++;
	}
	
	/**
	 * Dépile stack et retourne la valeur
	 * @return Valeur en sommet de pile
	 */
	public int pop(){
		return stack.pop();
	}
	
	/**
	 * Ajoute un numéro dans la pile
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
