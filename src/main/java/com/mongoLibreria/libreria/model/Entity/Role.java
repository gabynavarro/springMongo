package com.mongoLibreria.libreria.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
  @Id
  private String id;

  private ERole name;

 
}
