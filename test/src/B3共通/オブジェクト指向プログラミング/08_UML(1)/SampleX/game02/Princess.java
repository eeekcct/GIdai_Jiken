package game02;

public class Princess extends Character{

	private boolean rescueFlag=false;

	public Princess(){
		x = 550;
		y = 20;
	}

	// ====================
	// フラグ
	// ====================
	public void rescue(){
		rescueFlag=true;
	}

	public void notRescue(){
		rescueFlag=false;
	}

	public boolean isRescue(){
		return rescueFlag;
	}

}
