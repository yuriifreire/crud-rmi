import java.rmi.*;

public class LigaServidor {
    public static void main(String argv[]) {
        try {
            System.out.println("Iniciando servidor...");
            Naming.rebind("ServidorTeste", new ImpleServ());
        } catch (Exception e) {
            System.out.println("Ocorreu um problema ao iniciar o servidor.\n" + e.toString());
        }
    }

}