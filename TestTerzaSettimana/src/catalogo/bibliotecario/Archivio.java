package catalogo.bibliotecario;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

public class Archivio {
	private Map<String, Pubblicazione> listaArchivio = new HashMap<String, Pubblicazione>();
	private File pubFile = new File("Pubblicazioni txt");


	public void nuovoElemento(Pubblicazione elemento) {
		listaArchivio.put(elemento.getIsbn(), elemento);
	}

	public Pubblicazione eliminaElemento(String isbn) {
		Pubblicazione rimossa = listaArchivio.remove(isbn);
		return rimossa;
	}

	public Pubblicazione cercaConIsbn(String isbn) {
		Pubblicazione x = listaArchivio.get(isbn);
		return x;
	}
	

	public List<Pubblicazione> ricercaPerAnno (int anno){
		Collection<Pubblicazione> x = listaArchivio.values();
		List<Pubblicazione> cerca = x.stream().filter(p->p.getAnnoPubblicazione()==anno).collect(Collectors.toList());
		return cerca;
	}
	public List<Libro> ricercaPerAutore (String autore){
		//List<Libro> y = listaArchivio.values();
		List<Libro> libro = listaArchivio.values().stream().filter(p->p.getClass()==Libro.class).map(p->(Libro)p).filter(p->p.getAutore().equals(autore)).collect(Collectors.toList());
		return libro;
	}
	
	public void salva() throws IOException {
		String pubString = listaArchivio.values().stream().map(p-> p.toFileString()).collect(Collectors.joining("@"));
		FileUtils.writeStringToFile(pubFile, pubString,"UTF-8");
	}
	
	public void leggi() throws IOException {
		String puString = FileUtils.readFileToString(pubFile, "UTF-8");
		String[] tokens = puString.split("@");
		Stream.of(tokens).map(p-> Pubblicazione.fromFileString(p)).forEach(p->listaArchivio.put(p.getIsbn(), p));
	}
	public void svuota() {
		listaArchivio.clear();
	}
	String report() {
		String repotString = listaArchivio.values().stream().map(Pubblicazione::reportString).collect(Collectors.joining());
		return repotString;
	}
	
}
