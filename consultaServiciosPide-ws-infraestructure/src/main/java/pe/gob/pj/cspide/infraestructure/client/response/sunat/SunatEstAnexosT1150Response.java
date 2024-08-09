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
public class SunatEstAnexosT1150Response {
	@XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body body;
	
	
	@Data
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(propOrder = { "getEstAnexosT1150Response", "multiRef" })
	public static class Body {

	    @XmlElement(name = "getEstAnexosT1150Response", namespace = "http://service.consultaruc.registro.servicio2.sunat.gob.pe")
	    private GetEstAnexosT1150Response getEstAnexosT1150Response;

	    @XmlElement(name = "multiRef", namespace = "")
	    private List<SunatEstablecimientosAnexosT1150> multiRef;
	   
	}
	
	@Data
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class GetEstAnexosT1150Response {

	    @XmlElement(name = "getEstAnexosT1150Return")
	    private GetEstAnexosT1150Return getEstAnexosT1150Return;
	    
	    @Data
	    public static class GetEstAnexosT1150Return {
	    	
	    }
	}
}
