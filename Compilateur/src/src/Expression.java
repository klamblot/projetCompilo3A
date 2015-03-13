import java.util.Stack;



public class Expression {
	
	private Stack<String> type;
	private Stack<Integer> opera;

	public Expression(){
		type=new Stack<String>();
		opera=new Stack<Integer>();
	}
	
/**
    Verifie le type des operandes d'une expression
    @param type1 Type du premier operande 
    @param type2 Type du deuxième operande
    @param op Operateur (1:{+,-,*,/}  2:{<,>,<=,>=}  3:{=,!=} 4:{&&,||}  
    @return Type du resultat de l'operation (rend "ERREUR" si type incorrect)
*/
	public String controleType(){
		String type1=popType();
		String type2=popType();
		int op= (int) popOpera();  
				
		String resul = "";
		switch(op){
			case 1 :
				if(type1.equals("ENTIER") && type2.equals("ENTIER")){
					resul = "ENTIER";
				}else resul = "ERREUR";
				break;
			
			case 2 :
				if(type1.equals("ENTIER") && type2.equals("ENTIER")){
					resul = "BOOLEEN";
				}else resul = "ERREUR";
				break;
				
			case 3 :
				if(type1.equals("ERREUR") || type2.equals("ERREUR")){
					resul = "ERREUR";
				}else resul = "BOOLEEN";
				break;
				
			case 4 :
				if(type1.equals("BOOLEEN") && type2.equals("BOOLEEN")){
					resul = "BOOLEEN";
				}else resul = "ERREUR";
				break;
			
			default :
				resul = "ERREUR";
		
		}
		
		return resul;
	}
	
	public void pushType(String type1){
		type.push(type1);
	}
	
	public String popType(){
		return type.pop();
	}
	
	public void pushOpera(int opera1){
		opera.push(opera1);
	}
	
	public int popOpera(){
		return (int) opera.pop();
	}

}
