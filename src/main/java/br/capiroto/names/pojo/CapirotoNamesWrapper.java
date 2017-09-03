package br.capiroto.names.pojo;

import java.util.Set;

public class CapirotoNamesWrapper {
	private Set<CapirotoNames> capirotoNamesCollection;

	public CapirotoNamesWrapper(Set<CapirotoNames> capirotoNamesCollection) {
		this.capirotoNamesCollection = capirotoNamesCollection;
	}

	public Set<CapirotoNames> getCapirotoNamesCollection() {
		return capirotoNamesCollection;
	}

	public void setCapirotoNamesCollection(Set<CapirotoNames> capirotoNamesCollection) {
		this.capirotoNamesCollection = capirotoNamesCollection;
	}
}
