package Grafico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import Distribuciones.Metodomagico;



public class Interfaz extends JFrame implements ActionListener{

private static final long serialVersionUID = 1L;
	

	Metodomagico mm= new Metodomagico();
	double[] datos=null;
	JPanel centralPanel;
    JPanel Panel1;
    JPanel Panel2;
    JPanel Panel3;
    String f1="Normal";
    String f2="Densidad";
    int salto=0;
    JButton btn1= new JButton("Densidad");
	JButton btn2= new JButton("Acumulada");
	JButton btn3= new JButton("Inversa");
	JButton btn4= new JButton("Guardar");
	JTextField txt1;
	JTextField txt2;
	JTextField txt3;
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	
	JButton[] botones1 = new JButton[] {
			new JButton("Normal"),
			new JButton("Exponencial"),
			new JButton("Uniforme"),
			new JButton("Poisson"),
			new JButton("Triangular"),
			new JButton("T Student"),
			new JButton("F Fisher"),
			new JButton("Hipergeométrica"),
			new JButton("Binomial"),
			new JButton("Chi-Cuadrado"),
			new JButton("Weibull"),
			new JButton("Geometrica"),
			new JButton("BinomialNegativa")
	};
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
	      Interfaz example = new Interfaz("Aplicacion de simulacion");
	      example.setAlwaysOnTop(true);
	      example.pack();
	      example.setSize(600, 400);
	      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	      example.setVisible(true);
	    });
	  }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==botones1[0]) {
			f1="Normal";
		}
		if(arg0.getSource()==botones1[1]) {
			f1="Exponencial";
		}
		if(arg0.getSource()==botones1[2]) {
			f1="Uniforme";
		}
		if(arg0.getSource()==botones1[3]) {
			f1="Poisson";
		}
		if(arg0.getSource()==botones1[4]) {
			f1="Triangular";
		}
		if(arg0.getSource()==botones1[5]) {
			f1="T Student";
		}
		if(arg0.getSource()==botones1[6]) {
			f1="F Fisher";
		}
		if(arg0.getSource()==botones1[7]) {
			f1="Hipergeométrica";
		}
		if(arg0.getSource()==botones1[8]) {
			f1="Binomial";
		}
		if(arg0.getSource()==botones1[9]) {
			f1="Chi-Cuadrado";
		}
		if(arg0.getSource()==botones1[10]) {
			f1="Weibull";
		}
		if(arg0.getSource()==botones1[11]) {
			f1="Geometrica";
		}
		if(arg0.getSource()==botones1[12]) {
			f1="BinomialNegativa";
		}
		
		if(arg0.getSource()==btn1) {
			f2="Densidad";
			tabla();
		}
		if(arg0.getSource()==btn2) {
			f2="Acumulada";
			tabla();
		}
		if(arg0.getSource()==btn3) {
			f2="Inversa";
			tabla();
		}
		if(arg0.getSource()==btn4) {
			if(datos!=null) {
			try {
				new Archivo().archivador(datos, f1,f2,mm);
			} catch (IOException e) {
				
				e.printStackTrace();
			}	
			}
		}
		
	}
	
	public Interfaz(String title) {
	    super(title);
	    Paneles();
	    crearbotones1();
	    crearbotones2();
	    tabla();
	    
	  }
	public void Paneles() {
		 centralPanel = new JPanel();
	     Panel1 = new JPanel();
	     Panel2 = new JPanel();
	     Panel3 = new JPanel();


	    centralPanel.setLayout(new GridLayout(1,3));

	    Panel1.setLayout(new BoxLayout(Panel1,BoxLayout.Y_AXIS));
	    Panel1.setMaximumSize ( new Dimension ( 120, this.HEIGHT ) );
	    Panel1.setMinimumSize ( new Dimension ( 120, this.HEIGHT ) );

	    
	    Panel2.setLayout(new BoxLayout(Panel2,BoxLayout.Y_AXIS));
	    Panel2.setMaximumSize ( new Dimension ( 120, this.HEIGHT ) );
	    Panel2.setMinimumSize ( new Dimension ( 120, this.HEIGHT ) );
	    
	    Panel3.setLayout(new BoxLayout(Panel3,BoxLayout.Y_AXIS));
	    Panel3.setMaximumSize ( new Dimension ( 200, this.HEIGHT ) );
	    Panel3.setMinimumSize ( new Dimension ( 200, this.HEIGHT ) );

	    centralPanel.add(Panel1);
	    centralPanel.add(Panel2);
	    centralPanel.add(Panel3);
	    
	    

	    this.add(centralPanel);
	    this.setVisible(true);
	}
	
	public void crearbotones1() {
		
		for(int i =0;i<botones1.length;i++) {
			botones1[i].setBounds(10,(40*i),120,25);
			Panel1.add(botones1[i]);
			botones1[i].addActionListener(this);
		}
	}
	
	public void crearbotones2() {
		
		txt();
		
		Panel2.add(btn1);
		btn1.addActionListener(this);
				
		Panel2.add(btn2);
		btn2.addActionListener(this);

		Panel2.add(btn3);
		btn3.addActionListener(this);
		
		Panel2.add(btn4);
		btn4.addActionListener(this);
	}
private void txt() {
		
	lb3= new JLabel("cantidad");
	Panel2.add(lb3);
	txt3= new JTextField(20);
	txt3.setText("4000");
	Panel2.add(txt3);
		switch(f1){
		case"Normal":
			 lb1= new JLabel("Media");
			Panel2.add(lb1);
			txt1= new JTextField(20);
			Panel2.add(txt1);
			 lb2= new JLabel("Desviacion");
			Panel2.add(lb2);
			txt2= new JTextField(20);
			Panel2.add(txt2);
			break;
		case"Exponencial":
			lb1= new JLabel("Parametro");
			Panel2.add(lb1);
			txt1= new JTextField(20);
			Panel2.add(txt1);
			break;
		case"Uniforme":
			lb1= new JLabel("Parametro");
			Panel2.add(lb1);
			txt1= new JTextField(20);
			Panel2.add(txt1);
			break;
		case"Geometrica":
			 lb1= new JLabel("Intentos");
			Panel2.add(lb1);
			txt1= new JTextField(20);
			break;
		case"Poisson":
			 lb1= new JLabel("Lambda");
			Panel2.add(lb1);
			txt1= new JTextField(20);
			break;
		case"BinomialNegativa":
			 lb1= new JLabel("Seguida");
			Panel2.add(lb1);
			txt1= new JTextField(20);
			Panel2.add(txt1);
			 lb2= new JLabel("Intentos");
			Panel2.add(lb2);
			txt2= new JTextField(20);
			Panel2.add(txt2);
			break;
		}
	}
	
	
	
	private void tabla() {
		if (Panel3.getComponentCount()!=0) {
			Panel3.remove(0);
		}
		
		
		// Create dataset
	    DefaultCategoryDataset dataset = createDataset();
	    // Create chart
	    JFreeChart chart = ChartFactory.createLineChart(
	        "Funcion de "+f1+" de la Distribucion "+f2, // Chart title
	        "X", // X-Axis Label
	        "Probabilidad", // Y-Axis Label
	        dataset
	        );

	    ChartPanel panel = new ChartPanel(chart);
	    Panel3.add(panel);
	    this.setVisible(true);
	}
	
	  private DefaultCategoryDataset createDataset() {
		  String regex = "-?\\d+";
		  int cant =4000;
		  if(txt3.getText().matches(regex)) {
			  cant =Integer.parseInt(txt3.getText());
		  }
		  
		  
		  
		  
		  switch(f1) {
		  case"Normal":
			  if(txt1.getText().matches(regex)&&txt2.getText().matches(regex)) {
				  mm.Normal(Double.parseDouble(txt1.getText()),Double.parseDouble(txt2.getText()));
			  }else {
				  mm.Normal(0.0,0.1);
			  }
			  break;
		  case"Geometrica":
			  if(txt1.getText().matches(regex)&&txt2.getText().matches(regex)) {
				  mm.Geometrica(Double.parseDouble(txt1.getText()));
			  }else {
				  mm.Geometrica(0.7);
			  }
			  break;
		  case"Poisson":
			  if(txt1.getText().matches(regex)&&txt2.getText().matches(regex)) {
				  mm.Poisson(Double.parseDouble(txt1.getText()));
			  }else {
				  mm.Poisson(10);
			  }
			  break;
		  case"BinomialNegativa":
			  if(txt1.getText().matches(regex)&&txt2.getText().matches(regex)) {
				  mm.BinomialNegativa(Integer.parseInt(txt1.getText()),Double.parseDouble(txt2.getText()));
			  }else {
				  mm.BinomialNegativa(2, .7);;
			  }
			  break;
		  }
		  
		 datos= mm.aletorio(f1,cant);
		  
		  System.out.print(datos.length);
		  
	    String serie = "fmp";
	    
	    

	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    
	    

	    for(int i=0 ;i<datos.length;i++) {
	    	
	    	if(f2=="Inversa") {
	    	dataset.addValue(datos[i], serie,new Double(mm.acumulativa(f1, datos[i])));
	    	}else if(f2=="Densidad"){
	    	dataset.addValue(mm.probabilidad(f1, datos[i]), serie,new Double(datos[i]));	
	    	}else {
	    	dataset.addValue(mm.acumulativa(f1, datos[i]), serie,new Double(datos[i]));	
	    		    	
	    	}
	    }
	    
	    
	    
	    return dataset;
	  }
	
}
