package util;
import jakarta.persistence.*;

/**
 *
 * @author Ricardo
 */
public class JpaUtil {
    private static final String PERSISTENCE_UNIT = "SuperHeroesPU";
    private static EntityManagerFactory emf;

    private JpaUtil() {}

    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return emf.createEntityManager();
    }
}