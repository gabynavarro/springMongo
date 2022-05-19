
package com.mongoLibreria.libreria.model.Entity;

import javax.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "authors")
@Getter @Setter
@Builder
 public class Author extends Base{ 
    @Column(unique = true, nullable = false) //campo obligaotrio
    private String nombre;
}
