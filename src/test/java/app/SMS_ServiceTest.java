package app;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class SMS_ServiceTest {
    private final SMS_Service smsService = new SMS_Service();
    @Test
    void debeContenerNumeroEnSalida() {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        smsService.enviarMensaje("+593987654321", "Código: 1234");
        assertTrue(salida.toString().contains("+593987654321"));
    }
    @Test
    void debeContenerMensajeEnSalida() {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        smsService.enviarMensaje("+593987654321", "Código: 1234");
        assertTrue(salida.toString().contains("Código: 1234"));
    }
    @Test
    void debeMostrarPrefijoCorrecto() {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        smsService.enviarMensaje("+593987654321", "Hola");
        assertTrue(salida.toString().contains("Enviando SMS a"));
    }
}