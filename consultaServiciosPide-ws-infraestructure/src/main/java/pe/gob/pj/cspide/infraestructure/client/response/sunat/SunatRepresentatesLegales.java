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
@XmlType(name = "BeanRso", propOrder = {
    "codigoCargo",
    "codigoDepartamentoTelefono",
    "descripcionDocumentoIdentidad",
    "numeroOrdenRepresentacionSucesiva",
    "cargo",
    "tipoDocumentoIdentidad",
    "fechaActualizacion",
    "fechaNacimiento",
    "nombreRepresentante",
    "numeroDocumento",
    "numeroRuc",
    "fechaInicioCargo"
})
public class SunatRepresentatesLegales implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "cod_cargo")
    private String codigoCargo;

    @XmlElement(name = "cod_depar")
    private String codigoDepartamentoTelefono;

    @XmlElement(name = "desc_docide")
    private String descripcionDocumentoIdentidad;

    @XmlElement(name = "num_ord_suce")
    private short numeroOrdenRepresentacionSucesiva;

    @XmlElement(name = "rso_cargoo")
    private String cargo;

    @XmlElement(name = "rso_docide")
    private String tipoDocumentoIdentidad;

    @XmlElement(name = "rso_fecact")
    private String fechaActualizacion;

    @XmlElement(name = "rso_fecnac")
    private String fechaNacimiento;

    @XmlElement(name = "rso_nombre")
    private String nombreRepresentante;

    @XmlElement(name = "rso_nrodoc")
    private String numeroDocumento;

    @XmlElement(name = "rso_numruc")
    private String numeroRuc;

    @XmlElement(name = "rso_vdesde")
    private String fechaInicioCargo;

}
