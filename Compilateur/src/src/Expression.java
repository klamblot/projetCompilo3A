import java.io.InputStream;
import java.util.Stack;


public class Expression{

	public enum tip {
		ENTIER,
		BOOL,
		ERREUR;	
	};

	public enum op {
		PLUS,
		MOINS,
		DIV,
		MUL,
		DIFF,
		EGAL,
		INF,
		INFEGAL,
		SUP,
		SUPEGAL,
		OU,
		ET,
		NON;	  
	};

	Stack<tip> type = new Stack();
	Stack<op> oper = new Stack();

	public void saveType(tip t){
		type.push(t);
	}

	public void saveOp(op p){
		oper.push(p);
	}

	public void testType2Argv(){
		
		if(!type.isEmpty() && !oper.isEmpty()){

			tip tp = type.pop();
			op o = oper.pop();
			
			if(type.pop()!=tp)
			{
				type.push(tip.ERREUR);
			}
			else
			{
				switch(o){

				case EGAL:
				case INF:
				case SUP:
				case SUPEGAL:
				case INFEGAL:
				case DIFF:
					type.push(tip.BOOL);
				default:
					type.push(tip.ENTIER);
				}
			}
		}
			
	}

	public void testType1Argv(){
		
		if(!type.isEmpty() && !oper.isEmpty()){

			if(type.peek() == tip.ENTIER && oper.peek()==op.MOINS)
			{
				type.pop();
				oper.pop();
				type.push(tip.ENTIER);
			}
			else if(type.peek() == tip.BOOL && oper.peek()==op.NON)
			{	
				type.pop();
				oper.pop();
				type.push(tip.BOOL);
			}
			else{

				type.push(tip.ERREUR);
			}
		}
	}

}
