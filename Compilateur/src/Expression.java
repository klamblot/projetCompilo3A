


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
			
			case 2 :
				if(type1.equals("entier") && type2.equals("entier")){
					resul = "booleen";
				}else resul = "erreur";
				break;
				
			case 3 :
				if(type1.equals("erreur") || type2.equals("erreur")){
					resul = "erreur";
				}else resul = "booleen";
				break;
				
			case 4 :
				if(type1.equals("booleen") && type2.equals("booleen")){
					resul = "booleen";
				}else resul = "erreur";
				break;
			
			default :
				resul = "erreur";
		
		}
		
		return resul;
	}
	


}
