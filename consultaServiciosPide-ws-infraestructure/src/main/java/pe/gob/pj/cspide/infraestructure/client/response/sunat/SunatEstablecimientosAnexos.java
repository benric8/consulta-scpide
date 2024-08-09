package pe.gob.pj.cspide.infraestructure.client.response.sunat;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BeanT362", propOrder = {
    "codigoDepartamento",
    "descripcionDepartamento",
    "codigoProvincia",
    "descripcionProvincia",
    "codigoDistrito",
    "descripcionDistrito",
    "numeroRuc",
    "codigoEstablecimiento",
    "nombreVia",
    "numeroKilometroManzana",
    "interiorDptoLote",
    "nombreZona",
    "referenciaUbicacion",
    "nombreEstablecimiento",
    "codigoTipoEstablecimiento",
    "descripcionTipoEstablecimiento",
    "numeroLicenciaMunicipal",
    "tipoVia",
    "descripcionTipoVia",
    "tipoZona",
    "descripcionTipoZona",
    "fechaHoraActualizacion",
    "direccionCompleta"
})
public class SunatEstablecimientosAnexos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "cod_dep")
    private String codigoDepartamento;

    @XmlElement(name = "desc_dep")
    private String descripcionDepartamento;

    @XmlElement(name = "cod_prov")
    private String codigoProvincia;

    @XmlElement(name = "desc_prov")
    private String descripcionProvincia;

    @XmlElement(name = "cod_dist")
    private String codigoDistrito;

    @XmlElement(name = "desc_dist")
    private String descripcionDistrito;

    @XmlElement(name = "spr_numruc")
    private String numeroRuc;

    @XmlElement(name = "spr_correl")
    private int codigoEstablecimiento;

    @XmlElement(name = "spr_nomvia")
    private String nombreVia;

    @XmlElement(name = "spr_numer1")
    private String numeroKilometroManzana;

    @XmlElement(name = "spr_inter1")
    private String interiorDptoLote;

    @XmlElement(name = "spr_nomzon")
    private String nombreZona;

    @XmlElement(name = "spr_refer1")
    private String referenciaUbicacion;

    @XmlElement(name = "spr_nombre")
    private String nombreEstablecimiento;

    @XmlElement(name = "spr_tipest")
    private String codigoTipoEstablecimiento;

    @XmlElement(name = "desc_tipest")
    private String descripcionTipoEstablecimiento;

    @XmlElement(name = "spr_licenc")
    private String numeroLicenciaMunicipal;

    @XmlElement(name = "spr_tipvia")
    private String tipoVia;

    @XmlElement(name = "desc_tipvia")
    private String descripcionTipoVia;

    @XmlElement(name = "spr_tipzon")
    private String tipoZona;

    @XmlElement(name = "desc_tipzon")
    private String descripcionTipoZona;

    @XmlElement(name = "spr_fecact")
    private String fechaHoraActualizacion;

    @XmlElement(name = "direccion")
    private String direccionCompleta;
}
