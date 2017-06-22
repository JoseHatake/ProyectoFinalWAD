package mx.ipn.escom.wad.duml.parserJSON;

import java.util.ArrayList;
import java.util.List;

public class Clase {

	public String IdClaseD;
	public String tipoClase;
	public String nombreClase;
	public List<Metodo> metodos=new ArrayList<>();
	public List<Atributos> atributos=new ArrayList<>();
	public String getIdClaseD() {
		return IdClaseD;
	}
	public void setIdClaseD(String idClaseD) {
		IdClaseD = idClaseD;
	}
	public String getNombreClase() {
		return nombreClase;
	}
	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	public List<Metodo> getMetodos() {
		return metodos;
	}
	public void setMetodos(List<Metodo> metodos) {
		this.metodos = metodos;
	}
	public List<Atributos> getAtributos() {
		return atributos;
	}
	public void setAtributos(List<Atributos> atributos) {
		this.atributos = atributos;
	}
	public String getTipoClase() {
		return tipoClase;
	}
	public void setTipoClase(String tipoClase) {
		this.tipoClase = tipoClase;
	}

	
	
}
