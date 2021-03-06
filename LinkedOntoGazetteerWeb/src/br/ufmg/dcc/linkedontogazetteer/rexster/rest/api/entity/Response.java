package br.ufmg.dcc.linkedontogazetteer.rexster.rest.api.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

	private String version;
	private Double queryTime;
	private ArrayList<ResultObject> results;

	public Double getQueryTime() {
		return this.queryTime;
	}

	public ArrayList<ResultObject> getResults() {
		return this.results;
	}

	public Integer getTotalSize() {
		return this.results.size();
	}

	public String getVersion() {
		return this.version;
	}

	public void setQueryTime(Double queryTime) {
		this.queryTime = queryTime;
	}

	public void setResults(ArrayList<ResultObject> results) {
		this.results = results;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
