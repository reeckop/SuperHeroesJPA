package dao;

import entity.SuperHeroe;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public interface ISuperHeroeDAO {
    void insertar(SuperHeroe e);
    void actualizar(SuperHeroe e);
    void eliminar(Long id);
    SuperHeroe buscar(Long id);
    List<SuperHeroe> listar();
}