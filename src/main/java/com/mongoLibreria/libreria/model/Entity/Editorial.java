package com.mongoLibreria.libreria.model.Entity;

import javax.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "editorials")
@Getter @Setter
@Builder
public class Editorial extends Base {
 
    @Column(unique = true)
    private String name_editorial;


}
