package pe.gob.pj.cspide.domain.model.seguridad;

import java.io.Serializable;

import lombok.Data;

@Data
public class Aplicativo implements Serializable{

	private static final long serialVersionUID = 1L;

	private String cCodAplicativo;
	private String xNomAplicativo;
}
