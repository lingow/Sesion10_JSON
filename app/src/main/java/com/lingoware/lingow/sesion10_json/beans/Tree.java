
package com.lingoware.lingow.sesion10_json.beans;

import java.lang.String;

public class Tree {
    public Tree() {
        NID = "";
        altura = "";
        diametro = "";
        fecha_lectura = "";
        humedad = "";
        id_red = "";
        imagen = "";
        jardin = "";
        latitud = "";
        longitud = "";
        plantado = "";
        taxonomia = "";
        temp_arbol = "";
        temp_suelo = "";
        valoracion = "";
    }

    private String NID;
   	private String altura;
   	private String diametro;
   	private String fecha_lectura;
   	private String humedad;
   	private String id_red;
   	private String imagen;
   	private String jardin;
   	private String latitud;
   	private String longitud;
   	private String plantado;
   	private String taxonomia;
   	private String temp_arbol;
   	private String temp_suelo;
   	private String valoracion;

 	public String getNID(){
		return this.NID;
	}
	public void setNID(String NID){
		this.NID = NID;
	}
 	public String getAltura(){
		return this.altura;
	}
	public void setAltura(String altura){
		this.altura = altura;
	}
 	public String getDiametro(){
		return this.diametro;
	}
	public void setDiametro(String diametro){
		this.diametro = diametro;
	}
 	public String getFecha_lectura(){
		return this.fecha_lectura;
	}
	public void setFecha_lectura(String fecha_lectura){
		this.fecha_lectura = fecha_lectura;
	}
 	public String getHumedad(){
		return this.humedad;
	}
	public void setHumedad(String humedad){
		this.humedad = humedad;
	}
 	public String getId_red(){
		return this.id_red;
	}
	public void setId_red(String id_red){
		this.id_red = id_red;
	}
 	public String getImagen(){
		return this.imagen;
	}
	public void setImagen(String imagen){
		this.imagen = imagen;
	}
 	public String getJardin(){
		return this.jardin;
	}
	public void setJardin(String jardin){
		this.jardin = jardin;
	}
 	public String getLatitud(){
		return this.latitud;
	}
	public void setLatitud(String latitud){
		this.latitud = latitud;
	}
 	public String getLongitud(){
		return this.longitud;
	}
	public void setLongitud(String longitud){
		this.longitud = longitud;
	}
 	public String getPlantado(){
		return this.plantado;
	}
	public void setPlantado(String plantado){
		this.plantado = plantado;
	}
 	public String getTaxonomia(){
		return this.taxonomia;
	}
	public void setTaxonomia(String taxonomia){
		this.taxonomia = taxonomia;
	}
 	public String getTemp_arbol(){
		return this.temp_arbol;
	}
	public void setTemp_arbol(String temp_arbol){
		this.temp_arbol = temp_arbol;
	}
 	public String getTemp_suelo(){
		return this.temp_suelo;
	}
	public void setTemp_suelo(String temp_suelo){
		this.temp_suelo = temp_suelo;
	}
 	public String getValoracion(){
		return this.valoracion;
	}
	public void setValoracion(String valoracion){
		this.valoracion = valoracion;
	}
}
