
package com.mongoLibreria.libreria.model.Entity;

import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "authors")
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
 public class Author extends Base{ 
    @Column(unique = true, nullable = false) //campo obligaotrio
    private String nombre;
}
