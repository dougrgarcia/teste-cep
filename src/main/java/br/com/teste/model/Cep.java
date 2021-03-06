package br.com.teste.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Cep {
	//todos atributos anotados com jsonIgnore, não devem aparecer no retorno do Json 
	private String cep;
	
	private String logradouro;	

	@JsonIgnoreProperties("complemento")
	private String complemento;
	
	private String bairro;

	private String localidade;
	
	private String uf;	

	@JsonIgnoreProperties("ibge")
	private String ibge;
	
	@JsonIgnoreProperties("gia")
	private String gia;
	
	@JsonIgnoreProperties("ddd")
	private String ddd;

	@JsonIgnoreProperties("siafi")
	private String siafi;
	
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	@JsonIgnore
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@JsonIgnore
	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	@JsonIgnore
	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	@JsonIgnore
	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	@JsonIgnore
	public String getSiafi() {
		return siafi;
	}

	public void setSiafi(String siafi) {
		this.siafi = siafi;
	}

	@JsonIgnore
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}