import java.util.Stack;


public class Expression{
	
	private Stack<Tip> type; 	//Pile des types des op�randes pour le controle de type
	private Stack<Op> oper; 	//Pile des op�rateurs

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
	 * M�thode qui ajoute un type � la pile des types
	 */
	public void saveType(Tip t){
		System.out.println("push : "+tipToString(t));
		type.push(t);
	}

	/*
	 * M�thode qui ajoute un type � la pile des types
	 */
	public void saveOp(Op p){
		oper.push(p);
	}
	
	/*
	 * M�thode de controle de type pour les op�rations avec 2 op�randes
	 * R�cup�re les 2 �l�ments en sommet de la pile type et l'�l�ment
	 * en sommet de la pile des op�rateurs. 
	 * Teste ensuite si les deux types sont corrects par rapport � l'op�rateur 
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
	 * M�thode de controle de type pour les op�rations avec 1 op�rande
	 * R�cup�re l'�l�ment en sommet de la pile type et l'�l�ment
	 * en sommet de la pile des op�rateurs. 
	 * Teste ensuite si le type est correct par rapport � l'op�rateur 
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
	 * M�thode qui renvoie le sommet de la pile type sans l'enlever
	 */
	public Tip peekType(){
		return type.peek();
	}
	
	/*
	 * M�thode qui renvoie le sommet de la pile opera sans l'enlever
	 */
	public Op peekOpera(){
		return oper.peek();
	}
	
	/*
	 * M�thode qui renvoie le sommet de la pile type
	 */
	public Tip popType(){
		System.out.println("pop : "+tipToString(type.peek()));
		return type.pop();
	}
	
	/*
	 * M�thode qui renvoie le sommet de la pile opera
	 */
	public Op popOpera(){
		return oper.pop();
	}
	
	/*
	 * M�thode qui prend un Tip et renvoie son �quivalent en String
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
	 * M�thode qui prend un type en String et renvoie son �quivalent en Tip
	 */
	public Tip stringToTip(String type){
		switch (type){
		case "ENTIER" : return Tip.ENTIER ;
		case "BOOLEEN" 	: return Tip.BOOL;
		default : return Tip.ERREUR;
		}
	}

}
