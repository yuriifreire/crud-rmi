import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.lang.*;


public class ImpleServ extends UnicastRemoteObject implements Servidor {

    private static final long serialVersionUID = 1L;

    public ImpleServ() throws RemoteException {
        System.out.println("Novo servidor iniciado...");
    }

    int i = 0;
    public List<Estudante> listaDeEstudantes = new ArrayList<Estudante>();
    
    @Override
    public void criaEstudante(Estudante estudante) throws RemoteException {
        estudante.setId(++i);
        listaDeEstudantes.add(estudante);
    }

    
    @Override
    public List<Estudante> listaEstudantes() throws RemoteException {
        if (!listaDeEstudantes.isEmpty()) {
            return listaDeEstudantes;
        }
        return listaDeEstudantes;
    }
    
    @Override
    public void deletarEstudante(int id) throws RemoteException {
        Estudante estudante = searchEstudante(id);
        if (estudante != null) {
            listaDeEstudantes.remove(estudante);
            estudante = null;
        }
    }

    @Override
    public void attEstudante(int id, String matricula, String nome, String endereco) throws RemoteException {
        Estudante estudante = searchEstudante(id);
        estudante.setMatricula(matricula);
        estudante.setNome(nome);
        estudante.setEndereco(endereco);
    }

    @Override
    public Estudante searchEstudante(int id) {
        Estudante estudante = null;
        for (Estudante est : listaDeEstudantes) {
            if (est.getId() == id) {
                estudante = est;
            }
        }
        return estudante;
    }

}