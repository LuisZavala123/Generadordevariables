package Distribuciones;

import java.util.Arrays;

import org.apache.commons.math3.distribution.GeometricDistribution;

import Generadores.Congruencialmixto;



public class Geometrica {

	private static double Numero;
	static GeometricDistribution geometrica;
	
	public Geometrica() {
		this(1);
	}
	
	public Geometrica(double Numero) {
		this.Numero=Numero;
		geometrica = new GeometricDistribution(Numero);
	}
	
	public double probabilidad(int x) {
		return geometrica.probability(x);
	}
	
	public double[] probabilidad(int[] x) {
		double[] resultado = new double[x.length];
		
		for(int i=0;i<x.length;i++) {
			resultado[i]=probabilidad(x[i]);
		}
		
		return resultado;
	}
	
	public double probabilidadacumulada(int x) {
		return geometrica.cumulativeProbability(x);
	}
	
	public double[] probabilidadacumulada(int[] x) {
		double[] resultado = new double[x.length];
		
		for(int i=0;i<x.length;i++) {
			resultado[i]=probabilidadacumulada(x[i]);
		}
		
		return resultado;
	}
	
	public static double inverso(double p) {
		return geometrica.inverseCumulativeProbability(p);
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
			System.out.print(valoresf[i]+" = ");
			System.out.println(valores[i]);
		}
		
		Arrays.sort(valores);
		
		return valores ;
	}
}
