package br.capiroto.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/")
public class CapirotoWebController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index.html";
	}
}
