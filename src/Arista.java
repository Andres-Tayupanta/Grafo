public class Arista {
    Punto puntoInicio, puntoFin;
    double peso;

    Arista(Punto puntoInicio, Punto puntoFin) {
        this.puntoInicio = puntoInicio;
        this.puntoFin = puntoFin;
        this.peso = puntoInicio.distanciaA(puntoFin);
    }
}
