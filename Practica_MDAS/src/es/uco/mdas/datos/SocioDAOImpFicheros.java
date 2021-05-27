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

import es.uco.mdas.business.socio.DetallesSocio;

public class SocioDAOImpFicheros implements SocioDAO {
	
	private static final String FICHEROPROPIEDADES = "gestor.properties";
	private static final String NOMBREFICHERO = "ficheroNombre";
	
	private static final String NOMBREFICHEROAUXILIAR = "auxiliar.bin";
	
	public HashMap <String, DetallesSocio> queryAll() {
		
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
	
	public DetallesSocio queryById(String idSocio) {
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
		DetallesSocio detallesSocio = null;
		
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
					if (socio.getIdSocio().equals(idSocio)) {
						detallesSocio = socio;
						break;
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
				contenidoFichero.close();
				fichero.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return detallesSocio;
	}
	
	public boolean update(DetallesSocio socioModificado) {
		
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
			
			ficheroDestino = new FileOutputStream (new File(NOMBREFICHEROAUXILIAR));
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
				for (;;) {
					registroFichero = (DetallesSocio) contenidoFicheroOrigen.readObject();
					
					if (registroFichero.getIdSocio().equals(socioModificado.getIdSocio())) {
						registroFichero = socioModificado;
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
			File oldfile = new File(nombreFichero);
	        File newfile = new File(NOMBREFICHEROAUXILIAR);
	        	        
	        System.out.println(oldfile.getName());
	        System.out.println(newfile.getName());
	        
	        if (!newfile.renameTo(oldfile)) {
	        	System.out.println("Error al renombrar el archivo");
	        }
			
		}
		
		
		return estado;
	}
	
	public boolean insert(DetallesSocio socio) {
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
			fichero = new FileOutputStream (new File(nombreFichero));
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
	
	
	public boolean delete(String idSocio) {
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
