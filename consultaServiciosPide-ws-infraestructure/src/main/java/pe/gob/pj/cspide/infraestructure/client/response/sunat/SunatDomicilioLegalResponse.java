package pe.gob.pj.cspide.infraestructure.client.response.sunat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
public class SunatDomicilioLegalResponse {
	 	
		@XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
	    private Body body;

	    @Getter @Setter
	    @XmlAccessorType(XmlAccessType.FIELD)
	    @XmlType(propOrder = { "getDomicilioLegalResponse" })
	    public static class Body {

	        @XmlElement(name = "getDomicilioLegalResponse", namespace = "http://service.consultaruc.registro.servicio2.sunat.gob.pe")
	        private SunatDomicilioLegal getDomicilioLegalResponse;

	    }

//	    @Getter @Setter
//	    @XmlAccessorType(XmlAccessType.FIELD)
//	    public static class GetDomicilioLegalResponse {
//
//	        @XmlElement(name = "getDomicilioLegalReturn", namespace = "")
//	        private String getDomicilioLegalReturn;
//
//	    }
}
