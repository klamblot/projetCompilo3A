import java.util.Stack;


public class FoncUtil {
	public Stack<String> functionStack;
	
	public FoncUtil(){
		functionStack = new Stack<String>();
	}
	
	public void push(String func){
		functionStack.push(func);
	}
	
	public String peek(){
		return functionStack.peek();
	}
	
	public String pop(){
		return functionStack.pop();
	}
	
	public boolean isEmpty(){
		return functionStack.empty();
	}
}
