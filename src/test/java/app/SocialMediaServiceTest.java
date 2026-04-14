package app;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class SocialMediaServiceTest {
    private final SocialMediaService socialMediaService = new SocialMediaService();
    @Test
    void debeContenerUsuarioEnSalida() {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        socialMediaService.enviarMensaje("@juan123", "Oferta especial");
        assertTrue(salida.toString().contains("@juan123"));
    }
    @Test
    void debeContenerMensajeEnSalida() {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        socialMediaService.enviarMensaje("@juan123", "¡Tienes una nueva oferta!");
        assertTrue(salida.toString().contains("¡Tienes una nueva oferta!"));
    }
    @Test
    void debeMencionarFacebook() {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        socialMediaService.enviarMensaje("@juan123", "Hola");
        assertTrue(salida.toString().contains("Facebook"));
    }
}