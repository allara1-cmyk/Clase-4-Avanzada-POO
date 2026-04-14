package app;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class EmailServiceTest {
    private final EmailService emailService = new EmailService();
    @Test
    void debeContenerDestinatarioEnSalida() {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        emailService.enviarMensaje("juan@email.com", "Hola");
        assertTrue(salida.toString().contains("juan@email.com"));
    }
    @Test
    void debeContenerMensajeEnSalida() {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        emailService.enviarMensaje("juan@email.com", "Tu pedido fue confirmado.");
        assertTrue(salida.toString().contains("Tu pedido fue confirmado."));
    }
    @Test
    void debeMostrarPrefijoCorrecto() {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        emailService.enviarMensaje("juan@email.com", "Hola");
        assertTrue(salida.toString().contains("Enviando correo a"));
    }
}