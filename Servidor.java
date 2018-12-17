import java.util.*;
import java.rmi.*;


public interface Servidor extends Remote
{
    public void criaEstudante(Estudante estudante) throws RemoteException;
    
    public List<Estudante> listaEstudantes() throws RemoteException;

    public void deletarEstudante(int id) throws RemoteException;

    public void attEstudante(int id, String m, String n, String e) throws RemoteException;
    
    public Estudante searchEstudante(int id) throws RemoteException;
    

} 