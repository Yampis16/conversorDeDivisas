package Main;

import Conversiones.ConversorDeDivisas;
import Conversiones.Convertido;
import Conversiones.HoraConversion;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Conversor de monedas by Juan Mendoza
        // pagina principal

        //llamada al metodo Scanner para que el usuario interactue.
        Scanner scan = new Scanner(System.in);
        int exit = 0;
        List<Convertido> historialDeConversiones = new java.util.ArrayList<>(List.of());

        // Inicio del while para la intercaccion.

        while(exit != 7) {
            System.out.println("""
                    *********************************************
                    Sea bienvenido/a al conversor de Moneda =]
                    
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dolar
                    3) Dólar =>> Real brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Salir
                    
                    Elija una opción válida:
                    *********************************************
                    """);

            // Opiones de elección.

            switch (scan.nextInt()){
                case 1:
                    try {
                        System.out.println("""
                                Ingrese el monto a convertir:
                                """);

                        var montoAConvertir = scan.nextDouble();
                        Convertido dolarAPesoArgentino = new Convertido(ConversorDeDivisas.convierteDivisas("USD", "ARS", montoAConvertir));
                        System.out.println(montoAConvertir + " Dolares equivalen a:" + dolarAPesoArgentino.conversion_result + " Pesos Argentinos");
                        dolarAPesoArgentino.local_date = HoraConversion.horaConversion(LocalDateTime.now());
                        historialDeConversiones.add(dolarAPesoArgentino);
                        break;
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                case 2:
                    try {
                        System.out.println("""
                                Ingrese el monto a convertir:
                                """);

                        var montoAConvertir = scan.nextDouble();
                        Convertido pesoArgentinoADolar = new Convertido(ConversorDeDivisas.convierteDivisas("ARS", "USD", montoAConvertir));
                        System.out.println(montoAConvertir + " Pesos argentinos equivalen a:" + pesoArgentinoADolar.conversion_result + " Dolares");
                        pesoArgentinoADolar.local_date = HoraConversion.horaConversion(LocalDateTime.now());
                        historialDeConversiones.add(pesoArgentinoADolar);
                        break;
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                case 3:
                    try {
                        System.out.println("""
                                Ingrese el monto a convertir:
                                """);

                        var montoAConvertir = scan.nextDouble();
                        Convertido dolarARealBrasileno = new Convertido(ConversorDeDivisas.convierteDivisas("USD", "BRL", montoAConvertir));
                        System.out.println(montoAConvertir + " Dolares equivalen a:" + dolarARealBrasileno.conversion_result + " Reales brasileños");
                        dolarARealBrasileno.local_date = HoraConversion.horaConversion(LocalDateTime.now());
                        historialDeConversiones.add(dolarARealBrasileno);
                        break;
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                case 4:
                    try {
                        System.out.println("""
                                Ingrese el monto a convertir:
                                """);

                        var montoAConvertir = scan.nextDouble();
                        Convertido realBrasilenoADolar = new Convertido(ConversorDeDivisas.convierteDivisas("BRL", "USD", montoAConvertir));
                        System.out.println(montoAConvertir + " Reales brasileños equivalen a:" + realBrasilenoADolar.conversion_result + " Dolares");
                        realBrasilenoADolar.local_date = HoraConversion.horaConversion(LocalDateTime.now());
                        historialDeConversiones.add(realBrasilenoADolar);
                        break;
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                case 5:
                    try {
                        System.out.println("""
                                Ingrese el monto a convertir:
                                """);

                        var montoAConvertir = scan.nextDouble();
                        Convertido dolarAPesoColombiano = new Convertido(ConversorDeDivisas.convierteDivisas("USD", "COP", montoAConvertir));
                        System.out.println(montoAConvertir + " Dolares equivalen a:" + dolarAPesoColombiano.conversion_result + " Pesos colombianos");
                        dolarAPesoColombiano.local_date = HoraConversion.horaConversion(LocalDateTime.now());
                        historialDeConversiones.add(dolarAPesoColombiano);
                        break;
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                case 6:
                    try {
                        System.out.println("""
                                Ingrese el monto a convertir:
                                """);

                        var montoAConvertir = scan.nextDouble();
                        Convertido pesoColombianoADolar = new Convertido(ConversorDeDivisas.convierteDivisas("COP", "USD", montoAConvertir));
                        System.out.println(montoAConvertir + " Pesos colombianos equivalen a:" + pesoColombianoADolar.conversion_result + " Dolares");
                        pesoColombianoADolar.local_date = HoraConversion.horaConversion(LocalDateTime.now());
                        historialDeConversiones.add(pesoColombianoADolar);
                        break;
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                case 7:
                    exit = 7;
                    break;
                default:
                    System.out.println("La opción ingresada no se encuentra, por favor ingrese una opción valida");
            }
        }

        // Mostrar historial.

        System.out.println("""
                *********************************************
                Desea ver el historial de conversiones?
                
                1) Si
                2) No
                
                """);

        var mostrarHistorial = scan.nextInt();

        switch (mostrarHistorial) {
            case 1:
                System.out.println("Historial de conversiones \n" + historialDeConversiones);
                break;
            case 2:
                System.out.println("No se mostrará el historial");
                break;
            default:
                System.out.println("La opción ingresada no se encuentra, no se mostrará el historial");
        }
        System.out.println("Ha finalizado la aplicación");
    }
}
