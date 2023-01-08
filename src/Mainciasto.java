import Algorytm.*;
import java.util.Arrays;
import java.io.*;
import java.util.*;


class Mainciasto {
	static Ciasto[] tablica=new Ciasto[1];
	static PieczeBabcia babcia = new PieczeBabcia();
	static PieczeDziadek dziadek = new PieczeDziadek();

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Scanner x = new Scanner(System.in);
		System.out.print("""
				Ktore ciasto wybierzemy?\s
				 Szarlotka - 1\s
				 Ciasto Sliwkowe - 2
				 Wybierz 3 aby zobaczyc baze ciast\s
				 Wybierz 4 aby wyczyscic baze danych\s
				 Wybor:""");
		switch (x.nextInt()) {
			case 1 -> {
				System.out.println("Zrobmy szartotke! Musimy przydzielic zadania");
				System.out.println("Kto przygotuje jablka? \n Babcia - 1 \n Dziadek - 2");
				if (x.nextInt() == 1) {
					babcia.przygotowaniejablka();
					System.out.print("Jaki sposob wybierzesz? \n 1 - Kroimy w kostke \n 2 - Kroimy na cwiartki");
					if (x.nextInt() == 1) {
						babcia.UstawSzarlotka(new Kostka());
						System.out.println("Babcia pokroi jablko w kostke");
					} else {
						babcia.UstawSzarlotka(new Cwiartki());
						System.out.println("Babcia pokroi jablko na polowki");
					}
					System.out.print("\n Babcia kroila jablka, wiec dziadek upiekl ciasto. Gotowe!");
					zapisz(babcia);
				} else {
					dziadek.przygotowaniejablka();
					System.out.print("Jaki sposob wybierzesz? \n 1 - Kroimy w kostke \n 2 - Kroimy na cwiartki");
					if (x.nextInt() == 1) {
						dziadek.UstawSzarlotka(new Kostka());
						System.out.println("Dziadke pokroi jablko w kostke ");
					} else {
						dziadek.UstawSzarlotka(new Cwiartki());
						System.out.println("Dziadek pokroi jablko na cwiartki");
						System.out.print("\nDziadek kroil jablka, wiec babcia upiekla ciasto. Gotowe!");
						zapisz(dziadek);
					}
				}
			}
			case 2 -> {
				System.out.println("Zrobmy ciasto sliwkowe! Musimy przydzielic zadania");
				System.out.println("Kto przygotuje sliwki? \n Babcia - 1 \n Dziadek - 2");
				if (x.nextInt() == 1) {
					babcia.przygotowaniesliwki();
					System.out.print("Jaki sposob wybierzesz? \n 1 - Miksujemy  \n 2 - Kroimy w polowki");
					if (x.nextInt() == 1) {
						babcia.UstawCiastosliwkowe(new Zmiksowanie());
						System.out.println("Babcia zmiksuje sliwki");
					} else {
						babcia.UstawCiastosliwkowe(new Polowki());
						System.out.println("Babcia pokroi sliwki na polowki");
					}
					System.out.println("\nBabcia przygotowala sliwki, wiec dziadek upiekl ciasto. Gotowe!");
					zapisz(babcia);
				} else {
					dziadek.przygotowaniesliwki();
					System.out.println("Jaki sposob wybierzesz? \n 1 - Miksujemy  \n 2 - Kroimy w polowki");
					if (x.nextInt() == 1) {
						dziadek.UstawCiastosliwkowe(new Zmiksowanie());
						System.out.println("Dziadek zmiksuje sliwki");
					} else {
						dziadek.UstawCiastosliwkowe(new Polowki());
						System.out.println("Dziadek pokroi sliwki na polowki");
					}
					System.out.println("\nDziadek przygotowywal sliwki, wiec Babcia upiekla ciasto. Gotowe!");
					zapisz(dziadek);
				}
			}
			case 3 -> {
				FileInputStream FIS = new FileInputStream("object-graph.ser");
				try {
					try {
						ObjectInputStream OIS = new ObjectInputStream(FIS);
						Ciasto[] obj = (Ciasto[]) OIS.readObject();
						System.out.println(Arrays.toString(obj));
						OIS.close();
					} catch (EOFException e) {
						System.out.println("Baza danych pusta");
					}
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				FIS.close();
			}
		}
		}
	public static void zapisz(Ciasto kto) throws IOException, ClassNotFoundException {
		try {
			try {
				FileInputStream FIS = new FileInputStream("object-graph.ser");
				ObjectInputStream OIS = new ObjectInputStream(FIS);
				Ciasto[] obj = (Ciasto[]) OIS.readObject();
				tablica = Arrays.copyOf(obj, obj.length + 1);
				tablica[tablica.length - 1] = kto;
				OIS.close();
				FIS.close();
			} catch (EOFException e) {
				FileOutputStream FOS = new FileOutputStream("object-graph.ser");
				ObjectOutputStream OOS = new ObjectOutputStream(FOS);
				tablica[0]=kto;
				OOS.writeObject(tablica);
				FOS.close();
				OOS.close();
			}
		} catch (IOException | ClassNotFoundException ignored) {
		}
		try {
			FileOutputStream FOS = new FileOutputStream("object-graph.ser");
			ObjectOutputStream OOS = new ObjectOutputStream(FOS);
			OOS.writeObject(tablica);
			FOS.close();
			OOS.close();
		} catch (EOFException ignored) {
		}
		System.out.println("Zapisano Ciasto");
	}
}
