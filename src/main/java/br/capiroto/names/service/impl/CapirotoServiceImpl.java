package br.capiroto.names.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.capiroto.names.dao.CapirotoDAO;
import br.capiroto.names.pojo.CapirotoNames;
import br.capiroto.names.service.CapirotoService;

@Service
public class CapirotoServiceImpl implements CapirotoService {

	@Autowired
	private CapirotoDAO capirotoDAO;

	@Override
	public Set<CapirotoNames> findAll() {
		return new HashSet<CapirotoNames>(capirotoDAO.findAll());
	}

	@Override
	public Set<CapirotoNames> findByNome(String nome) {
		return capirotoDAO.findByNomeIgnoreCase(nome);
	}

	@Override
	public CapirotoNames save(CapirotoNames capirotoNames) {
		Set<CapirotoNames> findByNome = this.findByNome(capirotoNames.getNome());
		if (findByNome.isEmpty()) {
			return capirotoDAO.save(capirotoNames);
		}
		return findByNome.iterator().next();
	}

	@Override
	public List<CapirotoNames> findAllList() {
		return capirotoDAO.findAll();
	}

	@Override
	public CapirotoNames getRandomName() {
		CapirotoNames capirotoNames = new CapirotoNames();
		List<CapirotoNames> findAllList = this.findAllList();
		if (findAllList.isEmpty()) {
			return capirotoNames;
		}
		capirotoNames = findAllList.get(ThreadLocalRandom.current().nextInt(0, findAllList.size()));
		return capirotoNames;
	}
	
	@Override
	public void deleteRow(CapirotoNames capirotoNames) {
		capirotoDAO.delete(capirotoNames);
	}
}
