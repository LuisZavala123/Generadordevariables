package Distribuciones;

import java.util.Arrays;

import org.apache.commons.math3.distribution.PascalDistribution;

import Generadores.Congruencialmixto;

public class BinomialNegativa {
	private static double Numero;
	private static int cantidad;
	static PascalDistribution negativa;
	
	public BinomialNegativa() {
		this(3,.7);
	}
	
	public BinomialNegativa(int cantidad,double Numero) {
		this.Numero=Numero;
		this.cantidad=cantidad;
		negativa = new PascalDistribution(cantidad,Numero);
	}
	
	public double probabilidad(double x) {
		return negativa.probability((int)x);
	}
	
	public double[] probabilidad(double[] x) {
		double[] resultado = new double[x.length];
		
		for(int i=0;i<x.length;i++) {
			resultado[i]=probabilidad(x[i]);
		}
		
		return resultado;
	}
	
	public double probabilidadacumulada(double x) {
		return negativa.cumulativeProbability((int)x);
	}
	
	public double[] probabilidadacumulada(double[] x) {
		double[] resultado = new double[x.length];
		
		for(int i=0;i<x.length;i++) {
			resultado[i]=probabilidadacumulada(x[i]);
		}
		
		return resultado;
	}
	
	public static double inverso(double p) {
		return negativa.inverseCumulativeProbability(p);
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
