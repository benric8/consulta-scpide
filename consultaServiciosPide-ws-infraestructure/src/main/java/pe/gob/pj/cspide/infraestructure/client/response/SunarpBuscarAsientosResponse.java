package pe.gob.pj.cspide.infraestructure.client.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class SunarpBuscarAsientosResponse implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SunarpListarAsientosResponse listarAsientosSIRSARPResponse;

}
