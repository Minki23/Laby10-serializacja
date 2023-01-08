package Algorytm;

import java.io.Serializable;

public abstract class Ciasto implements Serializable {
	protected String algorytminfojablko;
	protected String algorytminfosliwka;
	protected Jablko szarlotka;
	protected Sliwka ciastosliwkowe;
	
	public String wykonajszarlotke()
	{
		return "Szarlotka z jablkami";
	}
	public String wykonajciastosliwkowe(){return "Ciasto ze sliwkami";}
	public Jablko getSzarlotka() {
		return szarlotka;
	}
	public void UstawSzarlotka(Jablko szarlotka) {
		this.szarlotka = szarlotka;
	}
	public Sliwka getCiastosliwkowe() {
		return ciastosliwkowe;
	}
	public void UstawCiastosliwkowe(Sliwka ciastosliwkowe) {
		this.ciastosliwkowe = ciastosliwkowe;
	}
	public String getAlgorytminfojablko() {
		return algorytminfojablko;
	}
	public void setAlgorytminfojablko(String algorytminfojablko) {
		this.algorytminfojablko = algorytminfojablko;
	}
	public String getAlgorytminfosliwka() {
		return algorytminfosliwka;
	}
	public void setAlgorytminfosliwka(String algorytminfosliwka) {
		this.algorytminfosliwka = algorytminfosliwka;
	}
	public void przygotowaniejablka() {	}

	@Override
	public String toString() {
		if(szarlotka==null){
			return "Ciasto:" +
					" ciasto sliwkowe, sposob sliwek:" + ciastosliwkowe+"\n";
		}
		if(ciastosliwkowe==null){
			return "Ciasto:" +
					" szarlotka, sposob jablek:" + szarlotka+"\n";
		}
		else return null;
	}
}