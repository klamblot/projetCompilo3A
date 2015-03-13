


public class Declaration {
	
	private int offSet = 0;
	private String saveName;
	
	public int getOffSet() {
		return offSet;
	}

	public void setOffSet(int offSet) {
		this.offSet = offSet;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	
	public Ident createIdentVar(String type, int offset){
		offSet-=2;
		return new IdVar(type,offSet);
	}
	
	public Ident createIdentConst(String type, int valeur){
		return new IdConst(type, valeur);
	}
	
	
}
