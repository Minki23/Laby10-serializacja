package Algorytm;

import java.io.Serializable;

public class Zmiksowanie implements Sliwka, Serializable {
	public void przygotowaniesliwki() { System.out.println("Miksujemy sliwki");}

	@Override
	public String toString() {
		return "Sliwki Zmiksowanie";
	}
}
