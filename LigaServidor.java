import java.rmi.*;

public class LigaServidor {
    public static void main(String argv[]) {
        try {
            System.out.println("Inicilizando servidor...");
            Naming.rebind("ServidorTeste", new ImpleServ());
        } catch (Exception e) {
            System.out.println("Não foi possivel iniciar o servidor." + e.toString());
        }
    }

}