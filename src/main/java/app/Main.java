package app;

public class Main {
    public static void main(String[] args) {
        NotificationService notificacion = new NotificationService(
                new EmailService(),
                new SMS_Service(),
                new SocialMediaService()
        );
        notificacion.notificarUsuarioCorreo("juan@email.com", "Tu pedido fue confirmado.");
        notificacion.notificarUsuarioSMS("+593987654321", "Tu código es 1234.");
        notificacion.notificarUsuarioSocialMedia("@juan123", "¡Tienes una nueva oferta!");
    }
}
