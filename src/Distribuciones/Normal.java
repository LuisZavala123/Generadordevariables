package Distribuciones;

import java.util.Arrays;

import org.apache.commons.math3.distribution.NormalDistribution;

import Generadores.Congruencialmixto;

public class Normal {

	private static double media;
	private static double std;
	static NormalDistribution normal;
	
	public Normal() {
		this(0.0,1.0);
	}
	
	public Normal(double media, double std) {
		this.media=media;
		this.std=std;
		normal = new NormalDistribution(media,std);
	}
	
	public double probabilidad(double x) {
		return normal.density(x);
	}
	
	public double[] probabilidad(double[] x) {
		double[] resultado = new double[x.length];
		
		for(int i=0;i<x.length;i++) {
			resultado[i]=probabilidad(x[i]);
		}
		
		return resultado;
	}
	
	public double probabilidadacumulada(double x) {
		return normal.cumulativeProbability(x);
	}
	
	public double[] probabilidadacumulada(double[] x) {
		double[] resultado = new double[x.length];
		
		for(int i=0;i<x.length;i++) {
			resultado[i]=probabilidadacumulada(x[i]);
		}
		
		return resultado;
	}
	
	public static double inverso(double p) {
		return normal.inverseCumulativeProbability(p);
	}
	
	public double[] inverso (double[] P) {
		double[] valores = new double[P.length];
		for(int i=0;i<P.length;i++)
		{
			valores[i] =inverso(P[i]);
		}
		
		return valores;
	}
	
	public static double[] aleatorio(int cantidad) {
		// imitar rnorm
		
		Congruencialmixto Mixto = new Congruencialmixto(3,Math.pow(7, 5), 0,Math.pow(2, 31)-1);
		
		double[] valoresf = Mixto.siguiente(cantidad);
		double[] valores= new double[valoresf.length] ;
		for(int i=0;i<valores.length;i++) {
			valores[i]=inverso(valoresf[i]);
		}
		
		Arrays.sort(valores);
		
		return valores ;
	}
	
	
	
	public static double normalizar(double x) {
		
		double theta = 2*Math.PI*x;
		
		double rho = Math.sqrt(-2*Math.log(1-x));
		
		double escala = std*rho;
		
		return media+escala*Math.sin(theta);
		
		
	}
}
