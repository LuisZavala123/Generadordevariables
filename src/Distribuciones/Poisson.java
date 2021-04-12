package Distribuciones;

import java.util.Arrays;

import org.apache.commons.math3.distribution.PoissonDistribution;

import Generadores.Congruencialmixto;

public class Poisson {
	
	private static double lambda;
	static PoissonDistribution poisson;
	
	public Poisson() {
		this(10);
	}
	
	public Poisson(double lambda) {
		this.lambda=lambda;
		poisson = new PoissonDistribution(lambda);
	}
	
	public double probabilidad(double x) {
		return poisson.probability((int)x);
	}
	
	public double[] probabilidad(double[] x) {
		double[] resultado = new double[x.length];
		
		for(int i=0;i<x.length;i++) {
			resultado[i]=probabilidad(x[i]);
		}
		
		return resultado;
	}
	
	public double probabilidadacumulada(double x) {
		return poisson.cumulativeProbability((int)x);
	}
	
	public double[] probabilidadacumulada(double[] x) {
		double[] resultado = new double[x.length];
		
		for(int i=0;i<x.length;i++) {
			resultado[i]=probabilidadacumulada(x[i]);
		}
		
		return resultado;
	}
	
	public static double inverso(double p) {
		return poisson.inverseCumulativeProbability(p);
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

}
