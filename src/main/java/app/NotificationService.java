package app;

public class NotificationService {
    private MessageService emailService;
    private MessageService smsService;
    private SocialMediaService socialMediaService;

    public NotificationService(MessageService emailService,
                               MessageService smsService,
                               SocialMediaService socialMediaService) {
        this.emailService = emailService;
        this.smsService = smsService;
        this.socialMediaService = socialMediaService;
    }

    public void notificarUsuarioCorreo(String usuario, String mensaje) {
        emailService.enviarMensaje(usuario, mensaje);
    }

    public void notificarUsuarioSMS(String numero, String mensaje) {
        smsService.enviarMensaje(numero, mensaje);
    }

    public void notificarUsuarioSocialMedia(String usuario, String mensaje) {
        socialMediaService.enviarMensaje(usuario, mensaje);
    }
}
