package mx.ipn.escom.wad.duml.parserJSON;

import java.util.ArrayList;
import java.util.List;

public class Metodo {

	public String nombreMetodo;
	public String alcance;
	public String acceso;
	public String tipoRetorno;
	public List<AtributoMetodo> atributosMetodos=new ArrayList<>();
	public String getNombreMetodo() {
		return nombreMetodo;
	}
	public void setNombreMetodo(String nombreMetodo) {
		this.nombreMetodo = nombreMetodo;
	}
	public String getAlcance() {
		return alcance;
	}
	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}
	public String getAcceso() {
		return acceso;
	}
	public void setAcceso(String acceso) {
		this.acceso = acceso;
	}
	public String getTipoRetorno() {
		return tipoRetorno;
	}
	public void setTipoRetorno(String tipoRetorno) {
		this.tipoRetorno = tipoRetorno;
	}
	public List<AtributoMetodo> getAtributosMetodos() {
		return atributosMetodos;
	}
	public void setAtributosMetodos(List<AtributoMetodo> atributosMetodos) {
		this.atributosMetodos = atributosMetodos;
	}
	
	
	
}
