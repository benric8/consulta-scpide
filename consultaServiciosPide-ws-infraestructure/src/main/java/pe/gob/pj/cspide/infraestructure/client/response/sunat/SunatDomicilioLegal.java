package pe.gob.pj.cspide.infraestructure.client.response.sunat;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SunatDomicilioLegal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "getDomicilioLegalReturn")
    private String domicilioLegal ;

}
