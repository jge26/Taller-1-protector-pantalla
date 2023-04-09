import java.awt.*;

/**
 * Codigo que representa un protector
 * de pantalla
 *
 * @author Joaquin Galindo Egana
 */

public class Main {
        public static void main(String[] args) {

                //Crea el tamanio del lienzo
                double min = -1.0;
                double max = 1.0;

                //Crea la escala del lienzo del dibujo
                StdDraw.setXscale(min, max);
                StdDraw.setYscale(min, max);

                //Evita el parpadeo de la pantalla
                StdDraw.enableDoubleBuffering();

                //Numeros de lineas que van a revotar
                int numeroLineas = 6;

                //Vectores movimiento y velocidad de las lineas
                double[][] posicionLineas = posicionInicialLineas(numeroLineas, min, max);
                double[][] velocidadLineas = velocidadInicialLineas();
                double radioLinea = 0.02;

            Color[] colores = {Color.BLACK, Color.RED, Color.BLUE, Color.CYAN, Color.ORANGE, Color.LIGHT_GRAY, Color.darkGray, Color.PINK, Color.GREEN};

                while (true) {

                                //Cuando choque reboten
                                if (Math.abs(posicionLineas[0][0] + velocidadLineas [0][0]) > max - 0.02) {
                                    velocidadLineas [0][0] *= -1;
                                }
                                if (Math.abs(posicionLineas[1][0] + velocidadLineas [1][0]) > max - 0.02) {
                                velocidadLineas [1][0] *= -1;
                                }
                                if (Math.abs(posicionLineas[2][0] + velocidadLineas [2][0]) > max - 0.02) {
                                velocidadLineas [2][0] *= -1;
                                }
                                if (Math.abs(posicionLineas[3][0] + velocidadLineas [3][0]) > max - 0.02) {
                                velocidadLineas [3][0] *= -1;
                                }

                                //Ciclo para que las lineas se sigan entre si
                                for (int i = posicionLineas[0].length -1; i > 0; i--) {
                                    posicionLineas[0][i] = posicionLineas [0][i-1];
                                    posicionLineas[1][i] = posicionLineas [1][i-1];
                                    posicionLineas[2][i] = posicionLineas [2][i-1];
                                    posicionLineas[3][i] = posicionLineas [3][i-1];
                                }

                                    posicionLineas[0][0] += velocidadLineas[0][0];
                                    posicionLineas[1][0] += velocidadLineas[1][0];
                                    posicionLineas[2][0] += velocidadLineas[2][0];
                                    posicionLineas[3][0] += velocidadLineas[3][0];

                                StdDraw.clear();

                                //Ciclo para que le de color a las lineas
                                for (int i = 0; i < posicionLineas[0].length; i++) {
                                    StdDraw.setPenColor(colores[i]);
                                    StdDraw.filledSquare(posicionLineas[0][i],posicionLineas[1][i],radioLinea);
                                    StdDraw.filledSquare(posicionLineas[2][i],posicionLineas[3][i],radioLinea);
                                    StdDraw.line(posicionLineas[0][i],posicionLineas[1][i],posicionLineas[2][i],posicionLineas[3][i]);
                                }
                                StdDraw.show();
                                StdDraw.pause(50);

                        }
        }
        public static double[][] posicionInicialLineas(int numeroLineas, double min, double max) {

                double[][] posicionLineas = new double[4][numeroLineas];

                //Posicion inicial
                double x = min + (max - min) * Math.random();
                double y = min + (max - min) * Math.random();
                double x1 = min + (max - min) * Math.random();
                double y1 = min + (max - min) * Math.random();

                for (int i = 0; i < numeroLineas; i++) {
                    posicionLineas[0][i] = x;
                    posicionLineas[1][i] = y;
                    posicionLineas[2][i] = x1;
                    posicionLineas[3][i] = y1;
                }
        return posicionLineas;
    }

    public static double[][] velocidadInicialLineas() {

            //Velocidad aleatoria
            double velocidadX = Math.random();
            double velocidadY = Math.random();

            double[][] velocidadLineas = new double[4][2];
            velocidadLineas[0][0] = velocidadX;
            velocidadLineas[1][0] = velocidadY;
            velocidadLineas[2][0] = velocidadX;
            velocidadLineas[3][0] = velocidadY;

        return velocidadLineas;
    }
}

