package Distribuciones;

import java.util.stream.IntStream;

import org.apache.commons.math3.distribution.GeometricDistribution;

public class Metodomagico {
	
	Normal normal= null;
	Geometrica geometrica= null;
	Poisson poisson= null;
	BinomialNegativa negativa= null;
	
	
	public Metodomagico() {
		
	}
	
	public void Normal(double media, double std) {
		normal = new Normal(media,std);
	}
	
	public void Geometrica(double Numero) {
		geometrica = new Geometrica(Numero);
	}
	
	public void Poisson(double Lambda) {
		poisson = new Poisson(Lambda);
	}
	
	public void BinomialNegativa(int seguida, double intentos) {
		negativa = new BinomialNegativa(seguida,intentos);
	}
	
	public double probabilidad(String distribucion,double dato) {
		
		switch (distribucion) {
		case "Normal":
			if(normal!=null) {
				return normal.probabilidad(dato);
					}
			break;
		case "Geometrica":
			if(geometrica!=null) {
				double prob = geometrica.probabilidad((int)dato);
				return prob;
					}
			break;	
		case "Poisson":
			if(poisson!=null) {
				return poisson.probabilidad(dato);
					}
			break;
		case "BinomialNegativa":
			if(negativa!=null) {
				return negativa.probabilidad(dato);
					}
			break;
		}
		
		return dato;
		
	}
	
	public double[] probabilidad(String distribucion,double[] datos) {
		
		switch (distribucion) {
		case "Normal":
			if(normal!=null) {
				return normal.probabilidad(datos); 
					}
			break;
		case "Geometrica":
			if(geometrica!=null) {
				IntStream is = IntStream.range(0, datos.length).map(i->(int)datos[i]);
				return geometrica.probabilidad(is.toArray()); 
					}
			break;	
		case "Poisson":
			if(poisson!=null) {
				return poisson.probabilidad(datos);
					}
			break;
		case "BinomialNegativa":
			if(negativa!=null) {
				return negativa.probabilidad(datos);
					}
			break;
		
		}
		
		return null;
		
	}

public double acumulativa(String distribucion,double dato) {
		
		switch (distribucion) {
		case "Normal":
			if(normal!=null) {
				return normal.probabilidadacumulada(dato); 
					}
			break;
		case "Geometrica":
			if(geometrica!=null) {
				return geometrica.probabilidadacumulada((int)dato); 
					}
			break;	
		case "Poisson":
			if(poisson!=null) {
				return poisson.probabilidadacumulada(dato);
					}
			break;
		case "BinomialNegativa":
			if(negativa!=null) {
				return negativa.probabilidadacumulada(dato);
					}
			break;
		}
		
		return 0;
		
	}
	
public double[] acumulativa(String distribucion,double[] datos) {
		
		switch (distribucion) {
		case "Normal":
			if(normal!=null) {
				return normal.probabilidadacumulada(datos); 
					}
			break;
		case "Geometrica":
			if(geometrica!=null) {
				IntStream is = IntStream.range(0, datos.length).map(i->(int)datos[i]);
				return geometrica.probabilidadacumulada(is.toArray()); 
					}
			break;	
		case "Poisson":
			if(poisson!=null) {
				return poisson.probabilidadacumulada(datos);
					}
			break;
		case "BinomialNegativa":
			if(negativa!=null) {
				return negativa.probabilidadacumulada(datos);
					}
			break;
		
		
		}
		
		return null;
		
	}

public double inverso(String distribucion,double dato) {
	
	switch (distribucion) {
	case "Normal":
		if(normal!=null) {
			return Distribuciones.Normal.inverso(dato); 
				}
		break;
	case "Geometrica":
		if(geometrica!=null) {
			return Distribuciones.Geometrica.inverso(dato); 
				}
		break;	
	case "Poisson":
		if(poisson!=null) {
			return Distribuciones.Poisson.inverso(dato);
				}
		break;
	case "BinomialNegativa":
		if(negativa!=null) {
			return Distribuciones.BinomialNegativa.inverso(dato);
				}
		break;
	
	
	}
	
	return 0;
	
}

public double[] inverso(String distribucion,double[] datos) {
	
	switch (distribucion) {
	case "Normal":
		if(normal!=null) {
			return normal.inverso(datos); 
				}
		break;
	case "Geometrica":
		if(geometrica!=null) {
			return geometrica.inverso(datos); 
				}
		break;	
	case "Poisson":
		if(poisson!=null) {
			return poisson.inverso(datos);
				}
		break;
	case "BinomialNegativa":
		if(negativa!=null) {
			return negativa.inverso(datos);
				}
		break;
	
	}
	
	return null;
	
}



public double[] aletorio(String distribucion,int cantidad) {
	
	switch (distribucion) {
	case "Normal":
		if(normal!=null) {
			return Distribuciones.Normal.aleatorio(cantidad); 
				}
		break;
	case "Geometrica":
		if(geometrica!=null) {
			return Distribuciones.Geometrica.aleatorio(cantidad); 
				}
		break;	
	case "Poisson":
		if(poisson!=null) {
			return Distribuciones.Poisson.aleatorio(cantidad);
				}
		break;
	case "BinomialNegativa":
		if(negativa!=null) {
			return Distribuciones.BinomialNegativa.aleatorio(cantidad);
				}
		break;
	
	}
	
	return null;
	
}

}
