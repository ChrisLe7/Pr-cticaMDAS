package es.uco.mdas.datos;

import java.io.EOFException;
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

import es.uco.mdas.business.socio.DetallesAbono;

public class AbonoDAOImpFicheros implements AbonoDAO{

	private static final String FICHEROPROPIEDADES = "gestor.properties";
	private static final String NOMBREFICHERO = "ficheroNombreAbono";
	
	private static final String NOMBREFICHEROAUXILIAR = "aux.bin";
	
	public HashMap <String, DetallesAbono> queryAll() {
		
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
		HashMap <String, DetallesAbono> listadoAbonos = new HashMap<String, DetallesAbono> ();
		
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
			DetallesAbono abono = null;
			try {
				while(true) {
					abono = (DetallesAbono) contenidoFichero.readObject();
					String clave = abono.getIdAbono();
					listadoAbonos.put(clave, abono);
				}
				
			} catch (EOFException e) {
				// Significa que ha terminado de leer el fichero
			}  catch (ClassNotFoundException e) {
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
		
		return listadoAbonos;
	}
	
	public DetallesAbono queryById(String idSocio) {
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
		DetallesAbono abonoSocio = null;
		
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
			DetallesAbono abono = null;
			try {
				while (true) {
					abono = (DetallesAbono) contenidoFichero.readObject();
					if (abono.getIdSocio().equals(idSocio)) {
						abonoSocio = abono;
						break;
					}
				}
				
			} catch (EOFException e ) {
				// Significa que ha terminado de leer el fichero
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
		
		return abonoSocio;
	}
	
	public boolean update(DetallesAbono abonoModificado) {
		
		Boolean estado = false;
		Properties properties = new Properties();
		String nombreFichero = null;
		FileReader filePropiedades;
		File oldFile = null;
		File newFile = null;
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
			
			oldFile = new File(nombreFichero);
			ficheroOrigen = new FileInputStream (oldFile);
			contenidoFicheroOrigen= new ObjectInputStream (ficheroOrigen);
			
			newFile = new File(NOMBREFICHEROAUXILIAR);
			ficheroDestino = new FileOutputStream (newFile);
			contenidoFicheroDestino= new ObjectOutputStream (ficheroDestino);
				
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (contenidoFicheroOrigen != null && contenidoFicheroDestino != null) {
			DetallesAbono registroFichero = null;
			
			try {
				while (true) {
					registroFichero = (DetallesAbono) contenidoFicheroOrigen.readObject() ;
					if (registroFichero.getIdAbono().equals(abonoModificado.getIdAbono())) {
						registroFichero = abonoModificado;
						estado = !estado;
					}
					contenidoFicheroDestino.writeObject(registroFichero);
						
				}
			} catch (EOFException e) {
				// Significa que ha terminado de leer el fichero
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
			
			if (!oldFile.delete()) {
				System.out.println("Error borrando el fichero antiguo");
				estado = false;
			}
			else {
		        if (!newFile.renameTo(oldFile)) {
		        	System.out.println("Error al renombrar el archivo");
		        	estado = false;
		        }
		    }
			
		}
		
		
		return estado;
	}
	
	public boolean insert(DetallesAbono abono) {
		Properties properties = new Properties();
		String nombreFichero = null;
		FileReader filePropiedades;
		Boolean estado = true;
		File fich = null;
		
		try {
			filePropiedades = new FileReader(FICHEROPROPIEDADES);
			properties.load(filePropiedades);
			nombreFichero = properties.getProperty(NOMBREFICHERO);
			
			if (nombreFichero == null) {
				return false;
			}
			
			fich = new File(nombreFichero);
			ObjectOutputStream contenidoFichero = null;
			
			if (fich.length() == 0) {
				contenidoFichero = new ObjectOutputStream (new FileOutputStream (fich));
			}
			else {
				contenidoFichero = new MyObjectOutputStream (new FileOutputStream (fich, true));
			}
			
			if (contenidoFichero != null) {
				contenidoFichero.writeObject(abono);
				contenidoFichero.close();
				filePropiedades.close();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			estado = !estado;
		} catch (IOException e) {
			e.printStackTrace();
			estado = !estado;
		}
		
		return estado;
	}
	
	
	public boolean delete(String idAbono) {
		Boolean estado = false;
		Properties properties = new Properties();
		String nombreFichero = null;
		FileReader filePropiedades;
		File oldFile = null;
		File newFile = null;
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
			oldFile = new File(nombreFichero);
			ficheroOrigen = new FileInputStream (oldFile);
			contenidoFicheroOrigen= new ObjectInputStream (ficheroOrigen);
			
			newFile = new File(NOMBREFICHEROAUXILIAR);
			ficheroDestino = new FileOutputStream (newFile);
			contenidoFicheroDestino= new ObjectOutputStream (ficheroDestino);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (contenidoFicheroOrigen != null && contenidoFicheroDestino != null) {
			DetallesAbono registroFichero = null;
			
			try {
				while (true) {
					registroFichero = (DetallesAbono) contenidoFicheroOrigen.readObject();
					if (registroFichero.getIdAbono().equals(idAbono)) {
						estado = !estado;
					}
					else {
						contenidoFicheroDestino.writeObject(registroFichero);
					}
				}
			} catch (EOFException e) {
				// Significa que ha terminado de leer el fichero
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
			if (!oldFile.delete()) {
				System.out.println("Error borrando el fichero antiguo");
			}
			
	        if (!newFile.renameTo(oldFile)) {
	        	System.out.println("Error al renombrar el archivo");
	        }
		}
		
		
		return estado;
	}


	
}
