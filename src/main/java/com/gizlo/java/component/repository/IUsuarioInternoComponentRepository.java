package com.gizlo.java.component.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gizlo.java.model.UsuarioInternoDocument;

@Repository
public interface IUsuarioInternoComponentRepository extends MongoRepository<UsuarioInternoDocument, Serializable>{

}
