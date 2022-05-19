
package com.mongoLibreria.libreria.repository;

import com.mongoLibreria.libreria.model.Entity.Base;
import java.io.Serializable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
//base all Entities, can't create instances
public interface BaseRepository <E extends Base, ID extends Serializable> extends MongoRepository<E, ID>{
    //<E extends BaseRepository, ID extends Serializable>  type to receive


}