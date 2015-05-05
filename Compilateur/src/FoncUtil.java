import java.util.Stack;


/**
 * Classe utilis�e lors des appels de fonctions. La pile nous renseigne sur la fonction appel�e dont on lit les param�tres entr�s. Cela permet de g�rer le cas d'appels de fonctions
 * dans les param�tres d'une fonction appel�e. 
 */
public class FoncUtil {
	public Stack<String> functionStack;

/*-------- Constructeur --------------*/ 	
	public FoncUtil(){
		functionStack = new Stack<String>();
	}
	
	/**
	 * @param nom de fonction � ins�rer dans la pile
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
