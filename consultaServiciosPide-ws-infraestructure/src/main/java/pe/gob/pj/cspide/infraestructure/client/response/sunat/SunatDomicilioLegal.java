package pe.gob.pj.cspide.infraestructure.client.response.sunat;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@XmlRootElement(name = "getDomicilioLegalResponse", namespace = "http://service.consultaruc.registro.servicio2.sunat.gob.pe")
public class SunatDomicilioLegal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "getDomicilioLegalReturn")
	private String domicilioLegal;

}
