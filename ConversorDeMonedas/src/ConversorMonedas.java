import java.util.Scanner;

public class ConversorMonedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            // Mostrar las opciones de monedas disponibles
            System.out.println("Bienvenido al Conversor de Monedas");
            System.out.println("Seleccione la moneda de origen:");
            System.out.println("1. Dolares");
            System.out.println("2. Lempiras");
            System.out.println("3. Pesos Mexicanos");
            System.out.println("4. Reales Brasileños");
            System.out.println("5. Euros");
            System.out.println("6. Libras Esterlinas");
            System.out.println("7. Yuan");
            System.out.println("8. Yenes");
            System.out.print("Ingrese el número de la moneda que desea convertir: ");
            int monedaOrigen = scanner.nextInt();

            System.out.println("Seleccione la moneda de destino:");
            System.out.println("1. Dólares");
            System.out.println("2. Lempiras");
            System.out.println("3. Pesos Mexicanos");
            System.out.println("4. Reales Brasileños");
            System.out.println("5. Euros");
            System.out.println("6. Libras Esterlinas");
            System.out.println("7. Yuan");
            System.out.println("8. Yenes");
            System.out.print("Ingrese el número de la moneda al que desea convertir su dinero: ");
            int monedaDestino = scanner.nextInt();

            // Ingresar la cantidad a convertir
            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();

            // Realizar la conversión
            double resultado = convertirMoneda(monedaOrigen, monedaDestino, cantidad);

            // Mostrar el resultado
            System.out.println("El resultado de la conversión es: " + resultado);

            // Preguntar al usuario si desea hacer otra conversión
            System.out.print("¿Desea realizar otra conversión? (si/no): ");
            String respuesta = scanner.next();

            if (respuesta.equalsIgnoreCase("no")) {
                continuar = false;
            }
        }

        System.out.println("Gracias por usar el Conversor de Monedas. ¡Hasta luego!");
    }

    public static double convertirMoneda(int monedaOrigen, int monedaDestino, double cantidad) {

        // Definir las tasas de cambio para cada par de monedas

        double[][] tasasDeCambio = {
                // Dólares, Lempiras, Pesos Mexicanos, Reales Brasileños, Euros, Libras Esterlinas, Yuan, Yenes
                {1, 24.50, 20.50, 5.08, 0.85, 0.72, 6.36, 110.48}, // Dólares
                {0.041, 1, 0.83, 0.21, 0.035, 0.03, 0.26, 4.47},   // Lempiras
                {0.049, 1.21, 1, 0.25, 0.042, 0.036, 0.31, 5.37},  // Pesos Mexicanos
                {0.197, 4.89, 4, 1, 0.17, 0.15, 1.30, 22.43},      // Reales Brasileños
                {1.18, 29.39, 24.46, 6.06, 1, 0.85, 7.50, 129.65}, // Euros
                {1.38, 34.21, 28.45, 7.04, 1.18, 1, 8.76, 151.49}, // Libras Esterlinas
                {0.16, 3.95, 3.28, 0.81, 0.13, 0.11, 1, 17.25},    // Yuan
                {0.009, 0.21, 0.18, 0.045, 0.008, 0.007, 0.058, 1} // Yenes
        };

        // Obtener la tasa de cambio para el par de monedas seleccionado
        double tasaDeCambio = tasasDeCambio[monedaOrigen - 1][monedaDestino - 1];

        // Calcular el resultado de la conversión
        double resultado = cantidad * tasaDeCambio;
        return resultado;
    }
}