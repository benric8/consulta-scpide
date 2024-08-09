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
public class SunatRazonSocialResponse {
	@XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body body;
	
	
	@Data
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(propOrder = { "getbuscaRazonSocialResponse", "multiRef" })
	public static class Body {

	    @XmlElement(name = "getbuscaRazonSocialResponse", namespace = "http://service.consultaruc.registro.servicio2.sunat.gob.pe")
	    private GetbuscaRazonSocialResponse getbuscaRazonSocialResponse;

	    @XmlElement(name = "multiRef", namespace = "")
	    private List<SunatRazonSocial> multiRef;
	   
	}
	
	@Data
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class GetbuscaRazonSocialResponse {

	    @XmlElement(name = "getbuscaRazonSocialReturn")
	    private GetbuscaRazonSocialReturn getbuscaRazonSocialReturn;
	    
	    @Data
	    public static class GetbuscaRazonSocialReturn {
	    	
	    }
	}
}
