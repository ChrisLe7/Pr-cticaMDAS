package es.uco.mdas.datos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Properties;

import es.uco.mdas.business.socio.DetallesSocio;

public class SocioDAOImpFicheros implements SocioDAO{
	
	private static final String FICHEROPROPIEDADES = "gestor.properties";
	private static final String NOMBREFICHERO = "ficheroNombre";
	
	private static final String NOMBREFICHEROAUXILIAR = "aux.bin";
	
	public HashMap <String, DetallesSocio> querySocios() {
		
		Properties properties = new Properties();
		String nombreFichero = null;
		FileReader filePropiedades;
		try {
			filePropiedades = new FileReader(FICHEROPROPIEDADES);
			properties.load(filePropiedades);
			nombreFichero = properties.getProperty(NOMBREFICHERO);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (nombreFichero == null) {
			return null;
		}
		HashMap <String, DetallesSocio> listadoSocios = new HashMap<String, DetallesSocio> ();
		
		FileInputStream fichero = null;
		ObjectInputStream contenidoFichero = null;
		try {
			fichero = new FileInputStream (nombreFichero);
			contenidoFichero= new ObjectInputStream (fichero);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (contenidoFichero != null) {
			DetallesSocio socio = null;
			try {
				while ((socio = (DetallesSocio) contenidoFichero.readObject()) != null) {
					String clave = socio.getIdSocio();
					listadoSocios.put(clave, socio);
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				contenidoFichero.close();
				fichero.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return listadoSocios;
	}
	
	
	public boolean updateSocio(DetallesSocio socioModificado) {
		
		Boolean estado = false;
		Properties properties = new Properties();
		String nombreFichero = null;
		FileReader filePropiedades;
		try {
			
			filePropiedades = new FileReader(FICHEROPROPIEDADES);
			properties.load(filePropiedades);
			nombreFichero = properties.getProperty(NOMBREFICHERO);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (nombreFichero == null) {
			return estado;
		}
		
		FileInputStream ficheroOrigen = null;
		ObjectInputStream contenidoFicheroOrigen = null;
		
		FileOutputStream ficheroDestino = null;
		ObjectOutputStream contenidoFicheroDestino = null;
		
		try {
			ficheroOrigen = new FileInputStream (nombreFichero);
			contenidoFicheroOrigen= new ObjectInputStream (ficheroOrigen);
			
			ficheroDestino = new FileOutputStream (NOMBREFICHEROAUXILIAR);
			contenidoFicheroDestino= new ObjectOutputStream (ficheroDestino);
		
				
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (contenidoFicheroOrigen != null && contenidoFicheroDestino != null) {
			DetallesSocio registroFichero = null;
			
			try {
				while ((registroFichero = (DetallesSocio) contenidoFicheroOrigen.readObject() )!= null) {
					if (registroFichero.getIdSocio().equals(socioModificado.getIdSocio())) {
						registroFichero = socioModificado;
						estado = !estado;
					}
					contenidoFicheroDestino.writeObject(registroFichero);
						
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			try {
				contenidoFicheroOrigen.close();
				ficheroOrigen.close();
				contenidoFicheroOrigen.close();
				ficheroOrigen.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File oldfile = new File(nombreFichero);
	        File newfile = new File(NOMBREFICHEROAUXILIAR);
	        if (!newfile.renameTo(oldfile)) {
	        	System.out.println("Error al renombrar el archivo");
	        }
			
		}
		
		
		return estado;
	}
	
	public boolean insertSocio(DetallesSocio socio) {
		Properties properties = new Properties();
		String nombreFichero = null;
		FileReader filePropiedades;
		Boolean estado = true;
		try {
			filePropiedades = new FileReader(FICHEROPROPIEDADES);
			properties.load(filePropiedades);
			nombreFichero = properties.getProperty(NOMBREFICHERO);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (nombreFichero == null) {
			return false;
		}
		
		FileOutputStream fichero = null;
		ObjectOutputStream contenidoFichero = null;
		try {
			fichero = new FileOutputStream (nombreFichero);
			contenidoFichero= new ObjectOutputStream (fichero);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			estado = !estado;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			estado = !estado;
			e.printStackTrace();
		}
		
		if (contenidoFichero != null) {
			
			try {
				contenidoFichero.writeObject(socio);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				estado = !estado;
				e.printStackTrace();
			}
			
			try {
				contenidoFichero.close();
				fichero.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				estado = !estado;
				e.printStackTrace();
			}
			
			
		}
		
		return estado;
	}
	
	
	public boolean deleteSocio(String idSocio) {
		Boolean estado = false;
		Properties properties = new Properties();
		String nombreFichero = null;
		FileReader filePropiedades;
		try {
			
			filePropiedades = new FileReader(FICHEROPROPIEDADES);
			properties.load(filePropiedades);
			nombreFichero = properties.getProperty(NOMBREFICHERO);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (nombreFichero == null) {
			return estado;
		}
		
		FileInputStream ficheroOrigen = null;
		ObjectInputStream contenidoFicheroOrigen = null;
		
		FileOutputStream ficheroDestino = null;
		ObjectOutputStream contenidoFicheroDestino = null;
		
		try {
			ficheroOrigen = new FileInputStream (nombreFichero);
			contenidoFicheroOrigen= new ObjectInputStream (ficheroOrigen);
			
			ficheroDestino = new FileOutputStream (NOMBREFICHEROAUXILIAR);
			contenidoFicheroDestino= new ObjectOutputStream (ficheroDestino);
		
				
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (contenidoFicheroOrigen != null && contenidoFicheroDestino != null) {
			DetallesSocio registroFichero = null;
			
			try {
				while ((registroFichero = (DetallesSocio) contenidoFicheroOrigen.readObject() )!= null) {
					if (registroFichero.getIdSocio().equals(idSocio)) {
						estado = !estado;
					}
					else {
						contenidoFicheroDestino.writeObject(registroFichero);
					}
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			try {
				contenidoFicheroOrigen.close();
				ficheroOrigen.close();
				contenidoFicheroOrigen.close();
				ficheroOrigen.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File oldfile = new File(nombreFichero);
	        File newfile = new File(NOMBREFICHEROAUXILIAR);
	        if (!newfile.renameTo(oldfile)) {
	        	System.out.println("Error al renombrar el archivo");
	        }
			
		}
		
		
		return estado;
	}
	
}
