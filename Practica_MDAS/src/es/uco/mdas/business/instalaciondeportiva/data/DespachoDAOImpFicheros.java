package es.uco.mdas.business.instalaciondeportiva.data;

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

import es.uco.mdas.business.instalaciondeportiva.DetallesDespacho;

public class DespachoDAOImpFicheros implements DespachoDAO{

	private static final String FICHEROPROPIEDADES = "gestor.properties";
	private static final String NOMBREFICHERO = "ficheroNombreDespachos";
	private static final String NOMBREFICHEROAUXILIAR = "auxiliar.bin";

	@Override
	public HashMap<String, DetallesDespacho> queryAll() {
		Properties properties = new Properties();
		String nombreFichero = null;
		FileReader filePropiedades;
		File fich = null;
		
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
			return null;
		}
		HashMap <String, DetallesDespacho> listadoDespachos = new HashMap<String, DetallesDespacho> ();
		
		FileInputStream fichero = null;
		ObjectInputStream contenidoFichero = null;
		try {
			fich = new File(nombreFichero);
			fichero = new FileInputStream (fich);
			contenidoFichero= new ObjectInputStream (fichero);
		} catch (FileNotFoundException e) {
			System.out.println("El fichero de " + nombreFichero + " no existe");
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (contenidoFichero != null) {
			DetallesDespacho despacho = null;
			try {

				while(true) {

					despacho = (DetallesDespacho) contenidoFichero.readObject();
					String clave = despacho.getIdDespacho();
					listadoDespachos.put(clave, despacho);
				}
				
			} catch (EOFException e) {
				// Significa que ha terminado de leer el fichero
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				contenidoFichero.close();
				fichero.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return listadoDespachos;
	}

	@Override
	public DetallesDespacho queryById(String idItem) {
		Properties properties = new Properties();
		String nombreFichero = null;
		FileReader filePropiedades;
		File fich = null;
		
		try {
			filePropiedades = new FileReader(FICHEROPROPIEDADES);
			properties.load(filePropiedades);
			nombreFichero = properties.getProperty(NOMBREFICHERO);
			
		} catch (FileNotFoundException e) {
			System.out.println("El fichero de " + nombreFichero + " no existe");
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (nombreFichero == null) {
			return null;
		}
		DetallesDespacho detallesDespacho = null;
		
		FileInputStream fichero = null;
		ObjectInputStream contenidoFichero = null;
		try {
			fich = new File(nombreFichero);
			fichero = new FileInputStream (fich);
			contenidoFichero= new ObjectInputStream (fichero);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (contenidoFichero != null) {
			DetallesDespacho despacho = null;
			try {

				while(true) {

					despacho = (DetallesDespacho) contenidoFichero.readObject();
					
					if (despacho.getIdDespacho().equals(idItem)) {
						detallesDespacho = despacho;
						break;
					}
				}
				
			} catch (EOFException e ) {
				// Significa que ha terminado de leer el fichero
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				contenidoFichero.close();
				fichero.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return detallesDespacho;
	}

	@Override
	public boolean update(DetallesDespacho item) {
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
			System.out.println("El fichero de " + nombreFichero + " no existe");
			return estado;
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (contenidoFicheroOrigen != null && contenidoFicheroDestino != null) {
			DetallesDespacho registroFichero = null;
			
			try {

				while(true) {

					registroFichero = (DetallesDespacho) contenidoFicheroOrigen.readObject();

					if (registroFichero.getIdDespacho().equals(item.getIdDespacho())) {
						registroFichero = item;
						estado = !estado;
					}
					contenidoFicheroDestino.writeObject(registroFichero);
						
				}
			} catch (EOFException e) {
				// Significa que ha terminado de leer el fichero
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			try {
				contenidoFicheroOrigen.close();
				ficheroOrigen.close();
				contenidoFicheroDestino.close();
				ficheroDestino.close();
			} catch (IOException e) {
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

	@Override
	public boolean insert(DetallesDespacho item) {
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
				contenidoFichero.writeObject(item);
				contenidoFichero.close();
				filePropiedades.close();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("El fichero de " + nombreFichero + " no existe");
			estado = !estado;
		} catch (IOException e) {
			e.printStackTrace();
			estado = !estado;
		}
		
		return estado;
	}

	@Override
	public boolean delete(String idItem) {
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
			System.out.println("El fichero de " + nombreFichero + " no existe");
			return estado;
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		if (contenidoFicheroOrigen != null && contenidoFicheroDestino != null) {
			DetallesDespacho registroFichero = null;
			
			try {

				while(true) {

					registroFichero = (DetallesDespacho) contenidoFicheroOrigen.readObject();
					
					if (registroFichero.getIdDespacho().equals(idItem)) {
						estado = !estado;
					}
					else {
						contenidoFicheroDestino.writeObject(registroFichero);
					}
				}
			} catch (EOFException e) {
				// Significa que ha terminado de leer el fichero
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			try {
				contenidoFicheroOrigen.close();
				ficheroOrigen.close();
				contenidoFicheroDestino.close();
				ficheroDestino.close();
			} catch (IOException e) {
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
