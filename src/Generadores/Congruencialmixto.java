package Generadores;

import java.util.ArrayList;

public class Congruencialmixto {
	 double semilla =15;
	 double aditiva = 16;
	 double multiplicador= 8;
	 double modulo= 100;
	
	
	
	
	public Congruencialmixto() {
		
	}
	
	public Congruencialmixto(double X0,double a,double c,double m) {
		this.semilla=X0;
		this.aditiva=a;
		this.multiplicador=c;
		this.modulo=m;
	}
	
	public double siguiente() {
		semilla =((semilla*aditiva)+multiplicador)%modulo;
		semilla=semilla/(modulo-1);
		return semilla;
	}
	
	public double[] siguiente(int n) {
		double[] lista = new double[n];
		for(int i =0;i<n;i++)
		{
		semilla = (semilla*aditiva+multiplicador)%modulo;
		lista[i]=semilla/(modulo-1);
		}
		return lista;
	}
	
	public double[] todos() {
		ArrayList<Double> lista = new ArrayList();
		boolean con = true;
		do{
		semilla = (semilla*aditiva+multiplicador)%modulo;
		
		if(!lista.contains(semilla/(modulo-1))) {
			
			lista.add(semilla/(modulo-1));
		}else {
			con = false;
		}
		}while(con);

		double[] resultado = new double[lista.size()];
		for(int x = 0;x<lista.size();x++) {
			resultado[x]=lista.get(x);
		}
		
		return resultado;
	}
}
