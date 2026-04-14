package app;

public class EmailService implements MessageService {

    @Override
    public void enviarMensaje(String destinatario, String mensaje) {
        System.out.println("Enviando correo a " + destinatario + " : " + mensaje);
    }
}
