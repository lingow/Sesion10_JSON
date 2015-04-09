
package com.lingoware.lingow.sesion10_json.beans;

import java.util.ArrayList;
import java.util.List;

public class DatoResponse{

    private List<Tree> dato;

    public DatoResponse() {
        this.dato = new ArrayList<Tree>();
    }

 	public List<Tree> getDato(){
		return this.dato;
	}
	public void setDato(List<Tree> dato){
		this.dato = dato;
	}
}
