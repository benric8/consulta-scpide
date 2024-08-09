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
public class SunatEstablecimientosAnexosResponse {

	@XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body body;
	
	
	@Data
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(propOrder = { "getEstablecimientosAnexosResponse", "multiRef" })
	public static class Body {

	    @XmlElement(name = "getEstablecimientosAnexosResponse", namespace = "http://service.consultaruc.registro.servicio2.sunat.gob.pe")
	    private GetEstablecimientosAnexosResponse getEstablecimientosAnexosResponse;

	    @XmlElement(name = "multiRef", namespace = "")
	    private List<SunatEstablecimientosAnexos> multiRef;
	   
	}
	
	@Data
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class GetEstablecimientosAnexosResponse {

	    @XmlElement(name = "getEstablecimientosAnexosReturn")
	    private GetEstablecimientosAnexosReturn getEstablecimientosAnexosReturn;
	    
	    @Data
	    public static class GetEstablecimientosAnexosReturn {
	    	
	    }
	}
}
