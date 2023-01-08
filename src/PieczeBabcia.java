import Algorytm.Ciasto;

import java.io.Serializable;

public class PieczeBabcia extends Ciasto implements Serializable {
	
	public PieczeBabcia() {};
	public void wyswieltinfo() {};
	public void przygotowaniesliwki() {
		System.out.print("Babcia przygotuje sliwki");
	}
	public void przygotowaniejablka() {
		System.out.print("Babcia przygotuje jablka");
	}
}
