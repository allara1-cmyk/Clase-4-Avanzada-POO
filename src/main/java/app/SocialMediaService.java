package app;

public class SocialMediaService implements MessageService {

    @Override
    public void enviarMensaje(String destinatario, String mensaje) {
        System.out.println("Enviando mensaje por Facebook" + " a " + destinatario + " : " + mensaje);
    }
}
