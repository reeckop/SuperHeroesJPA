package com.mycompany.superheroesjpa;

import dao.ISuperHeroeDAO;
import dao.SuperHeroeDAO;
import entity.IdentidadSecreta;
import entity.SuperHeroe;
import entity.Universo;

/**
 *
 * @author Ricardo
 */
public class SuperHeroesJPA {
    public static void main(String[] args) {
        
        ISuperHeroeDAO dao = new SuperHeroeDAO();

        SuperHeroe spiderman = new SuperHeroe("Spiderman", Universo.MARVEL, new IdentidadSecreta("Peter Parkerr", "New York", "Fotografo"), "Sentido aracnico");
        SuperHeroe batman = new SuperHeroe("Batman", Universo.DC,  new IdentidadSecreta("Bruce Wayne", "Gotham", "Empresario"), "Soy la venganza");
        SuperHeroe goku = new SuperHeroe("Goku", Universo.INDEPENDIENTE, new IdentidadSecreta("Kakarotto", "Planeta Tierra", "Guerrero"), "Kamehameha");

        System.out.println("Insertando");
        dao.insertar(spiderman);
        dao.insertar(batman);
        dao.insertar(goku);

        System.out.println("Lista inicial");
        dao.listar().forEach(h -> System.out.println(h.getId() + ": " + h.getNombre() + " (" + h.getUniverso() + ")"));

        SuperHeroe batmanBD = dao.buscar(batman.getId());
        if (batmanBD != null) {
            batmanBD.getIdentidadSecreta().setCiudad("Ciudad Gotica");
            dao.actualizar(batmanBD);
            System.out.println("Ciudad de Batman actualizada.");
        }

        System.out.println("Lista después de modificar a Batman:");
        dao.listar().forEach(h -> System.out.println(h.getId() + ": " + h.getNombre() + " [" + h.getIdentidadSecreta().getCiudad() + "]")
        );

        System.out.println("\nEliminando a SpiderMaan");
        dao.eliminar(spiderman.getId());

        System.out.println("\nLista final");
        dao.listar().forEach(h -> 
            System.out.println(h.getId() + ": " + h.getNombre())
        );
    }
}
