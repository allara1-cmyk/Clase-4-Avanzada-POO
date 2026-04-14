package app;

public class SMS_Service implements MessageService {

    @Override
    public void enviarMensaje(String destinatario, String mensaje) {
        System.out.println("Enviando SMS a " + destinatario + " : " + mensaje);
    }
}
