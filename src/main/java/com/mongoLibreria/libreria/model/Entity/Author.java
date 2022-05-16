
package com.mongoLibreria.libreria.model.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "authors")
@Data
 public class Author{ 
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String id;
    @Column(unique = true, nullable = false) //campo obligaotrio
    private String nombre;
    private Boolean alta;

  
}
