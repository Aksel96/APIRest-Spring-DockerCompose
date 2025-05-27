package mx.unam.aragon.ico.is.videojuegos.services;

import mx.unam.aragon.ico.is.videojuegos.entities.Videojuego;
import mx.unam.aragon.ico.is.videojuegos.reporsitories.VideojuegoRepository;
import mx.unam.aragon.ico.is.videojuegos.services.interfaces.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class VideojuegoServiceImpl implements VideojuegoService {
    @Autowired
    private VideojuegoRepository videojuegoRepository;

    @Override
    public Optional<Videojuego> buscarPorId(Long id) {
        return videojuegoRepository.findById(id);
    }

    @Override
    public Iterable<Videojuego> listar() {
        return videojuegoRepository.findAll();
    }

    @Override
    public Videojuego crear(Videojuego videojuego) {
        return videojuegoRepository.save(videojuego);
    }

    @Override
    public Videojuego actualizar(Long id,Videojuego videojuego) {
        Optional<Videojuego> videojuegoActual = videojuegoRepository.findById(id);
        if (videojuegoActual.isPresent()) {
            Videojuego videojuegoActualAux = videojuegoActual.get();
            videojuegoActualAux.setNombre(videojuego.getNombre());
            videojuegoActualAux.setGenero(videojuego.getGenero());
            videojuegoActualAux.setPortada(videojuego.getPortada());
            videojuegoActualAux.setPrecio(videojuego.getPrecio());
            return videojuegoRepository.save(videojuegoActualAux) ;
        } else{
            return null;
        }
    }

    @Override
    public int eliminar(Long id) {
        return videojuegoRepository.deleteVideojuegoById(id);
    }

}
