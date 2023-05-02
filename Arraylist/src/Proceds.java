import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Proceds {
	ArrayList<String> nombres = new ArrayList<String>();
	ArrayList<Integer> edades = new ArrayList<Integer>();

	public void procedimiento() {
		String menu = "Estas son las diferentes opciones que tiene \n";
		menu += "1. Llenar estudiantes \n";
		menu += "2. ver promedio de edades \n";
		menu += "3. ver estudiantes con mayor y menor edad \n";
		menu += "4. ver estudiantes mayores de edad y menores de edad \n";
		menu += "5. Mostrar estudiantes \n";
		menu += "6. Buscar Estudiante\n";
		menu += "7. Salir \n";
		menu += "seleccione alguna opcion";
		int select;
		do {
			select = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (select) {
			case 1:
				llenar();
				break;
			case 2:
				if (verificar(nombres))
					promedioEdades();
				break;
			case 3:
				if (verificar(nombres))
					mayorYMenor();
				break;
			case 4:
				if (verificar(nombres))
					mayorDeEdad();
				break;
			case 5:
				if (verificar(nombres))
					Mostrar();
				break;

			case 6:
				if (verificar(nombres)) {
					BuscarEstudiante();
				}
				break;
			case 7:
				System.out.println("Gracias por usarme");
				break;
			default:
				System.out.println("ingrese una opcion de menu valida");
				break;
			}
		} while (select != 7);

	}

	public void llenar() {
		int cantidadEstudiantes = Integer
				.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes que desea ingresar"));
		for (int i = 0; i < cantidadEstudiantes; i++) {
			String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante " + (i + 1));
			nombres.add(nombre);
			int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del estudiante " + (i + 1)));
			edades.add(edad);
		}
	}

	public void promedioEdades() {
		int suma = 0;
		for (int edad : edades) {
			suma += edad;
		}
		double promedio = (double) suma / edades.size();
		JOptionPane.showMessageDialog(null, "El promedio de edades es: " + promedio);
	}

	
	public void mayorYMenor() {
		int mayor = edades.get(0);
		int menor = edades.get(0);
		for (int i = 1; i < edades.size(); i++) {
			if (edades.get(i) > mayor) {
				mayor = edades.get(i);
			}
			if (edades.get(i) < menor) {
				menor = edades.get(i);
			}
		}

		String estudiantesMayores = "";
		String estudiantesMenores = "";
		for (int i = 0; i < nombres.size(); i++) {
			if (edades.get(i) == mayor) {
				estudiantesMayores += nombres.get(i) + ", ";
			}
			if (edades.get(i) == menor) {
				estudiantesMenores += nombres.get(i) + ", ";
			}
		}

		System.out.println( "Estudiantes con mayor edad: " + estudiantesMayores+ "\nEstudiantes con menor edad: " + estudiantesMenores);
	}
	
	public void mayorDeEdad() {
	    String estudiantesMayores = "";
	    for (int i = 0; i < nombres.size(); i++) {
	        if (edades.get(i) >= 18) {
	            estudiantesMayores += nombres.get(i) + ", ";
	        }
	    }

	    String estudiantesMenores = "";
	    for (int i = 0; i < nombres.size(); i++) {
	        if (edades.get(i) < 18) {
	            estudiantesMenores += nombres.get(i) + ", ";
	        }
	    }
	    System.out.println("Estudiantes mayores de edad: " + estudiantesMayores);
	    System.out.println("Estudiantes menores de edad: " + estudiantesMenores);
	}

	public void Mostrar() {
	    System.out.println("Lista de estudiantes:");
	    for (int i = 0; i < nombres.size(); i++) {
	        System.out.println(nombres.get(i) + ", " + edades.get(i) + " años");
	    }
	}
	public void BuscarEstudiante() {
	    String opcion = JOptionPane.showInputDialog("¿Desea buscar por nombre o por edad?");
	    if (opcion.equalsIgnoreCase("nombre")) {
	        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
	        boolean encontrado = false;
	        for (int i = 0; i < nombres.size(); i++) {
	            if (nombres.get(i).equalsIgnoreCase(nombre)) {
	                System.out.println("Estudiante encontrado:");
	                System.out.println(nombres.get(i) + ", " + edades.get(i) + " años");
	                encontrado = true;
	            }
	        }
	        if (!encontrado) {
	            System.out.println("No se encontró ningún estudiante con ese nombre.");
	        }
	    } else if (opcion.equalsIgnoreCase("edad")) {
	        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del estudiante:"));
	        boolean encontrado = false;
	        for (int i = 0; i < edades.size(); i++) {
	            if (edades.get(i) == edad) {
	                System.out.println("Estudiante encontrado:");
	                System.out.println(nombres.get(i) + ", " + edades.get(i) + " años");
	                encontrado = true;
	            }
	        }
	        if (!encontrado) {
	            System.out.println("No se encontró ningún estudiante con esa edad.");
	        }
	    } else {
	        System.out.println("Opción inválida.");
	    }
	}

	public boolean verificar(ArrayList<String> nombres) {
	    if (nombres.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No hay estudiantes ingresados");
	        return false;
	    }
	    return true;
	}

}
