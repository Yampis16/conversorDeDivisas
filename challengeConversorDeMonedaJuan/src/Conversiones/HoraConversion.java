package Conversiones;

import java.time.LocalDateTime;

public class HoraConversion {
    // metodo para conseguir la hora de una conversión.

    public static String horaConversion(LocalDateTime localDateTime) {
        int hours  = localDateTime.getHour();
        int minutes = localDateTime.getMinute();
        int seconds = localDateTime.getSecond();
        return  " " + hours + ":"+ minutes +":"+seconds;
    }
}
