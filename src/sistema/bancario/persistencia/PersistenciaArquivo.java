package sistema.bancario.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import sistema.bancario.model.Cliente;

public class PersistenciaArquivo {

	private List<Cliente> clientesCadastrados = new ArrayList<>();

	public PersistenciaArquivo() {

		carregarDados();
	}

	public void adicionarCliente(Cliente c) {
		if (!clientesCadastrados.contains(c))
		{
			clientesCadastrados.add(c);
			salvarDados();
		}
		else
			System.out.println("Cliente já cadastrado");
	}
	
	public Cliente localizarClienteCPF(String cpf)
	{
		Cliente temp = new Cliente(cpf);
		
		if(clientesCadastrados.contains(temp)) {
			int index = clientesCadastrados.indexOf(temp);
			temp = clientesCadastrados.get(index);
			return temp;
		}
		else
			return null;
	}

	private void salvarDados() {
		try {
			FileOutputStream fos = new FileOutputStream("dados.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(clientesCadastrados);
			oos.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void carregarDados() {

		try 
		{
			FileInputStream fis = new FileInputStream("dados.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			clientesCadastrados = (ArrayList<Cliente>) ois.readObject();
			ois.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
