package pe.gob.pj.cspide.infraestructure.client.response.sunat;

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
public class SunatDatosT1144Response {
	@XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body body;
	
	
	@Data
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(propOrder = { "getDatosT1144Response", "multiRef" })
	public static class Body {

	    @XmlElement(name = "getDatosT1144Response", namespace = "http://service.consultaruc.registro.servicio2.sunat.gob.pe")
	    private GetDatosT1144Response getDatosT1144Response;

	    @XmlElement(name = "multiRef", namespace = "")
	    private SunatDatosT1144 multiRef;
	   
	}
	
	@Data
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class GetDatosT1144Response {

	    @XmlElement(name = "getDatosT1144Return")
	    private GetDatosT1144Return getDatosT1144Return;
	    
	    @Data
	    public static class GetDatosT1144Return {
	    	
	    }
	}
}
