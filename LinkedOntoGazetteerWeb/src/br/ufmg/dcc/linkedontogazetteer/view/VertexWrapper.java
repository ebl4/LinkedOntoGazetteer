package br.ufmg.dcc.linkedontogazetteer.view;

import br.ufmg.dcc.linkedontogazetteer.rexster.rest.api.entity.ResultObject;

public class VertexWrapper {

	private final Long id;

	private final String uri;

	private String wikipediaURL;
	private String geonamesURL;

	public VertexWrapper(ResultObject resultObject) {
		this.id = resultObject.get_id();
		this.uri = "vertex.xhtml?id=" + resultObject.get_id().toString();

		if (resultObject.getDbpediaId() != null) {
			this.wikipediaURL = "http://en.wikipedia.org/wiki/" + resultObject.getDbpediaId();
		}

		if (resultObject.getGeonamesId() != null) {
			this.geonamesURL = "http://www.geonames.org/" + resultObject.getGeonamesId();
		}
	}

	public String getGeonamesURL() {
		return this.geonamesURL;
	}

	public Long getId() {
		return this.id;
	}

	public String getUri() {
		return this.uri;
	}

	public String getWikipediaURL() {
		return this.wikipediaURL;
	}

	public void setGeonamesURL(String geonamesURL) {
		this.geonamesURL = geonamesURL;
	}

	public void setWikipediaURL(String wikipediaURL) {
		this.wikipediaURL = wikipediaURL;
	}
}