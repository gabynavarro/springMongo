
package com.mongoLibreria.libreria.service.impl;

import com.mongoLibreria.libreria.model.Entity.Base;
import com.mongoLibreria.libreria.repository.BaseRepository;
import com.mongoLibreria.libreria.service.BaseService;
import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {
     
    protected BaseRepository<E,ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }    

    
    @Override
    public List<E> findAll() throws Exception {
        try {
            List<E> entities=baseRepository.findAll();
            //DTO
            return entities; //return DTO
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public E findById(ID id) throws Exception {
        try {
          E entity =baseRepository.findById(id).orElseThrow();
        //DTO
        return entity;
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }    
     
    }

    @Override
    public E save(E entity) throws Exception {
        try {
            entity=baseRepository.save(entity);
            //DTO
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public E update(ID id, E entity) throws Exception {
        try {         
         E enti =baseRepository.findById(id).orElseThrow();  
         //DTO
          enti=baseRepository.save(entity);         
         return  enti;
     
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(ID id) throws Exception {
        try {
            if (baseRepository.existsById(id)){ baseRepository.deleteById(id); return true;}
            else { throw new Exception("does not exist ID!");}
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
  }
    
}
