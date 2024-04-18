import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        var menuDeDivisas = new ConsultaApi();
        Conversiones menu = menuDeDivisas.divisa("AED");
        System.out.println("Conversor de divisas Alura\nLas divisas disponibles son: ");
        for (String div : menu.conversion_rates().keySet()){
            System.out.println(div);
        }

        Scanner scanner = new Scanner(System.in);
        String respuesta;

        do {

            try {
                var lectura = new Scanner(System.in);
                ConsultaApi consulta = new ConsultaApi();
                System.out.println("Escribe la moneda que deseas convertir: ");
                String opcion = lectura.nextLine().toUpperCase().replace(" ", "");
                Conversiones conversion = consulta.divisa(opcion);

                Map<String, Double> divisas = conversion.conversion_rates();
                if (divisas != null) {
                    System.out.println("¿A que divisa deseas convertir: ");

                    String divisacon = lectura.nextLine().toUpperCase().replace(" ", "");
                    if (divisas.containsKey(divisacon)) {
                        System.out.println("Ingrese la cantidad deseada: ");
                        Operacion operacion = new Operacion();
                        Double moneda = (double) lectura.nextInt();
                        operacion.setMoneda(moneda);
                        operacion.setDivisa(divisas.get(divisacon));

                        Double resultado = operacion.oper();
                        System.out.println(operacion.getMoneda() + " " +
                                opcion +
                                " equivalen a " +
                                resultado + " " +
                                divisacon + ".");
                    } else {
                        System.out.println("Divisa no encontrada.");
                    }
                } else {
                    System.out.println("Moneda no encontrada.");
                }
            } catch (Exception e) {
                System.out.println("Algo salio mal");
            }

            System.out.print("¿Desea hacer otra consulta? ");
            respuesta = scanner.nextLine().toLowerCase().replace(" ", "");
        } while (!respuesta.equals("no"));
        System.out.println("Gracías por usar la aplicación");
    }
}