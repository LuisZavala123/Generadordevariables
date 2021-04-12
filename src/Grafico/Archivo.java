package Grafico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import Distribuciones.Metodomagico;

public class Archivo {
	
	public void archivador(double[] Resultado,String f1,String f2, Metodomagico mm) throws IOException {
		String ruta ="C:/Users/cuyoc/eclipse-workspace/U3Entregable/src/Archivo";
		File Archivo = new File(ruta+"/"+f1+".csv");
		
		FileOutputStream is = new FileOutputStream(Archivo);
		
		OutputStreamWriter osw = new OutputStreamWriter(is);
		
		Writer w = new BufferedWriter(osw);
		
		w.write("X");
		w.write(",");
		w.write("probabilidad");
		w.write(",");
		w.write("acumulado");
		w.write("\n");
		for(int i = 0;i<Resultado.length;i++) {
			w.write(Resultado[i]+",");
			w.write(mm.probabilidad(f1, Resultado[i])+",");
			w.write(mm.acumulativa(f1, Resultado[i])+"");
			w.write("\n");
		}
		w.close();
		
		System.out.print("Archivo guardado en: "+ruta+"/"+f1+".csv");
	}

}
