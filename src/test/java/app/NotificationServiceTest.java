package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class NotificationServiceTest {
    private MessageService emailMock;
    private MessageService smsMock;
    private SocialMediaService socialMediaMock;
    private NotificationService notificationService;
    @BeforeEach
    void setUp() {
        emailMock       = mock(MessageService.class);
        smsMock         = mock(MessageService.class);
        socialMediaMock = mock(SocialMediaService.class);

        notificationService = new NotificationService(
                emailMock,
                smsMock,
                socialMediaMock
        );
    }
    // Email
    @Test
    void debeNotificarPorCorreo() {
        notificationService.notificarUsuarioCorreo("juan@email.com", "Tu pedido fue confirmado.");
        verify(emailMock, times(1))
                .enviarMensaje("juan@email.com", "Tu pedido fue confirmado.");
    }
    //  SMS
    @Test
    void debeNotificarPorSMS() {
        notificationService.notificarUsuarioSMS("+593987654321", "Tu código es 1234.");

        verify(smsMock, times(1))
                .enviarMensaje("+593987654321", "Tu código es 1234.");
    }
    //  Redes sociales
    @Test
    void debeNotificarPorSocialMedia() {
        notificationService.notificarUsuarioSocialMedia("@juan123", "¡Tienes una nueva oferta!");
        verify(socialMediaMock, times(1))
                .enviarMensaje("@juan123", "¡Tienes una nueva oferta!");
    }
    //  El correo NO debe usar el servicio SMS
    @Test
    void correoNoDebeUsarSMS() {
        notificationService.notificarUsuarioCorreo("juan@email.com", "Hola");
        verify(smsMock, never()).enviarMensaje(anyString(), anyString());
    }
    //  El SMS NO debe usar el servicio de correo
    @Test
    void smsNoDebeUsarCorreo() {
        notificationService.notificarUsuarioSMS("+593987654321", "Hola");
        verify(emailMock, never()).enviarMensaje(anyString(), anyString());
    }
    // Redes sociales NO debe usar correo ni SMS
    @Test
    void socialMediaNoDebeUsarOtrosServicios() {
        notificationService.notificarUsuarioSocialMedia("@juan123", "Hola");

        verify(emailMock, never()).enviarMensaje(anyString(), anyString());
        verify(smsMock, never()).enviarMensaje(anyString(), anyString());
    }
    //  Cada servicio se llama exactamente una vez
    @Test
    void cadaServicioSeUsaSoloUnaVez() {
        notificationService.notificarUsuarioCorreo("juan@email.com", "Hola");
        notificationService.notificarUsuarioSMS("+593987654321", "Hola");
        notificationService.notificarUsuarioSocialMedia("@juan123", "Hola");
        verify(emailMock, times(1)).enviarMensaje(anyString(), anyString());
        verify(smsMock,  times(1)).enviarMensaje(anyString(), anyString());
        verify(socialMediaMock, times(1)).enviarMensaje(anyString(), anyString());
    }
}