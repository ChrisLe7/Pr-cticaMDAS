package es.uco.mdas.datos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import es.uco.mdas.business.socio.DetallesSocio;

public class SocioDAOImpFicheros implements SocioDAO{
	
	private static String FICHEROPROPIEDADES = "gestor.properties";
	
	public HashMap <String, DetallesSocio> querySocios() {
		
		Properties properties = new Properties();
		String nombreFichero = null;
		FileReader fileReader;
		try {
			fileReader = new FileReader(FICHEROPROPIEDADES);
			properties.load(fileReader);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (properties != null) {
			
		}

		String interest = properties.getProperty("interests");
		
	}
	public boolean updateSocio(DetallesSocio socio);
	
	public boolean insertSocio(DetallesSocio socio);
	
	public boolean deleteSocio(String idSocio);
	
}
