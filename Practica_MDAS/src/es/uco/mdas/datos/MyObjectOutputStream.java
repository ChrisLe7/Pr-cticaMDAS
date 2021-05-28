package es.uco.mdas.datos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {

	protected MyObjectOutputStream() throws IOException {
		super();
	}
	
	protected MyObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}
	
	protected void writeStreamHeader() throws IOException { }

}
