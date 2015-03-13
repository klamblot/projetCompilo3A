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

	Stack<tip> type = new Stack<tip>();
	Stack<op> oper = new Stack<op>();

	public void saveType(tip t){
		type.push(t);
	}

	public void saveOp(op p){
		oper.push(p);
	}

	public void testType2Argv(){
		
		tip type1=popType();
		tip type2=popType();
		op o= popOpera();  
		
		if(!type.isEmpty() && !oper.isEmpty()){
			
			switch(o){
				case PLUS :
				case MOINS :
				case DIV :
				case MUL :
					if(type1==tip.ENTIER && type2==tip.ENTIER){
						type.push(tip.ENTIER);
					}else type.push(tip.ERREUR);
					break;
				
				case INF:
				case SUP:
				case SUPEGAL:
				case INFEGAL:
					if(type1==tip.ENTIER && type2==tip.ENTIER){
						type.push(tip.BOOL);
					}else type.push(tip.ERREUR);
					break;
					
				case EGAL:
				case DIFF :
					if(type1==tip.ERREUR || type2==tip.ERREUR){
						type.push(tip.ERREUR);
					}else type.push(tip.BOOL);
					break;
					
				case ET :
				case OU :
					if(type1==tip.BOOL && type2==tip.BOOL){
						type.push(tip.BOOL);
					}else type.push(tip.ERREUR);
					break;
				
				default :
					type.push(tip.ERREUR);
			
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

	
	public tip popType(){
		return type.pop();
	}
	
	
	public op popOpera(){
		return oper.pop();
	}



}
