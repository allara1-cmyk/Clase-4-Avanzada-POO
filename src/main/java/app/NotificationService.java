package app;

public class NotificationService {
    private EmailService emailService;

    public NotificationService(){
        this.emailService = new EmailService();
    }

    public void notificarUsuario(String usuario, String mensaje){
        emailService.enviarCorreo(usuario, mensaje);
    }
}
