
package com.mongoLibreria.libreria.model.Entity;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "books")
@Data
public class Book implements Serializable {
  
 
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid",strategy = "uuid2")
  private String id;
  private String isbn; 
  @Column(unique = true, nullable = false)
  private String titulo;
  private Integer anio;
  private Integer ejemplares;
  private Integer ejemplaresPrestados;
  private boolean alta;
  @DBRef
  private Set<Author> author;
  @DBRef
  private Set<Editorial> editorials;
  private Integer ejemplaresRestantes;



  
    
}
