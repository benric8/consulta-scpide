package pe.gob.pj.cspide.infraestructure.client.response.sunat;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
public class SunatRepresentatesLegalesResponse {
	@XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body body;
	
	
	@Data
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(propOrder = { "getRepLegalesResponse", "multiRef" })
	public static class Body {

	    @XmlElement(name = "getRepLegalesResponse", namespace = "http://service.consultaruc.registro.servicio2.sunat.gob.pe")
	    private GetRepLegalesResponse getRepLegalesResponse;

	    @XmlElement(name = "multiRef", namespace = "")
	    private List<SunatRepresentatesLegales> multiRef;
	   
	}
	
	@Data
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class GetRepLegalesResponse {

	    @XmlElement(name = "getRepLegalesReturn")
	    private GetRepLegalesReturn getRepLegalesReturn;
	    
	    @Data
	    public static class GetRepLegalesReturn {
	    	
	    }
	}
}
