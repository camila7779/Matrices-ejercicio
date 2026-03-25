import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int numEstudiantes = 0;
        int numMaterias = 0;
        double sumatot = 0;
        double sumaFila = 0;
        double sumaColumna = 0;
        double nota = 0;
        double promtot = 0;
        double[][] planilla;


        System.out.println("¿Cuántos estudiantes desea registrar?");
        numEstudiantes = leer.nextInt();
        System.out.println("¿Cuántas materias son?");
        numMaterias = leer.nextInt();
        planilla = new double[numEstudiantes][numMaterias];

        for (int i = 0; i < numEstudiantes; i++) {
            System.out.println("Notas para el Estudiante " + (i + 1) + ":");
            for (int j = 0; j < numMaterias; j++) {
                System.out.print("Materia " + (j + 1) + ": ");
                nota = leer.nextDouble();

                while (nota < 0 || nota > 5) {
                    System.out.println("Error. Ingrese nota de 0 a 5:");
                    nota = leer.nextDouble();
                }
                planilla[i][j] = nota;
                sumatot = sumatot + nota;
            }
        }

        System.out.println("\n--- PLANILLA DE NOTAS ---");
        for (int i = 0; i < numEstudiantes; i++) {
            for (int j = 0; j < numMaterias; j++) {
                System.out.print(planilla[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("--- PROMEDIOS POR ESTUDIANTE ---");
        for (int i = 0; i < numEstudiantes; i++) {
            sumaFila = 0;
            for (int j = 0; j < numMaterias; j++) {
                sumaFila = sumaFila + planilla[i][j];
            }
            System.out.println("Estudiante " + (i + 1) + ": " + (sumaFila / numMaterias));
        }

        System.out.println("--- PROMEDIOS POR MATERIA ---");
        for (int j = 0; j < numMaterias; j++) {
            sumaColumna = 0;
            for (int i = 0; i < numEstudiantes; i++) {
                sumaColumna = sumaColumna + planilla[i][j];
            }
            System.out.println("Materia " + (j + 1) + ": " + (sumaColumna / numEstudiantes));
        }

        promtot = sumatot / (numEstudiantes * numMaterias);
        System.out.println("El promedio total es: " + promtot);
    }
}