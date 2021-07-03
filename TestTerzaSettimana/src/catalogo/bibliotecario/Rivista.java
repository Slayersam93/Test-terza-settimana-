package catalogo.bibliotecario;

public class Rivista  extends Pubblicazione {
	private Periodicita periodicita;

	public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine,Periodicita periodicita) {
		super(isbn, titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}
	@Override
	public String toFileString(){
		return String.format("%s#%s#%s","R",super.toFileString(), periodicita);
	}

}
