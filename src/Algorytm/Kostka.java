package Algorytm;

import java.io.Serializable;

public class Kostka implements Jablko, Serializable {
	public void przygotowaniejablka() {
	System.out.println("Kroimy jablka na kostki");
	}

	@Override
	public String toString() {
		return "Jablka w Kostke";
	}
}
