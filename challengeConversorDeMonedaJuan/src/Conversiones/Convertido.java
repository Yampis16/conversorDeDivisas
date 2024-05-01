package Conversiones;

// Clase del resultado de la conversion con las variables ya establecidas y la sobreescritura del metodo ToString.

public class Convertido {
    public String result;
    public String base_code;
    public String target_code;
    public double conversion_rate;
    public double conversion_result;
    public String local_date = " ";

    public Convertido(Conversion jsonConvertido) {
        this.result = jsonConvertido.result();
        this.base_code = jsonConvertido.base_code();
        this.target_code = jsonConvertido.target_code();
        this.conversion_rate = jsonConvertido.conversion_rate();
        this.conversion_result = jsonConvertido.conversion_result();
    }

    @Override
    public String toString() {
        return  "\n { Resultado de la conversión='" + result + '\'' +
                "\n Moneda base='" + base_code + '\'' +
                "\n Moneda objetivo='" + target_code + '\'' +
                "\n Tasa de conversión=" + conversion_rate +
                "\n Resultado de la conversión=" + conversion_result +
                "\n Hora de conversión=" + local_date + "} \n";
    }
}
