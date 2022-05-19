
package com.mongoLibreria.libreria.model.Entity;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "books")
@Getter @Setter 
@Builder
public class Book extends Base {
  
 
  private String isbn; 
  @Column(unique = true, nullable = false)
  private String title;
  private Integer year;
  private Integer examples;
  private Integer borrowed_copies;
  @DBRef
  private Set<Author> author;
  @DBRef
  private Set<Editorial> editorials;
    
}
