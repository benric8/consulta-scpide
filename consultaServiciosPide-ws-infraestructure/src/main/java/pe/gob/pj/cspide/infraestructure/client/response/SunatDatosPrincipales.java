package pe.gob.pj.cspide.infraestructure.client.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
		"codigoDepartamento", "codigoDistrito", "codigoProvincia", "codigoActividadEconomica", "estadoContribuyente",
	    "fechaHoraActualizacion", "fechaAlta", "fechaBaja", "condicionDomicilio", "tipoPersona",
	    "interior", "libretaTributaria", "nombreRazonSocial", "nombreVia", "nombreZona", 
	    "numero", "codigoDependencia", "numeroRUC", "referenciaUbicacion", "codigoSecuencia",
	    "codigoTipoVia", "codigoTipoZona", "tipoContribuyente", "codigoUbigeo", 
	    "descripcionActividadEconomica", "descripcionDepartamento", "descripcionDistrito", 
	    "descripcionEstadoContribuyente", "descripcionCondicionDomicilio", "descripcionTipoPersona", 
	    "descripcionDependencia", "descripcionProvincia", "descripcionTipoVia", 
	    "descripcionTipoZona", "descripcionContribuyente", "estadoActivo", "estadoHabido"
})
public class SunatDatosPrincipales  implements Serializable{
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlAttribute(name = "id")
    private String id;

    @XmlAttribute(name = "root", namespace = "http://schemas.xmlsoap.org/soap/encoding/")
    private String root;

    @XmlAttribute(name = "encodingStyle", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private String encodingStyle;

    @XmlElement(name = "cod_dep")
    private String codigoDepartamento;

    @XmlElement(name = "cod_dist")
    private String codigoDistrito;

    @XmlElement(name = "cod_prov")
    private String codigoProvincia;

    @XmlElement(name = "ddp_ciiu")
    private String codigoActividadEconomica;

    @XmlElement(name = "ddp_estado")
    private String estadoContribuyente;

    @XmlElement(name = "ddp_fecact")
    private String fechaHoraActualizacion;

    @XmlElement(name = "ddp_fecalt")
    private String fechaAlta;

    @XmlElement(name = "ddp_fecbaj")
    private String fechaBaja;

    @XmlElement(name = "ddp_flag22")
    private String condicionDomicilio;

    @XmlElement(name = "ddp_identi")
    private String tipoPersona;

    @XmlElement(name = "ddp_inter1")
    private String interior;

    @XmlElement(name = "ddp_lllttt")
    private String libretaTributaria;

    @XmlElement(name = "ddp_nombre")
    private String nombreRazonSocial;

    @XmlElement(name = "ddp_nomvia")
    private String nombreVia;

    @XmlElement(name = "ddp_nomzon")
    private String nombreZona;

    @XmlElement(name = "ddp_numer1")
    private String numero;

    @XmlElement(name = "ddp_numreg")
    private String codigoDependencia;

    @XmlElement(name = "ddp_numruc")
    private String numeroRUC;

    @XmlElement(name = "ddp_refer1")
    private String referenciaUbicacion;

    @XmlElement(name = "ddp_secuen")
    private Integer codigoSecuencia;

    @XmlElement(name = "ddp_tipvia")
    private String codigoTipoVia;

    @XmlElement(name = "ddp_tipzon")
    private String codigoTipoZona;

    @XmlElement(name = "ddp_tpoemp")
    private String tipoContribuyente;

    @XmlElement(name = "ddp_ubigeo")
    private String codigoUbigeo;

    @XmlElement(name = "desc_ciiu")
    private String descripcionActividadEconomica;

    @XmlElement(name = "desc_dep")
    private String descripcionDepartamento;

    @XmlElement(name = "desc_dist")
    private String descripcionDistrito;

    @XmlElement(name = "desc_estado")
    private String descripcionEstadoContribuyente;

    @XmlElement(name = "desc_flag22")
    private String descripcionCondicionDomicilio;

    @XmlElement(name = "desc_identi")
    private String descripcionTipoPersona;

    @XmlElement(name = "desc_numreg")
    private String descripcionDependencia;

    @XmlElement(name = "desc_prov")
    private String descripcionProvincia;

    @XmlElement(name = "desc_tipvia")
    private String descripcionTipoVia;

    @XmlElement(name = "desc_tipzon")
    private String descripcionTipoZona;

    @XmlElement(name = "desc_tpoemp")
    private String descripcionContribuyente;

    @XmlElement(name = "esActivo")
    private Boolean estadoActivo;

    @XmlElement(name = "esHabido")
    private Boolean estadoHabido;
}
