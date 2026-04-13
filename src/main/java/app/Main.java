package app;

public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        service.notificarUsuarioCorreo("JuanChotaCorta@gmail.com","Hola Mundo");
        service.notificarUsuarioSMS("0991986703", "Hola Mundo");
        service.notificarUsuarioSocialMedia("Facebook","anderson-Lr", "Hola Mundo");
    }
}
