import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de puntos que desea colocar:");
        int cantidadPuntos = scanner.nextInt();

        Grafo grafo = new Grafo();

        System.out.println("Ingrese las coordenadas de los puntos (x y):");
        for (int i = 0; i < cantidadPuntos; i++) {
            System.out.print("Punto " + (i + 1) + ":");
            System.out.print("\nX " + (i + 1) + ":");
            int x = scanner.nextInt();
            System.out.print("Y " + (i + 1) + ":");
            int y = scanner.nextInt();
            grafo.agregarPunto(new Punto(x, y));
        }

        // Calcular la distancia entre dos puntos y mostrarla
        //Punto punto1 = new Punto(0, 0);
        //Punto punto2 = new Punto(3, 4);
        //double distancia = punto1.distanciaA(punto2);
        //System.out.println("La distancia entre los puntos es: " + distancia);

        System.out.println("Conecte los puntos ingresando los numeros de los puntos que desea conectar:");
        System.out.println("Ingrese -1 para dejar de conectar puntos.");

        int puntoA, puntoB;
        do {
            System.out.println("Índice del punto A:");
            puntoA = scanner.nextInt() - 1; // Ajuste para índices de lista
            if (puntoA == -2) break; // Salir del bucle si se ingresa -1

            System.out.println("Índice del punto B:");
            puntoB = scanner.nextInt() - 1; // Ajuste para índices de lista

            grafo.conectarPuntos(puntoA, puntoB);
        } while (true);

        System.out.println("Especifique de qué punto a qué punto desea buscar la mejor ruta:");
        System.out.println("Coloque el numero de punto inicial:");
        int puntoInicial = scanner.nextInt() - 1; // Ajuste para índices de lista
        System.out.println("Coloque el numero del punto final:");
        int puntoFinal = scanner.nextInt() - 1; // Ajuste para índices de lista

        List<Punto> rutaOptima = grafo.encontrarRutaOptima(puntoInicial, puntoFinal);

        System.out.println("La ruta óptima es:");
        for (Punto punto : rutaOptima) {
            System.out.println("(" + punto.x + ", " + punto.y + ")");
        }
    }
}