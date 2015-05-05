import java.io.OutputStream;

/**
 * Classe avec toutes les méthodes pour écrire le fichier .yvm
 */
public class YVM {
	
	OutputStream file;
	
	public YVM(){
	}
	
	/* MÃ©thode arithmÃ©tique*/
	public void iadd(){
		Ecriture.ecrireStringln(file,"iadd");
	}
	
	public void isub(){
		Ecriture.ecrireStringln(file,"isub");
	}
	
	public void imul(){
		Ecriture.ecrireStringln(file,"imul");
	}
	
	public void idiv(){
		Ecriture.ecrireStringln(file,"idiv");
	}
	
	public void inot(){
		Ecriture.ecrireStringln(file,"inot");
	}
	
	public void ineg(){
		Ecriture.ecrireStringln(file,"ineg");
	}
	
	public void ior(){
		Ecriture.ecrireStringln(file,"ior");
	}
	
	public void iand(){
		Ecriture.ecrireStringln(file,"iand");
	}
	/*----------------------*/
	
	/*MÃ©thode comparaison*/
	public void iinf(){
		Ecriture.ecrireStringln(file,"iinf");
	}
	
	public void isup(){
		Ecriture.ecrireStringln(file,"isup");
	}
	
	public void iinfegal(){
		Ecriture.ecrireStringln(file,"iinfegal");
	}
	
	public void isupegal(){
		Ecriture.ecrireStringln(file,"isupegal");
	}
	
	public void iegal(){
		Ecriture.ecrireStringln(file,"iegal");
	}
	
	public void idiff(){
		Ecriture.ecrireStringln(file,"idiff");
	}
	/*---------------------*/
	
	/*MÃ©thode stockage et de chargement*/
	public void iload(int offset){
		Ecriture.ecrireStringln(file,"iload "+offset);
	}
	
	public void istore(int offset){
		Ecriture.ecrireStringln(file,"istore "+offset);
	}
	
	public void iconst(int constante){
		Ecriture.ecrireStringln(file,"iconst "+constante);
	}
	
	/*MÃ©thode contrÃ´le de flot*/
	public void ifeq(String etiquette){
		Ecriture.ecrireStringln(file,"ifeq "+etiquette);
	}
	
	public void iffaux(String etiquette){
		Ecriture.ecrireStringln(file,"iffaux "+etiquette);
	}
	
	public void jump(String etiquette){
		Ecriture.ecrireStringln(file,"goto "+etiquette);
	}
	/*----------------------*/
	
	/*MÃ©thode de pile*/
	public void entete(String nomProgramme){
		file = Ecriture.ouvrir(nomProgramme+".yvm");
		Ecriture.ecrireStringln(file,"entete");
	}
	
	public void queue(){
		Ecriture.ecrireStringln(file,"queue");
		Ecriture.fermer(file);
	}
	/*--------------------*/
	

	/*Méthode de d'instruction */
	public void ecrireEnt(){
		Ecriture.ecrireStringln(file,"ecrireEnt");
	}
	
	public void ecrireChaine(String chaine){
		Ecriture.ecrireStringln(file,"ecrireChaine "+chaine);	
	}
	
	public void lireEnt(int offset){
		Ecriture.ecrireStringln(file,"lireEnt "+offset);
	}
	
	public void aLaLigne() {
		Ecriture.ecrireStringln(file,"aLaLigne");
	}
	
	public void ecrireBool(){
		Ecriture.ecrireStringln(file,"ecrireBool");
	}
	/*--------------------*/
	
	/*Méthodes pour itérations*/
	public void faire(int numEtiq){
		Ecriture.ecrireStringln(file,"FAIRE"+numEtiq+":");
	}
	
	public void fait(int numEtiq){
		Ecriture.ecrireStringln(file, "FAIT"+numEtiq+":");
	}
	
	/*MÃ©thodes de la conditionnelle */
	
	public void sinon(int imbr){
		Ecriture.ecrireStringln(file,"SINON" +imbr+ ":");	
	}
	
	public void fsi(int imbr){
		Ecriture.ecrireStringln(file,"FSI" +imbr+ ":");	
	}
	/*----------------------------*/
	
	/*Méthode pour les fonctions*/
	public void ouvreBloc(int offset){
		Ecriture.ecrireStringln(file,"ouvbloc "+offset);	
	}
	
	public void fermeBloc(int offset){
		Ecriture.ecrireStringln(file,"fermebloc "+offset);	
	}
	
	public void ireturn(int offset){
		Ecriture.ecrireStringln(file,"ireturn "+offset);	
	}
	
	public void reserveRetour(){
		Ecriture.ecrireStringln(file,"reserveRetour");	
	}
	
	public void call(String nom){
		Ecriture.ecrireStringln(file,"call "+nom);	
	}
	
	/*Méthode pour etiquette de fonction*/
	public void etiquetteFonc(String etiq){
		Ecriture.ecrireStringln(file,etiq+":");
	}
}
