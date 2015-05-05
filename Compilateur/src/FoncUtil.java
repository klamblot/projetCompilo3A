import java.util.Stack;


/**
 * Classe utilisée lors des appels de fonctions. La pile nous renseigne sur la fonction appelée dont on lit les paramètres entrés. Cela permet de gérer le cas d'appels de fonctions
 * dans les paramètres d'une fonction appelée. 
 */
public class FoncUtil {
	public Stack<String> functionStack;

/*-------- Constructeur --------------*/ 	
	public FoncUtil(){
		functionStack = new Stack<String>();
	}
	
	/**
	 * @param nom de fonction à insérer dans la pile
	 */
	public void push(String func){
		functionStack.push(func);
	}
	
	/**
	 * @return Sommet de pile sans l'enlever
	 */
	public String peek(){
		return functionStack.peek();
	}
	
	/**
	 * @return Sommet de la pile en l'enlevant de la pile
	 */
	public String pop(){
		return functionStack.pop();
	}
	
	/**
	 * @return true si la pile est vide
	 */
	public boolean isEmpty(){
		return functionStack.empty();
	}
}
