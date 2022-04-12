package sistema.bancario.model;

import sistema.bancario.persistencia.PersistenciaArquivo;

public class Programa {

	public static void main(String[] args) {
		
		PersistenciaArquivo p = new PersistenciaArquivo();
		
		Cliente temp;
		
		temp = p.localizarClienteCPF("000");
		
		System.out.println(temp);
	}
}
