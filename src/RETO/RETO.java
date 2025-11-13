package RETO;

import java.io.*;//importo
import java.util.*;

public class RETO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("./src/RETO/DatosIgualdad.csv");//ruta relativa( copiar y pegar el fichero en el package y poner la ruta de por donde dice ecplise arriba)
		Scanner escritura = new Scanner(System.in);
		
		String[] pais = new String[29];//29 xq so 28 paises
		String[]ubicacion = new String[29];
		double [] trabajo = new double [29];
		double[]dinero = new double[29];
		double[]conocimiento = new double[29];
		double[] tiempo = new double[29];
		double[]poder = new double[29];
		double[]salud = new double[29];
		int opcion = 0;//para el switch
		
	
		
		try {
//			scanner que lee fichero 
			Scanner sc = new Scanner(file);
		
			if(sc.hasNextLine()) {
			sc.next();//salta el encabezado, lo que pone el titulo de los datos 
			}
			
			int i =0;
            // Leer línea por línea y guardar en arrays
			while(sc.hasNextLine()) {
				String linea;
				linea =sc.nextLine();// Leer toda la línea
				String[] datos = linea.split(";");//para separa por punto y coma 
//				System.out.println(linea);
				
				if(datos.length >=8) {
					pais[i] = datos[0];
                    ubicacion[i] = datos[1];
                    trabajo[i] = Double.parseDouble(datos[2]);//paras convertir los datos en double
                    dinero[i] = Double.parseDouble(datos[3]);
                    conocimiento[i] = Double.parseDouble(datos[4]);
                    tiempo[i] = Double.parseDouble(datos[5]);
                    poder[i] = Double.parseDouble(datos[6]);
                    salud[i] = Double.parseDouble(datos[7]);
                    
                    i++;
				}
			}
			sc.close();
		}
		catch(IOException e) {
			
			System.out.println("error a leer "+e.getMessage());
		}
		
		do {

			System.out.println("\n1-Visualización de datos por ubicación: ");
			System.out.println("2-Media de datos parámetro DINERO: ");
			System.out.println("3-Países con valor superior a la media en parámetro TIEMPO: ");
			System.out.println("4-Modificar valores país: ");
			System.out.println("5-Guardar datos en fichero: ");
			System.out.println("6-Países con menor igualdad: ");
			System.out.println("7-salir: \n");
			
			
			System.out.println("selecciona una opcion del 0-7: ");
			opcion = escritura.nextInt();
			
			switch(opcion) {
		
			case 1:
				visualizacion(pais,ubicacion,trabajo,dinero,conocimiento,tiempo,poder,salud);
				
				break;
				
			case 2:
				
				double Media = Dinero(dinero);
				System.out.println("la media de del parametro DINERO de los 28 paises son: "+Media);

				break;
				
			case 3:
				
				break;
				
			case 4:
				
				break;
				
			case 5:
//				creo mi procedimiento para guardar 
				boolean existe = guardarDatos(pais,ubicacion,trabajo,dinero,conocimiento,tiempo,poder,salud,file);
				break;
				
			case 6:
				
				break;
				
			case 7:
				
				System.out.println("haz salido correctamente del programa :) ");
				
				break;
			}

		}while(opcion!=7);
		
			escritura.close();
		}

	//metodo dinero 
	private static double Dinero(double dinero[]) {
		// TODO Auto-generated method stub
		
		double media,suma =0.0;
		for( int i =0; i<dinero.length;i++) {
			
			suma+=dinero[i];
		}
		media = suma/dinero.length;
		return media;
	}

	private static void visualizacion(String[] pais, String[] ubicacion, double[] trabajo, double[] dinero,
			double[] conocimiento, double[] tiempo, double[] poder, double[] salud) {
		
		Scanner escritura = new Scanner(System.in);
		
		System.out.println("introduzca la ubicación cuyos datos quiere visualizar: ");
	    String ubicacionBuscada = escritura.nextLine().trim();	//.trim para eliminar espacios. . . 	
	    
	    boolean paisExiste =false;
	    for(String ubi : ubicacion ) {
	    	if(ubi != null && ubi.trim().equalsIgnoreCase(ubicacionBuscada)) {
	    		
	    		paisExiste = true;
	    		break;
	    		
	    	}
	    }
		if(!paisExiste) {
			
			System.out.println("la ubicacion no es existente.");
			return;
		}
		 // Mostrar encabezados de la tabla
	    System.out.printf("%-12s %-12s %-8s %-8s %-12s %-8s %-8s %-8s%n",
	                     "País", "Ubicación", "Empleo", "Dinero", "Conocimiento", 
	                     "Tiempo", "Poder", "Salud");
		
		for(int i =0; i<pais.length && pais[i]!= null; i++) {
			if(ubicacion[i]!=null && ubicacion[i].trim().equalsIgnoreCase(ubicacionBuscada)) {
				System.out.printf("%-12s %-12s %-8.2f %-8.2f %-12.2f %-8.2f %-8.2f %-8.2f%n",
                        pais[i], ubicacion[i], trabajo[i], dinero[i], 
                        conocimiento[i], tiempo[i], poder[i], salud[i]);
			}
			
		}
				
	}

	private static boolean guardarDatos(String[] pais, String[] ubicacion, double[] trabajo, double[] dinero,
			double[] conocimiento, double[] tiempo, double[] poder, double[] salud, File file) {	
		
		//try-whit-resources para manejo automatioc de recursoos
		try(PrintWriter writer  = new PrintWriter(new FileWriter(file))){
		
			writer.print("pais,ubicacion,trabajo,dinero,conocimiento,tiempo,poder,salud");
			
			System.out.println(" los datos se han guardado correctamente en :"+file.getName());
			
		}catch(IOException e) {
			
			System.out.println("error al leer "+e.getMessage());
		}	
//		mi procedimiento  devolvera un valor falso si mis datos no se guardan correctamente
		return false;
		
	}
	}


