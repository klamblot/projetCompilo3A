<<<<<<< HEAD:Compilateur/src/Expression.java



public class Expression {

/**
    Vérifie le type des opérandes d'une expression
    @param type1 Type du premier opérande 
    @param type2 Type du deuxième opérande
    @param op Opérateur (1:{+,-,*,/}  2:{<,>,<=,>=}  3:{=,!=} 4:{&&,||}  
    @return Type du résultat de l'opération (rend "erreur" si type incorrect)
*/
	public String controleType(String type1, String type2, int op){
		String resul = "";
		switch(op){
			case 1 :
				if(type1.equals("entier") && type2.equals("entier")){
					resul = "entier";
				}else resul = "erreur";
				break;
=======
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
>>>>>>> 33ff767f7ede199cc3405924ed1b31cd6f77a7b0:Compilateur/src/src/Expression.java
			
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
