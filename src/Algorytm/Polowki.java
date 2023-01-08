package Algorytm;

import java.io.Serializable;

public class Polowki implements Sliwka, Serializable {
    @Override
    public void przygotowaniesliwki(){ System.out.println("Miksujemy sliwki");}

    @Override
    public String toString() {
        return "Sliwki Polowki";
    }
}
