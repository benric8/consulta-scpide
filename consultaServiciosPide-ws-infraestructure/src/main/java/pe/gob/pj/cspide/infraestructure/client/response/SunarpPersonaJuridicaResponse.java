package pe.gob.pj.cspide.infraestructure.client.response;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import pe.gob.pj.cspide.infraestructure.client.dtos.SunarpPersonaJuridicaDto;

@Data
public class SunarpPersonaJuridicaResponse implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<SunarpPersonaJuridicaDto> resultado;

}
