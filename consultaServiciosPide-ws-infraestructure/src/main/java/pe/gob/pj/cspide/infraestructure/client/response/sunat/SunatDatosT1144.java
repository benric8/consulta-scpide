package pe.gob.pj.cspide.infraestructure.client.response.sunat;

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
	    "codigoActividadEconomicaSecundaria1", "descripcionActividadEconomica1", "codigoActividadEconomicaSecundaria2", "descripcionActividadEconomica2",
	    "correoElectronico1", "correoElectronico2", "numeroTelefono1", "codigoDepartamento1", "descripcionDepartamento1",
	    "numeroTelefono2", "codigoDepartamento2", "descripcionDepartamento2", "numeroTelefono3", "codigoDepartamento3",
	    "descripcionDepartamento3", "numeroTelefono4", "codigoDepartamento4", "descripcionDepartamento4", "numeroFax",
	    "codigoDepartamento5", "descripcionDepartamento5", "numeroAsientoRRPP", "partidaRegistral", "referenciaNotificacion",
	    "indicadorCondicionLegalDomicilio", "descripcionCondicionLegalDomicilio", "indicadorCorreo1", "fechaConfirmacionCorreo1",
	    "indicadorCorreo2", "fechaConfirmacionCorreo2", "codigoTipoRepresentacion", "descripcionTipoRepresentacion", 
	    "numeroKilometro", "numeroManzana", "numeroDepartamento", "numeroLote", "numeroRUC"
	})
public class SunatDatosT1144 implements Serializable {
	
	
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

	@XmlElement(name = "cod_ciiu2")
    private String codigoActividadEconomicaSecundaria1; // Código de actividad económica secundaria

    @XmlElement(name = "des_ciiu2")
    private String descripcionActividadEconomica1; // Descripción de actividad económica

    @XmlElement(name = "cod_ciiu3")
    private String codigoActividadEconomicaSecundaria2; // Código de actividad económica secundaria

    @XmlElement(name = "des_ciiu3")
    private String descripcionActividadEconomica2; // Descripción de actividad económica

    @XmlElement(name = "cod_correo1")
    private String correoElectronico1; // Correo electrónico

    @XmlElement(name = "cod_correo2")
    private String correoElectronico2; // Correo electrónico

    @XmlElement(name = "num_telef1")
    private String numeroTelefono1; // Número de teléfono 1

    @XmlElement(name = "cod_depar1")
    private String codigoDepartamento1; // Código de departamento 1

    @XmlElement(name = "des_depar1")
    private String descripcionDepartamento1; // Descripción de departamento 1

    @XmlElement(name = "num_telef2")
    private String numeroTelefono2; // Número de teléfono 2

    @XmlElement(name = "cod_depar2")
    private String codigoDepartamento2; // Código de departamento 2

    @XmlElement(name = "des_depar2")
    private String descripcionDepartamento2; // Descripción de departamento 2

    @XmlElement(name = "num_telef3")
    private String numeroTelefono3; // Número de teléfono 3

    @XmlElement(name = "cod_depar3")
    private String codigoDepartamento3; // Código de departamento 3

    @XmlElement(name = "des_depar3")
    private String descripcionDepartamento3; // Descripción de departamento 3

    @XmlElement(name = "num_telef4")
    private String numeroTelefono4; // Número de teléfono 4

    @XmlElement(name = "cod_depar4")
    private String codigoDepartamento4; // Código de departamento 4

    @XmlElement(name = "des_depar4")
    private String descripcionDepartamento4; // Descripción de departamento 4

    @XmlElement(name = "num_fax")
    private String numeroFax; // Número de teléfono fax

    @XmlElement(name = "cod_depar5")
    private String codigoDepartamento5; // Código de departamento 5

    @XmlElement(name = "des_depar5")
    private String descripcionDepartamento5; // Descripción de departamento 5

    @XmlElement(name = "des_asiento")
    private String numeroAsientoRRPP; // Número de asiento en los RRPP

    @XmlElement(name = "des_parreg")
    private String partidaRegistral; // Partida registral

    @XmlElement(name = "des_refnot")
    private String referenciaNotificacion; // Referencia de la notificación

    @XmlElement(name = "ind_conleg")
    private String indicadorCondicionLegalDomicilio; // Condición legal del domicilio

    @XmlElement(name = "des_conleg")
    private String descripcionCondicionLegalDomicilio; // Descripción de la condición legal del domicilio

    @XmlElement(name = "ind_correo1")
    private String indicadorCorreo1; // Indicador de correo 1

    @XmlElement(name = "fec_confir1")
    private String fechaConfirmacionCorreo1; // Fecha de confirmación de correo 1

    @XmlElement(name = "ind_correo2")
    private String indicadorCorreo2; // Indicador de correo 2

    @XmlElement(name = "fec_confir2")
    private String fechaConfirmacionCorreo2; // Fecha de confirmación de correo 2

    @XmlElement(name = "ind_proind")
    private String codigoTipoRepresentacion; // Código de tipo de representación

    @XmlElement(name = "des_proind")
    private String descripcionTipoRepresentacion; // Descripción de tipo de representación

    @XmlElement(name = "num_kilom")
    private String numeroKilometro; // Kilómetro

    @XmlElement(name = "num_manza")
    private String numeroManzana; // Manzana

    @XmlElement(name = "num_depar")
    private String numeroDepartamento; // Departamento

    @XmlElement(name = "num_lote")
    private String numeroLote; // Número de lote

    @XmlElement(name = "num_ruc")
    private String numeroRUC; // Número de RUC
}
