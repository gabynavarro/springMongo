
package com.mongoLibreria.libreria.model.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class Base implements Serializable {
    @Id
    protected String id; 
    protected Boolean state;
    protected Boolean up;
    protected LocalDate created;
}
