public class Punto {
    int x, y;

    Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Esta distancia me va servir para poder tener el peso de la arista
    double distanciaA(Punto otroPunto) {
        return Math.sqrt(Math.pow(this.x - otroPunto.x, 2) + Math.pow(this.y - otroPunto.y, 2));
    }
}
