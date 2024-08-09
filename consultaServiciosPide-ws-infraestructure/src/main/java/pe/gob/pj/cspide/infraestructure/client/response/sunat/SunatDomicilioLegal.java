package pe.gob.pj.cspide.infraestructure.client.response.sunat;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class SunatDomicilioLegal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "getDomicilioLegalReturn", namespace = "")
    private String domicilioLegal;

}
