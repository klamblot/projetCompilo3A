import java.io.OutputStream;

public class YVM {
	
	OutputStream file;
	
	public YVM(){
	}
	
	/* Méthode arithmétique*/
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
	
	/*Méthode comparaison*/
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
	
	/*Méthode stockage et de chargement*/
	public void iload(int offset){
		Ecriture.ecrireStringln(file,"iload "+offset);
	}
	
	public void istore(int offset){
		Ecriture.ecrireStringln(file,"istore "+offset);
	}
	
	public void iconst(int constante){
		Ecriture.ecrireStringln(file,"iconst "+constante);
	}
	
	/*Méthode contrôle de flot*/
	public void ifeq(String etiquette){
		Ecriture.ecrireStringln(file,"ifeq "+etiquette);
	}
	
	public void iffaux(String etiquette){
		Ecriture.ecrireStringln(file,"iffaux "+etiquette);
	}
	
	public void jump(String etiquette){
		Ecriture.ecrireStringln(file,"jump "+etiquette);
	}
	/*----------------------*/
	
	/*Méthode de pile*/
	public void entete(String nomProgramme){
		file = Ecriture.ouvrir(nomProgramme+".yvm");
		Ecriture.ecrireStringln(file,"entete");
	}
	
	public void ouvrePrinc(int taille){
		Ecriture.ecrireStringln(file,"ouvrePrinc "+taille);
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
	
	/*Méthodes de l'itération */
	
	public void faire(int imbr){
		Ecriture.ecrireStringln(file,"FAIRE" +imbr+ ":");
	}
	
	public void fait(int imbr){
		Ecriture.ecrireStringln(file,"FAIT" +imbr+ ":");
	}
	
	/*Méthodes de la conditionnelle */
	
	public void sinon(int imbr){
		Ecriture.ecrireStringln(file,"SINON" +imbr+ ":");	
	}
	
	public void fsi(int imbr){
		Ecriture.ecrireStringln(file,"FSI" +imbr+ ":");	
	}
	
}
