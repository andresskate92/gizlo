package com.gizlo.java.component.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gizlo.java.model.UsuarioExternoDocument;

@Repository
public interface IUsuarioExternoComponentRepository extends MongoRepository<UsuarioExternoDocument, Serializable>{

}
