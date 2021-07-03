package catalogo.bibliotecario;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Libro l1 = new Libro("asiugd34", "ComePippareFormiche", 2020 , 200 , "GigiPierone","Informazione");
		Libro l2 = new Libro("ah34h32h", "Aprire le bottiglie di birra con le zampe", 2021 , 199 , "GigiPierone","Informazione");
		Libro l3 = new Libro("ah367d2h", "Imparare a riconoscere le stelle da ubriaco", 2021 , 250 , "GigiPierone","Informazione");
		Rivista r1 = new Rivista("asuihe23", "A cosa serve la parte sinistra del corpo", 2020, 80, Periodicita.MENSILE);
		Rivista r2 = new Rivista("asuhsadi", "Liofilizza e conserva i panda ecco come: ", 2021, 75, Periodicita.MENSILE);
		Rivista r3 = new Rivista("asudikkkk", "Simulare efficacemente il silenzio ecco come: ", 2020, 60, Periodicita.MENSILE);
		Archivio libreria = new Archivio();
		libreria.nuovoElemento(l1);	
		libreria.nuovoElemento(l2);
		libreria.nuovoElemento(l3);
		libreria.nuovoElemento(r1);
		libreria.nuovoElemento(r2);
		libreria.nuovoElemento(r3);
		
		System.out.println("Stampa Primo Report");
		System.out.println(libreria.report());
		try {
			libreria.salva();
			
			libreria.svuota();
			System.out.println("Stampa report dopo aver svuotato l'archivio");
			System.out.println(libreria.report());
			System.out.println();
			
			libreria.leggi();
			System.out.println("Stampa report dopo aver letto l'archivio");
			System.out.println(libreria.report());
			
			System.out.println("Stampa dopo aver eleminato l2");
			libreria.eliminaElemento("ah34h32h");
			System.out.println(libreria.report());
			System.out.println();
			
			System.out.println("Stampa Ricerca per isbn");
			Pubblicazione y = libreria.cercaConIsbn("asuhsadi");
			System.out.println(y.getTitolo());
			System.out.println();
			
			System.out.println("Stampa ricerca per anno");
			List<Pubblicazione> p = libreria.ricercaPerAnno(2020);
			p.stream().map(Pubblicazione::getTitolo).forEach(System.out::println);
			libreria.ricercaPerAutore("GigiPierone");
			System.out.println();
			
			System.out.println("Stampa ricerca per autore");
			List<Libro> p2 = libreria.ricercaPerAutore("GigiPierone");
			p2.stream().map(Pubblicazione::getTitolo).forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
