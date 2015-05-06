import java.io.OutputStream;


/**
 * Classe avec toutes les méthodes pour écrire le fichier .asm
 */
public class YVMasm extends YVM{
	
	OutputStream file;
	
	private int messCount;
	
	public YVMasm(){
		messCount = 0;
	}
	
	@Override
	public void iadd() {
		Ecriture.ecrireStringln(file,"\tpop bx");
		Ecriture.ecrireStringln(file,"\tpop ax");
		Ecriture.ecrireStringln(file,"\tadd ax,bx");
		Ecriture.ecrireStringln(file,"\tpush ax");
	}

	@Override
	public void isub() {
		Ecriture.ecrireStringln(file,"\tpop bx");
		Ecriture.ecrireStringln(file,"\tpop ax");
		Ecriture.ecrireStringln(file,"\tsub ax,bx");
		Ecriture.ecrireStringln(file,"\tpush ax");
	}

	@Override
	public void imul() {
		Ecriture.ecrireStringln(file,"\tpop bx");
		Ecriture.ecrireStringln(file,"\tpop ax");
		Ecriture.ecrireStringln(file,"\timul bx");
		Ecriture.ecrireStringln(file,"\tpush ax");
	}

	@Override
	public void idiv() {
		Ecriture.ecrireStringln(file,"\tpop bx");
		Ecriture.ecrireStringln(file,"\tpop ax");
		Ecriture.ecrireStringln(file,"\tcwd");
		Ecriture.ecrireStringln(file,"\tidiv bx");
		Ecriture.ecrireStringln(file,"\tpush ax");
	}

	@Override
	public void inot() {
		Ecriture.ecrireStringln(file,"\tpop ax");
		Ecriture.ecrireStringln(file,"\tnot ax");
		Ecriture.ecrireStringln(file,"\tpush ax");
	}

	@Override
	public void ineg() {
		Ecriture.ecrireStringln(file,"\tpop ax");
		Ecriture.ecrireStringln(file,"\tneg ax");
		Ecriture.ecrireStringln(file,"\tpush ax");
	}

	@Override
	public void ior() {
		Ecriture.ecrireStringln(file,"\tpop bx");
		Ecriture.ecrireStringln(file,"\tpop ax");
		Ecriture.ecrireStringln(file,"\tor ax,bx");
		Ecriture.ecrireStringln(file,"\tpush ax");
	}

	@Override
	public void iand() {
		Ecriture.ecrireStringln(file,"\tpop bx");
		Ecriture.ecrireStringln(file,"\tpop ax");
		Ecriture.ecrireStringln(file,"\tand ax,bx");
		Ecriture.ecrireStringln(file,"\tpush ax");
	}

	@Override
	public void iinf() {
		Ecriture.ecrireStringln(file,"\tpop bx");
		Ecriture.ecrireStringln(file,"\tpop ax");
		Ecriture.ecrireStringln(file,"\tcmp ax,bx");
		Ecriture.ecrireStringln(file,"\tjge $+6");
		Ecriture.ecrireStringln(file,"\tpush -1");
		Ecriture.ecrireStringln(file,"\tjmp $+4");
		Ecriture.ecrireStringln(file,"\tpush 0");
	}

	@Override
	public void isup() {
		Ecriture.ecrireStringln(file,"\tpop bx");
		Ecriture.ecrireStringln(file,"\tpop ax");
		Ecriture.ecrireStringln(file,"\tcmp ax,bx");
		Ecriture.ecrireStringln(file,"\tjle $+6");
		Ecriture.ecrireStringln(file,"\tpush -1");
		Ecriture.ecrireStringln(file,"\tjmp $+4");
		Ecriture.ecrireStringln(file,"\tpush 0");
	}

	@Override
	public void iinfegal() {
		Ecriture.ecrireStringln(file,"\tpop bx");
		Ecriture.ecrireStringln(file,"\tpop ax");
		Ecriture.ecrireStringln(file,"\tcmp ax,bx");
		Ecriture.ecrireStringln(file,"\tjg $+6");
		Ecriture.ecrireStringln(file,"\tpush -1");
		Ecriture.ecrireStringln(file,"\tjmp $+4");
		Ecriture.ecrireStringln(file,"\tpush 0");
	}

	@Override
	public void isupegal() {
		Ecriture.ecrireStringln(file,"\tpop bx");
		Ecriture.ecrireStringln(file,"\tpop ax");
		Ecriture.ecrireStringln(file,"\tcmp ax,bx");
		Ecriture.ecrireStringln(file,"\tjl $+6");
		Ecriture.ecrireStringln(file,"\tpush -1");
		Ecriture.ecrireStringln(file,"\tjmp $+4");
		Ecriture.ecrireStringln(file,"\tpush 0");
	}

	@Override
	public void iegal() {
		Ecriture.ecrireStringln(file,"\tpop bx");
		Ecriture.ecrireStringln(file,"\tpop ax");
		Ecriture.ecrireStringln(file,"\tcmp ax,bx");
		Ecriture.ecrireStringln(file,"\tjne $+6");
		Ecriture.ecrireStringln(file,"\tpush -1");
		Ecriture.ecrireStringln(file,"\tjmp $+4");
		Ecriture.ecrireStringln(file,"\tpush 0");
	}

	@Override
	public void idiff() {
		Ecriture.ecrireStringln(file,"\tpop bx");
		Ecriture.ecrireStringln(file,"\tpop ax");
		Ecriture.ecrireStringln(file,"\tcmp ax,bx");
		Ecriture.ecrireStringln(file,"\tje $+6");
		Ecriture.ecrireStringln(file,"\tpush -1");
		Ecriture.ecrireStringln(file,"\tjmp $+4");
		Ecriture.ecrireStringln(file,"\tpush 0");
	}

	@Override
	public void iload(int offset) {
		if (offset > 0){
			Ecriture.ecrireStringln(file,"\tpush word ptr[bp+"+offset+"]");
		}else{
			Ecriture.ecrireStringln(file,"\tpush word ptr[bp"+offset+"]");
		}
		
	}

	@Override
	public void istore(int offset) {
		Ecriture.ecrireStringln(file,"\tpop ax");
		if (offset > 0){
			Ecriture.ecrireStringln(file,"\tmov word ptr[bp+"+offset+"],ax");
		}else{
			Ecriture.ecrireStringln(file,"\tmov word ptr[bp"+offset+"],ax");
		}
		
	}

	@Override
	public void iconst(int constante) {
		Ecriture.ecrireStringln(file,"\tpush "+constante);
	}

	@Override
	public void ifeq(String etiquette) {
		Ecriture.ecrireStringln(file,"\tpop ax");
		Ecriture.ecrireStringln(file,"\tcmp ax,0");
		Ecriture.ecrireStringln(file,"\tje "+etiquette);
	}
	
	public void iffaux(String etiquette){
		Ecriture.ecrireStringln(file,"\tpop ax");
		Ecriture.ecrireStringln(file,"\tcmp ax,0");
		Ecriture.ecrireStringln(file,"\tje "+etiquette);
	}

	@Override
	public void jump(String etiquette) {
		Ecriture.ecrireStringln(file,"\tjmp "+etiquette);
	}
	
	public void entete(String nomProgramme){
		file = Ecriture.ouvrir(nomProgramme+".asm");
		Ecriture.ecrireStringln(file,"\textrn lirent:proc, ecrent:proc");
		Ecriture.ecrireStringln(file,"\textrn ecrbool:proc");
		Ecriture.ecrireStringln(file,"\textrn ecrch:proc, ligsuiv:proc");
		Ecriture.ecrireStringln(file,".model SMALL");
		Ecriture.ecrireStringln(file,".586");
		Ecriture.ecrireStringln(file,".CODE");
	}
	
	@Override
	public void main(){
		Ecriture.ecrireStringln(file,"debut :");
		Ecriture.ecrireStringln(file,"\tSTARTUPCODE");
	}
	
	@Override
	public void queue(){
		Ecriture.ecrireStringln(file,"\tnop");
		Ecriture.ecrireStringln(file,"\texitcode");
		Ecriture.ecrireStringln(file,"\tend debut");
		Ecriture.fermer(file);
	}
	
	@Override
	public void ecrireChaine(String chaine){
		Ecriture.ecrireStringln(file,".DATA");
		chaine = chaine.substring(1, chaine.length()-1);
		Ecriture.ecrireStringln(file,"\tmess"+messCount+" DB \""+chaine+"$\"");
		Ecriture.ecrireStringln(file,".CODE");
		Ecriture.ecrireStringln(file,"\tlea dx,mess"+messCount);
		messCount++;
		Ecriture.ecrireStringln(file,"\tpush dx");
		Ecriture.ecrireStringln(file,"\tcall ecrch");
	}
	
	@Override
	public void lireEnt(int offset){
		if(offset > 0){
			Ecriture.ecrireStringln(file,"\tlea dx,[bp+"+offset+"]");
		}else{
			Ecriture.ecrireStringln(file,"\tlea dx,[bp"+offset+"]");
		}
		Ecriture.ecrireStringln(file,"\tpush dx");
		Ecriture.ecrireStringln(file,"\tcall lirent");
		
	}
	
	@Override
	public void aLaLigne(){
		Ecriture.ecrireStringln(file,"\tcall ligsuiv");
	}
	
	@Override
	public void ecrireEnt(){
		Ecriture.ecrireStringln(file,"\tcall ecrent");
	}
	
	@Override
	public void ecrireBool(){
		Ecriture.ecrireStringln(file,"\tcall ecrbool");
	}
	
	@Override
	public void faire(int numEtiq){
		Ecriture.ecrireStringln(file,"\tFAIRE"+numEtiq+":");
	}
	
	@Override
	public void fait(int numEtiq){
		Ecriture.ecrireStringln(file,"\tFAIT"+numEtiq+":");
	}
	
	@Override
	public void sinon(int numEtiq){
		Ecriture.ecrireStringln(file,"\tSINON"+numEtiq+":");
	}
	
	@Override
	public void fsi(int numEtiq){
		Ecriture.ecrireStringln(file,"\tFSI"+numEtiq+":");
	}
	
	@Override
	public void ouvreBloc(int offset) {
		Ecriture.ecrireStringln(file,"\tenter "+offset+",0");
	}

	@Override
	public void fermeBloc(int offset) {
		Ecriture.ecrireStringln(file,"\tleave");
		Ecriture.ecrireStringln(file,"\tret "+offset);
	}

	@Override
	public void ireturn(int offset) {
		Ecriture.ecrireStringln(file,"\tpop ax");
		if (offset > 0){
			Ecriture.ecrireStringln(file,"\tmov [bp+"+offset+"],ax");
		}else{
			Ecriture.ecrireStringln(file,"\tmov [bp"+offset+"],ax");
		}
		
	}

	@Override
	public void reserveRetour() {
		Ecriture.ecrireStringln(file,"\tsub sp,2");
	}

	@Override
	public void call(String nom) {
		Ecriture.ecrireStringln(file,"\tcall "+nom);
	}
	
	@Override
	public void etiquetteFonc(String etiq){
		Ecriture.ecrireStringln(file,etiq+":");
	}
}
