import java.util.*;
public class Grafo {
    List<Punto> puntos;
    List<Arista> aristas;

    Grafo() {
        puntos = new ArrayList<>();
        aristas = new ArrayList<>();
    }

    void agregarPunto(Punto punto) {
        puntos.add(punto);
    }

    void conectarPuntos(int indicePuntoA, int indicePuntoB) {
        Punto puntoA = puntos.get(indicePuntoA);
        Punto puntoB = puntos.get(indicePuntoB);
        aristas.add(new Arista(puntoA, puntoB));
        aristas.add(new Arista(puntoB, puntoA)); // Añadir la arista en ambas direcciones
    }

    List<Punto> encontrarRutaOptima(int puntoInicial, int puntoFinal) {
        Map<Punto, Double> distancia = new HashMap<>();
        Map<Punto, Punto> previo = new HashMap<>();
        PriorityQueue<Punto> colaPrioridad = new PriorityQueue<>(Comparator.comparingDouble(distancia::get));

        // Inicializar las distancias a infinito y el punto previo a nulo
        for (Punto punto : puntos) {
            distancia.put(punto, Double.POSITIVE_INFINITY);
            previo.put(punto, null);
        }

        // Establezco la distancia del punto inicial a 0 y lo agrego a la cola de prioridad
        Punto puntoInicialObj = puntos.get(puntoInicial);
        distancia.put(puntoInicialObj, 0.0);
        colaPrioridad.add(puntoInicialObj);

        // Algoritmo de Dijkstra
        while (!colaPrioridad.isEmpty()) {
            Punto puntoActual = colaPrioridad.poll();
            for (Arista arista : aristas) {
                if (arista.puntoInicio.equals(puntoActual)) {
                    Punto puntoVecino = arista.puntoFin;
                    double pesoTotal = distancia.get(puntoActual) + arista.peso;
                    if (pesoTotal < distancia.get(puntoVecino)) {
                        distancia.put(puntoVecino, pesoTotal);
                        previo.put(puntoVecino, puntoActual);
                        colaPrioridad.add(puntoVecino);
                    }
                }
            }
        }

        // Reconstruir la ruta óptima desde el punto final
        List<Punto> rutaOptima = new ArrayList<>();
        Punto puntoFinalObj = puntos.get(puntoFinal);
        while (previo.get(puntoFinalObj) != null) {
            rutaOptima.add(puntoFinalObj);
            puntoFinalObj = previo.get(puntoFinalObj);
        }
        rutaOptima.add(puntoInicialObj);
        Collections.reverse(rutaOptima);
        return rutaOptima;
    }
}


