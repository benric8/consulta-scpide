package pe.gob.pj.cspide.infraestructure.client.response.sunat;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BeanDdp", propOrder = {
    "esHabido",
    "esActivo",
    "secuencia",
    "nombreRepresentante",
    "numeroRuc"
})
public class SunatRazonSocial implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "esHabido")
    private boolean esHabido;

    @XmlElement(name = "esActivo")
    private boolean esActivo;

    @XmlElement(name = "ddp_secuen")
    private int secuencia;

    @XmlElement(name = "ddp_nombre")
    private String nombreRepresentante;

    @XmlElement(name = "ddp_numruc")
    private String numeroRuc;
}
