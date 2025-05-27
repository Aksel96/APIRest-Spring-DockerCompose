package mx.unam.aragon.ico.is.videojuegos.reporsitories;

import mx.unam.aragon.ico.is.videojuegos.entities.Videojuego;
import org.springframework.data.repository.CrudRepository;

public interface VideojuegoRepository extends CrudRepository<Videojuego, Long> {
    public Videojuego findVideojuegoById(Long id);
    public int deleteVideojuegoById(Long id);
}
