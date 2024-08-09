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
@XmlType(name = "BeanT1150", propOrder = {
    "numeroCorrelativo",
    "numeroDepartamento",
    "numeroKilometro",
    "numeroLote",
    "numeroManzana"
})
public class SunatEstablecimientosAnexosT1150 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "num_correl")
    private short numeroCorrelativo;

    @XmlElement(name = "num_depar")
    private String numeroDepartamento;

    @XmlElement(name = "num_kilom")
    private String numeroKilometro;

    @XmlElement(name = "num_lote")
    private String numeroLote;

    @XmlElement(name = "num_manza")
    private String numeroManzana;

}
