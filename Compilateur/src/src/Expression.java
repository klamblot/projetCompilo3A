

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

	Stack<tip> type = new Stack<tip>();
	Stack<op> oper = new Stack<op>();

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
					break;
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

	
	public void pushType(tip type1){
		type.push(type1);
	}
	
	public tip popType(){
		return type.pop();
	}
	
	public void pushOpera(op opera1){
		oper.push(opera1);
	}
	
	public op popOpera(){
		return oper.pop();
	}



}
