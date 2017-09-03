package br.capiroto.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.capiroto.names.pojo.CapirotoNames;
import br.capiroto.names.service.CapirotoService;

@RestController
@RequestMapping("/api/capiroto")
public class CapirotoRestController {

	@Autowired
	private CapirotoService capirotoService;

	@RequestMapping(method = RequestMethod.GET, params = { "type" })
	public @ResponseBody List<CapirotoNames> getRandomName(String type) {
		List<CapirotoNames> result = new ArrayList<>();
		if ("many".equals(type)) {
			result = capirotoService.findAllList();
		} else {
			result.add(capirotoService.getRandomName());
		}
		return result;
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody CapirotoNames saveNewName(@RequestBody CapirotoNames capirotoNames) {
		return capirotoService.save(capirotoNames);
	}

	@RequestMapping(method = RequestMethod.DELETE, params = { "id", "nome" })
	public void deleteRow(String id, String nome) {
		CapirotoNames capirotoNames = new CapirotoNames();
		capirotoNames.setId(id);
		capirotoNames.setNome(nome);
		capirotoService.deleteRow(capirotoNames);
	}
}
