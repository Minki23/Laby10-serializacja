package Algorytm;

import java.io.Serializable;

public class Cwiartki implements Jablko, Serializable {
	public void przygotowaniejablka() { System.out.println("Kroimy jablka na cwiartki");}

	@Override
	public String toString() {
		return "Jablka w Cwiartki";
	}
}
