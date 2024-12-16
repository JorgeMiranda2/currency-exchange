
import Dtos.Exchange;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean working = true;
        APIConnection apiConnection = new APIConnection();
        Gson gson = new Gson();



        // Crear el mapa para las combinaciones de divisas
        Map<Integer, String[]> currencyMap = new HashMap<>();
        currencyMap.put(1, new String[]{"USD", "ARS"});
        currencyMap.put(2, new String[]{"ARS", "USD"});
        currencyMap.put(3, new String[]{"USD", "BRL"});
        currencyMap.put(4, new String[]{"BRL", "USD"});
        currencyMap.put(5, new String[]{"USD", "COP"});
        currencyMap.put(6, new String[]{"COP", "USD"});

        // Instanciar el Scanner una vez
        Scanner scanner = new Scanner(System.in);

        while (working) {
            System.out.println(
                    """
                    ***********************************
                    Bienvenido al conversor de moneda
                    Opciones:
                    1) Dolar --> Peso argentino
                    2) Peso argentino --> Dolar
                    3) Dolar --> Real Brasileño
                    4) Real brasileño --> Dolar
                    5) Dolar --> Peso Colombiano
                    6) Peso colombiano --> Dolar
                    7) Salir
                    ***********************************
                    
                    """
            );

            int num = scanner.nextInt();

            System.out.println("Ahora digite la cantidad a ser convertida: ");

            double amount = scanner.nextDouble();

            // Comprobar si es la opción de salir
            if (num == 7) {
                working = false;
                System.out.println("Saliendo del programa...");
                break;
            }

            // Verificar si la opción seleccionada es válida
            if (currencyMap.containsKey(num)) {
                String[] currencies = currencyMap.get(num);
                String result = apiConnection.getExchangeRate(currencies[0], currencies[1]);

                Exchange exchange = gson.fromJson(result, Exchange.class);
                double conversionResult = (double) exchange.getConversion_rate() * amount;

                System.out.println("Tasa de cambio: " + exchange.getConversion_rate());
                System.out.println("La conversion de " + amount + " ["+currencies[0]+"] " + "a " + "["+currencies[1]+"] " + "es: "
                        + (double)Math.round(conversionResult * 1000d) / 1000d);


            } else {
                System.out.println("Opción incorrecta, vuelva a intentar");
            }
        }

        // Cerrar el scanner después del uso
        scanner.close();
    }
}
