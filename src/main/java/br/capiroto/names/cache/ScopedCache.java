package br.capiroto.names.cache;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import br.capiroto.names.pojo.CapirotoNames;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ScopedCache {

	private Set<CapirotoNames> cachedNames;
	
	public ScopedCache() {
		cachedNames = new HashSet<>();
	}
	
	public void addOnCache(Set<CapirotoNames> toBeCached) {
		cachedNames.addAll(toBeCached);
	}
	
	public Set<CapirotoNames> getCache() {
		return cachedNames;
	}
	
	public void addSingleElement(CapirotoNames capirotoNames) {
		cachedNames.add(capirotoNames);
	}
	
	public boolean contains(CapirotoNames capirotoNames) {
		return cachedNames.contains(capirotoNames);
	}
}