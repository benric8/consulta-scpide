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
public class SunatDatosT362Response {
	@XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body body;
	
	
	@Data
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(propOrder = { "getDatosT362Response", "multiRef" })
	public static class Body {

	    @XmlElement(name = "getDatosT362Response", namespace = "http://service.consultaruc.registro.servicio2.sunat.gob.pe")
	    private GetDatosT362Response getDatosT362Response;

	    @XmlElement(name = "multiRef", namespace = "")
	    private List<SunatDatosT362> multiRef;
	   
	}
	
	@Data
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class GetDatosT362Response {

	    @XmlElement(name = "getDatosT362Return")
	    private GetDatosT362Return getDatosT362Return;
	    
	    @Data
	    public static class GetDatosT362Return {
	    	
	    }
	}
}
