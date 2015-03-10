import java.io.OutputStream;



public class YVMasm extends YVM{
	
	OutputStream file;
	
	@Override
	public void iadd() {
		Ecriture.ecrireStringln(file,"pop bx");
		Ecriture.ecrireStringln(file,"pop ax");
		Ecriture.ecrireStringln(file,"add ax,bx");
		Ecriture.ecrireStringln(file,"push ax");
	}

	@Override
	public void isub() {
		Ecriture.ecrireStringln(file,"pop bx");
		Ecriture.ecrireStringln(file,"pop ax");
		Ecriture.ecrireStringln(file,"sub ax,bx");
		Ecriture.ecrireStringln(file,"push ax");
	}

	@Override
	public void imul() {
		Ecriture.ecrireStringln(file,"pop bx");
		Ecriture.ecrireStringln(file,"pop ax");
		Ecriture.ecrireStringln(file,"imul bx");
		Ecriture.ecrireStringln(file,"push ax");
	}

	@Override
	public void idiv() {
		Ecriture.ecrireStringln(file,"pop bx");
		Ecriture.ecrireStringln(file,"pop ax");
		Ecriture.ecrireStringln(file,"cwd");
		Ecriture.ecrireStringln(file,"idiv bx");
		Ecriture.ecrireStringln(file,"push ax");
	}

	@Override
	public void inot() {
		Ecriture.ecrireStringln(file,"pop ax");
		Ecriture.ecrireStringln(file,"not ax");
		Ecriture.ecrireStringln(file,"push ax");
	}

	@Override
	public void ineg() {
		Ecriture.ecrireStringln(file,"pop ax");
		Ecriture.ecrireStringln(file,"neg ax");
		Ecriture.ecrireStringln(file,"push ax");
	}

	@Override
	public void ior() {
		Ecriture.ecrireStringln(file,"pop bx");
		Ecriture.ecrireStringln(file,"pop ax");
		Ecriture.ecrireStringln(file,"or ax,bx");
		Ecriture.ecrireStringln(file,"push ax");
	}

	@Override
	public void iand() {
		Ecriture.ecrireStringln(file,"pop bx");
		Ecriture.ecrireStringln(file,"pop ax");
		Ecriture.ecrireStringln(file,"and ax,bx");
		Ecriture.ecrireStringln(file,"push ax");
	}

	@Override
	public void iinf() {
		Ecriture.ecrireStringln(file,"pop bx");
		Ecriture.ecrireStringln(file,"pop ax");
		Ecriture.ecrireStringln(file,"cmp ax,bx");
		Ecriture.ecrireStringln(file,"jge $+6");
		Ecriture.ecrireStringln(file,"push -1");
		Ecriture.ecrireStringln(file,"jump $+4");
		Ecriture.ecrireStringln(file,"push 0");
	}

	@Override
	public void isup() {
		Ecriture.ecrireStringln(file,"pop bx");
		Ecriture.ecrireStringln(file,"pop ax");
		Ecriture.ecrireStringln(file,"cmp ax,bx");
		Ecriture.ecrireStringln(file,"jle $+6");
		Ecriture.ecrireStringln(file,"push -1");
		Ecriture.ecrireStringln(file,"jump $+4");
		Ecriture.ecrireStringln(file,"push 0");
	}

	@Override
	public void iinfegal() {
		Ecriture.ecrireStringln(file,"pop bx");
		Ecriture.ecrireStringln(file,"pop ax");
		Ecriture.ecrireStringln(file,"cmp ax,bx");
		Ecriture.ecrireStringln(file,"jg $+6");
		Ecriture.ecrireStringln(file,"push -1");
		Ecriture.ecrireStringln(file,"jump $+4");
		Ecriture.ecrireStringln(file,"push 0");
	}

	@Override
	public void isupegal() {
		Ecriture.ecrireStringln(file,"pop bx");
		Ecriture.ecrireStringln(file,"pop ax");
		Ecriture.ecrireStringln(file,"cmp ax,bx");
		Ecriture.ecrireStringln(file,"jl $+6");
		Ecriture.ecrireStringln(file,"push -1");
		Ecriture.ecrireStringln(file,"jump $+4");
		Ecriture.ecrireStringln(file,"push 0");
	}

	@Override
	public void iegal() {
		Ecriture.ecrireStringln(file,"pop bx");
		Ecriture.ecrireStringln(file,"pop ax");
		Ecriture.ecrireStringln(file,"cmp ax,bx");
		Ecriture.ecrireStringln(file,"jne $+6");
		Ecriture.ecrireStringln(file,"push -1");
		Ecriture.ecrireStringln(file,"jump $+4");
		Ecriture.ecrireStringln(file,"push 0");
	}

	@Override
	public void idiff() {
		Ecriture.ecrireStringln(file,"pop bx");
		Ecriture.ecrireStringln(file,"pop ax");
		Ecriture.ecrireStringln(file,"cmp ax,bx");
		Ecriture.ecrireStringln(file,"je $+6");
		Ecriture.ecrireStringln(file,"push -1");
		Ecriture.ecrireStringln(file,"jmp $+4");
		Ecriture.ecrireStringln(file,"push 0");
	}

	@Override
	public void iload(int offset) {
		Ecriture.ecrireStringln(file,"push word ptr[bp"+offset+"]");
	}

	@Override
	public void istore(int offset) {
		Ecriture.ecrireStringln(file,"pop ax");
		Ecriture.ecrireStringln(file,"mov word ptr[bp"+offset+"],ax");
	}

	@Override
	public void iconst(int constante) {
		Ecriture.ecrireStringln(file,"push "+constante);
	}

	@Override
	public void ifeq(String etiquette) {
		Ecriture.ecrireStringln(file,"pop ax");
		Ecriture.ecrireStringln(file,"cmp ax,0");
		Ecriture.ecrireStringln(file,"je "+etiquette);
	}
	
	public void iffaux(String etiquette){
		Ecriture.ecrireStringln(file,"pop ax");
		Ecriture.ecrireStringln(file,"cmp ax,0");
		Ecriture.ecrireStringln(file,"jne "+etiquette);
	}

	@Override
	public void jump(String etiquette) {
		Ecriture.ecrireStringln(file,"jmp "+etiquette);
	}
	
	public void entete(String nomProgramme){
		file = Ecriture.ouvrir(nomProgramme);
		Ecriture.ecrireStringln(file,".model SMALL");
		Ecriture.ecrireStringln(file,".586");
		Ecriture.ecrireStringln(file,".CODE");
		Ecriture.ecrireStringln(file,"debut :");
		Ecriture.ecrireStringln(file,"	STARUPCODE");
	}

	@Override
	public void ouvrePrinc(int taille) {
		Ecriture.ecrireStringln(file,"mov bp,sp");
	}
	
	@Override
	public void queue(){
		Ecriture.ecrireStringln(file,"nop");
		Ecriture.ecrireStringln(file,"exitcode");
		Ecriture.ecrireStringln(file,"end debut");
		Ecriture.fermer(file);
	}

}
