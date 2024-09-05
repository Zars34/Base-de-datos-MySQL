package com.digitalers.gestion.services;

import com.digitalers.gestion.models.Entidad;
import com.digitalers.gestion.repositories.Repositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class ServicioImp<T extends Entidad, N extends Serializable> implements Servicio<T, N>{
    protected Repositorio<T, N> repositorio;

    //Creamos un constructor en vez de @Autowired
    public ServicioImp(Repositorio<T, N> repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    @Transactional
    public List<T> findAll() throws Exception {
        try {
            return repositorio.findAll();
        } catch (Exception e) {
            throw new Exception("Error en la busqueda de todos los archivos\n\n" + e.getMessage() );
        }
    }

    @Override
    @Transactional
    public T findById(N id) throws Exception {
        try {
            Optional<T> optional = repositorio.findById(id);
            return optional.get();
        } catch (Exception e) {
            throw new Exception("Error en la busqueda del archivo\n\n" + e.getMessage() );
        }
    }

    @Override
    @Transactional
    public T save(T entidad) throws Exception {
        try {
            return repositorio.save(entidad);
        } catch (Exception e) {
            throw new Exception("Error en la carga de nuevo archivo\n\n" + e.getMessage() );
        }
    }

    @Override
    @Transactional
    public T update(T entidad, N id) throws Exception {
        try{
            Optional<T> optional = repositorio.findById(id);
            if(optional.isPresent()) {
                T ente = optional.get();
                ente = repositorio.save(entidad);
                return ente;
            } else {
                throw new Exception("Archivo no encontrado\n\n");
            }
        } catch (Exception e) {
            throw new Exception("Error en la actualizacion del archivo\n\n" + e.getMessage() );
        }
    }

    @Override
    @Transactional
    public Boolean delete(N id) throws Exception {
        try {
            if (repositorio.existsById(id)) {
                repositorio.deleteById(id);
                return Boolean.TRUE;
            } else {
                throw new Exception("Archivo no encontrado\n\n");
            }
        } catch (Exception e) {
            throw new Exception("Error en el borrado del archivo\n\n" + e.getMessage() );
        }

    }

}
