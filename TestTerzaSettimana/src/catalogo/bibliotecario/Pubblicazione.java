package catalogo.bibliotecario;

public abstract class Pubblicazione {
	private String isbn;
	private String titolo;
	private int annoPubblicazione;
	private int numeroPagine;
	
	public Pubblicazione(String isbn, String titolo, int annoPubblicazione, int numoeroPagine) {
		this.isbn = isbn;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numoeroPagine;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public int getNumoeroPagine() {
		return numeroPagine;
	}
	public String toFileString() {
		return String.format("%s#%s#%d#%d", isbn, titolo, annoPubblicazione, numeroPagine );
	}
	public static Pubblicazione fromFileString(String x) {
		String[] tokens = x.split("#");
		switch (tokens[0]) {
		case "L" :
			return new Libro(tokens[1], tokens[2], Integer.valueOf(tokens[3]), Integer.valueOf(tokens[4]), tokens[5], tokens[6]);
		case "R" :
			return new Rivista(tokens[1], tokens[2], Integer.valueOf(tokens[3]), Integer.valueOf(tokens[4]),Periodicita.valueOf(tokens[5]));
			default:
				throw new IllegalArgumentException("File corrotto, il discriminatore deve essere R o L");
		}
	}
	public String reportString() {
		return String.format("%s %s %s%n", isbn , titolo, this.getClass().getSimpleName());
	}

}
