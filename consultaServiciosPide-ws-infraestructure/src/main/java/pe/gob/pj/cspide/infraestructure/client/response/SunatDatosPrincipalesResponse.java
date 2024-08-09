package pe.gob.pj.cspide.infraestructure.client.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Getter @Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
public class SunatDatosPrincipalesResponse  {

	@XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body body;
	
	
	@Data
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(propOrder = { "getDatosPrincipalesResponse", "multiRef" })
	public static class Body {

	    @XmlElement(name = "getDatosPrincipalesResponse", namespace = "http://service.consultaruc.registro.servicio2.sunat.gob.pe")
	    private GetDatosPrincipalesResponse getDatosPrincipalesResponse;

	    @XmlElement(name = "multiRef", namespace = "")
	    private SunatDatosPrincipales multiRef;
	   
	}
	
	@Data
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class GetDatosPrincipalesResponse {

	    @XmlElement(name = "getDatosPrincipalesReturn")
	    private GetDatosPrincipalesReturn getDatosPrincipalesReturn;
	    
	    @Data
	    public static class GetDatosPrincipalesReturn {
	    	
	    }
	}

    
}
