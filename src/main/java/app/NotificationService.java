package app;

public class NotificationService {
    private EmailService emailService;
    private SMS_Service smsService;
    private SocialMediaService socialMediaService;

    public NotificationService(){
        this.emailService = new EmailService();
        this.smsService = new SMS_Service();
        this.socialMediaService = new SocialMediaService();
    }

    public void notificarUsuarioCorreo(String usuario, String mensaje){
        emailService.enviarCorreo(usuario, mensaje);
    }
    public void notificarUsuarioSMS(String numero, String mensaje){
        smsService.enviarSMS(numero,mensaje);
    }
    public void notificarUsuarioSocialMedia(String redSocial, String usuario, String mensaje){
        socialMediaService.enviarMensajeRedSocial(redSocial,usuario,mensaje);
    }
}
