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
public class SunatDatosSecundariosResponse {
	@XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body body;
	
	
	@Data
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(propOrder = { "getDatosSecundariosResponse", "multiRef" })
	public static class Body {

	    @XmlElement(name = "getDatosSecundariosResponse", namespace = "http://service.consultaruc.registro.servicio2.sunat.gob.pe")
	    private GetDatosSecundariosResponse getDatosSecundariosResponse;

	    @XmlElement(name = "multiRef", namespace = "")
	    private SunatDatosSecundarios multiRef;
	   
	}
	
	@Data
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class GetDatosSecundariosResponse {

	    @XmlElement(name = "getDatosSecundariosReturn")
	    private GetDatosSecundariosReturn getDatosSecundariosReturn;
	    
	    @Data
	    public static class GetDatosSecundariosReturn {
	    	
	    }
	}
}
