package br.capiroto.names.dao;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.capiroto.names.pojo.CapirotoNames;

public interface CapirotoDAO extends MongoRepository<CapirotoNames, String> {

	Set<CapirotoNames> findByNomeIgnoreCase(String nome);
}
