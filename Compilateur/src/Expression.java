import java.util.Stack;


public class Expression{
	
	private Stack<Tip> type; 	//Pile des types des opérandes pour le controle de type
	private Stack<Op> oper; 	//Pile des opérateurs

	/**
	 * Enum qui gere les differents types
	 */
	public enum Tip {
		ENTIER,
		BOOL,
		ERREUR;	
	};

	/**
	 * Enum qui gere les differents operateurs
	 */
	public enum Op {
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

	//Constructeur
	public Expression(){
		type = new Stack<Tip>();
		oper = new Stack<Op>();
	}

	/*
	 * Méthode qui ajoute un type à la pile des types
	 */
	public void saveType(Tip t){
		System.out.println("push : "+tipToString(t));
		type.push(t);
	}

	/*
	 * Méthode qui ajoute un type à la pile des types
	 */
	public void saveOp(Op p){
		oper.push(p);
	}
	
	/*
	 * Méthode de controle de type pour les opérations avec 2 opérandes
	 * Récupère les 2 éléments en sommet de la pile type et l'élément
	 * en sommet de la pile des opérateurs. 
	 * Teste ensuite si les deux types sont corrects par rapport à l'opérateur 
	 */
	public void testType2Argv(){
		
		
		if(!type.isEmpty() && !oper.isEmpty()){
			Tip type1=popType();
			Tip type2=popType();
			Op o= popOpera();  
			
			switch(o){
				case PLUS :
				case MOINS :
				case DIV :
				case MUL :
					if(type1==Tip.ENTIER && type2==Tip.ENTIER){
						saveType(Tip.ENTIER);
					}else saveType(Tip.ERREUR);
					break;
				
				case INF:
				case SUP:
				case SUPEGAL:
				case INFEGAL:
					if(type1==Tip.ENTIER && type2==Tip.ENTIER){
						saveType(Tip.BOOL);
					}else saveType(Tip.ERREUR);
					break;
					
				case EGAL:
				case DIFF :
					if(type1==Tip.ERREUR || type2==Tip.ERREUR || type1!=type2){
						saveType(Tip.ERREUR);
					}else saveType(Tip.BOOL);
					break;
					
				case ET :
				case OU :
					if(type1==Tip.BOOL && type2==Tip.BOOL){
						saveType(Tip.BOOL);
					}else saveType(Tip.ERREUR);
					break;
				
				default :
					saveType(Tip.ERREUR);
			
			}
			
		}
			
	}

	/*
	 * Méthode de controle de type pour les opérations avec 1 opérande
	 * Récupère l'élément en sommet de la pile type et l'élément
	 * en sommet de la pile des opérateurs. 
	 * Teste ensuite si le type est correct par rapport à l'opérateur 
	 */
	public void testType1Argv(){

		if(!type.isEmpty() && !oper.isEmpty()){

			if(peekType() == Tip.ENTIER && peekOpera()==Op.MOINS)
			{
				oper.pop();
			}
			else if(peekType() == Tip.BOOL && peekOpera()==Op.NON)
			{	
				oper.pop();
			}
			else
			{
				saveType(Tip.ERREUR);
			}
		}
	}

	/*
	 * Méthode qui renvoie le sommet de la pile type sans l'enlever
	 */
	public Tip peekType(){
		return type.peek();
	}
	
	/*
	 * Méthode qui renvoie le sommet de la pile opera sans l'enlever
	 */
	public Op peekOpera(){
		return oper.peek();
	}
	
	/*
	 * Méthode qui renvoie le sommet de la pile type
	 */
	public Tip popType(){
		System.out.println("pop : "+tipToString(type.peek()));
		return type.pop();
	}
	
	/*
	 * Méthode qui renvoie le sommet de la pile opera
	 */
	public Op popOpera(){
		return oper.pop();
	}
	
	/*
	 * Méthode qui prend un Tip et renvoie son équivalent en String
	 */
	public String tipToString(Tip type){
		switch (type){
		case ENTIER : return "ENTIER" ;
		case BOOL 	: return "BOOLEEN";
		case ERREUR : return "ERREUR" ;
		default : return "NULL";
		}
	}
	
	/*
	 * Méthode qui prend un type en String et renvoie son équivalent en Tip
	 */
	public Tip stringToTip(String type){
		switch (type){
		case "ENTIER" : return Tip.ENTIER ;
		case "BOOLEEN" 	: return Tip.BOOL;
		default : return Tip.ERREUR;
		}
	}

}
