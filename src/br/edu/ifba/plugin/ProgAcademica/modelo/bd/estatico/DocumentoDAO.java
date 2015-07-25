package br.edu.ifba.plugin.ProgAcademica.modelo.bd.estatico;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Mock de acesso a banco de dados. Utiliza colecoes estaticas para
 * simular manipulacao de banco.
 * 
 * OBS.: deve ser substituido por fachada(s) real(is).
 * 
 * @author PLUGIN
 */
public class DocumentoDAO {

	private static Map<Integer, Documento> documentos = 
			new TreeMap<Integer, Documento>();
	
	static {
		
		Documento d1 = new Documento();
		d1.setTitulo("Processo de Ajuste de Matricula");
		d1.setTipo("Declaração");
		d1.setLogin("astro");
		d1.setSenha("123");
		
		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		d1.setData(data);
		
		documentos.put(d1.getId(), d1);
		
		Documento d2 = new Documento();
		d2.setId(2);
		d2.setTitulo("Atestado de Ausência");
		d2.setTipo("Atestado");
		d2.setLogin("telva");
		d2.setSenha("456");
		d2.setData(data);
		
		documentos.put(d2.getId(), d2);
	}
	
	public static List<Documento> getDocumentosPorLoginSenha(
			String login,
			String senha) {
		List<Documento> encontrados = new ArrayList<Documento>();
		
		for (Documento d : documentos.values()) {
			if (d.getLogin().equals(login) && 
					d.getSenha().equals(senha)) {
				encontrados.add(d);
			}
		}
		
		return encontrados;
	}
	
	public static List<Documento> getDocumentosPorTitulo(String titulo)
	{
		List<Documento> encontrados = new ArrayList<Documento>();
		
		for (Documento d : documentos.values()) {
			if (d.getTitulo().equals(titulo)) {
				encontrados.add(d);
			}
		}
		
		return encontrados;
	}
	
	
	public static List<Documento> getDocumentosPorData(String data)
	{
		List<Documento> encontrados = new ArrayList<Documento>();
		
		for (Documento d : documentos.values()) {
			if (d.getData().equals(data)) {
				encontrados.add(d);
			}
		}
		
		return encontrados;
	}
	
	
	public static List<Documento> getDocumentosPorTipo(String tipo)
	{
		List<Documento> encontrados = new ArrayList<Documento>();
		
		for (Documento d : documentos.values()) {
			if (d.getTipo().equals(tipo)) {
				encontrados.add(d);
			}
		}
		
		return encontrados;
	}

	
	
	public static Documento getDocumento(int id) {
		return documentos.get(id);
	}
	
	public static void remover(int id) {
		 documentos.remove(id);
	}
	
}











