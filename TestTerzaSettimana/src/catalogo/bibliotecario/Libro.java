package catalogo.bibliotecario;

public class Libro extends Pubblicazione{
	private String autore;
	private String genere;

	public Libro(String isbn, String titolo, int annoPubblicazione, int numeroPagine,String autore,String genere) {
		super(isbn, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public String getGenere() {
		return genere;
	}
	
	@Override
	public String toFileString(){
		return String.format("%s#%s#%s#%s","L",super.toFileString(), autore, genere);
	}
	
}
