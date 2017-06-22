package mx.ipn.escom.wad.duml.parserJSON;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Parser {	
	public static List <Clase> clase=new ArrayList<>();
	
	public List<RelacionFlecha> JSONParseFlecha(String rutaJSON) throws FileNotFoundException, IOException, ClassNotFoundException, ParseException{
		List<RelacionFlecha> relacion=new ArrayList<>();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(rutaJSON));
		 String datos = (String) in.readObject();
		 in.close();    	
		 JSONParser parser = new JSONParser();
		 Object obj = parser.parse(datos);
        JSONObject jsonObject = (JSONObject) obj;
        
        JSONArray cells = (JSONArray) jsonObject.get("cells");
        
        for (int i = 0; i < cells.size(); i++) {
        	 Object objx = parser.parse(cells.get(i).toString());
         	 JSONObject jsonObjectx = (JSONObject) objx;
        	 
         	 if(jsonObjectx.get("type").toString().equals("app.Link")){
         		 relacion.get(i).setIdFlecha(jsonObjectx.get("id").toString());
         		 Object objy = parser.parse(jsonObjectx.get("source").toString());
	             JSONObject jsonObjecty = (JSONObject) objy;
	             relacion.get(i).setSource(jsonObjecty.get("id").toString());;
	             Object objz = parser.parse(jsonObjectx.get("target").toString());
	             JSONObject jsonObjectz = (JSONObject) objz;
	             relacion.get(i).setTarget(jsonObjectz.get("id").toString());;
	             
        	 }
			
        }
		
		return relacion;
	}

	public List <Clase> JSONParse(String rutaJSON) throws FileNotFoundException, IOException, ClassNotFoundException, ParseException{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(rutaJSON));
		 String datos = (String) in.readObject();
		 in.close();    	
		 JSONParser parser = new JSONParser();
		 Object obj = parser.parse(datos);
         JSONObject jsonObject = (JSONObject) obj;
         
         JSONArray cells = (JSONArray) jsonObject.get("cells");
         
         for (int i = 0; i < cells.size(); i++) {
        	 Object objx = parser.parse(cells.get(i).toString());
         	 JSONObject jsonObjectx = (JSONObject) objx;
        	
         	 clase.get(i).setTipoClase(jsonObjectx.get("type").toString());
        	 clase.get(i).setIdClaseD(jsonObjectx.get("id").toString());
        	 clase.get(i).setNombreClase(jsonObjectx.get("name").toString());
        	 clase.get(i).metodos.get(i).acceso="";
        	 JSONArray methods = (JSONArray) jsonObjectx.get("methods");
        	 
        	 for (int j = 0; j < methods.size(); j++) {
        		 ExtraerAtributosM(methods.get(i).toString(),i,j);
			}
        	 JSONArray attributes = (JSONArray) jsonObjectx.get("attributes");
        	 
        	 for (int j = 0; j < attributes.size(); j++) {
        		 ParserAtributos(attributes.get(j).toString(),i,j);
			}
        	    
		}
           return clase;    
	}

	public static void ExtraerAtributosM(String Atributos, Integer iClase, Integer jMetodo){
		String[] tmp=Atributos.split("\\(");
		String [] tmp2=tmp[0].split(" ");
		String[] tmp3;
		
		if (tmp2.length==4) {
			clase.get(iClase).metodos.get(jMetodo).acceso=tmp2[0];
			clase.get(iClase).metodos.get(jMetodo).alcance=tmp2[1];
			clase.get(iClase).metodos.get(jMetodo).tipoRetorno=tmp2[2];
			clase.get(iClase).metodos.get(jMetodo).nombreMetodo=tmp2[3];
		}else{
			clase.get(iClase).metodos.get(jMetodo).acceso=tmp2[0];
			clase.get(iClase).metodos.get(jMetodo).tipoRetorno=tmp2[1];
			clase.get(iClase).metodos.get(jMetodo).nombreMetodo=tmp2[2];
		}
		
		if(!tmp[1].equals(")")){
			tmp[1]=tmp[1].replace(")", "");
			
			tmp3=tmp[1].split(",");
			String[] aux;
			for (int i = 0; i < tmp3.length; i++) {
				tmp3[i]=tmp3[i].trim();
				aux=tmp3[i].split(" ");
				clase.get(iClase).metodos.get(jMetodo).atributosMetodos.get(i).tipo=aux[0];
				clase.get(iClase).metodos.get(jMetodo).atributosMetodos.get(i).nombre=aux[1];
			}

			}
	}
	
	public static void ParserAtributos(String Atributos,Integer iClase, Integer idAtributo){
		String[] tmp2;
		String[] tmp=Atributos.split(" ");
		if(tmp.length==4){
			clase.get(iClase).atributos.get(idAtributo).acceso=tmp[0];
			clase.get(iClase).atributos.get(idAtributo).alcance=tmp[1];
			clase.get(iClase).atributos.get(idAtributo).tipo=tmp[2];
			tmp2=tmp[3].split("=");
		}else{
			clase.get(iClase).atributos.get(idAtributo).acceso=tmp[0];
			clase.get(iClase).atributos.get(idAtributo).alcance="";
			clase.get(iClase).atributos.get(idAtributo).tipo=tmp[1];
			tmp2=tmp[2].split("=");
		}
		if(tmp2.length==2){
			clase.get(iClase).atributos.get(idAtributo).nombreAtributo=tmp2[0];
			clase.get(iClase).atributos.get(idAtributo).valor=tmp2[1];
		}else{
			clase.get(iClase).atributos.get(idAtributo).nombreAtributo=tmp2[0];
		}
	}
}
