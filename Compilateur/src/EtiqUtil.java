import java.util.Stack;


public class EtiqUtil {
	private Stack<Integer> stack;
	private int compteur;
	
	public EtiqUtil () {
		stack = new Stack<Integer>();
		compteur = 0;
	}
	
	private void incCompteur() {
		compteur++;
	}
	
	public int pop(){
		return stack.pop();
	}
	
	public void push(){
		incCompteur();
		stack.push(compteur);
	}
	
	public int peek(){
		return stack.peek();
	}
}
