package Conversiones;

// Clase record para que sea mas estable pasar el Gson a la clase Convertido.

public record Conversion(
        String result,
        String base_code,
        String target_code,
        double conversion_rate,
        double conversion_result,
        String local_time_search) {
}
