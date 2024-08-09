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
	    "departamentoContribuyente", "numeroAsientoInscripcion", "calificacionConductaContribuyente", "centroContribuyente",
	    "descripcionCierre", "indicadorActividadComercioExterior", "fechaConstitucion", "tipoContabilidad",
	    "tipoDocumentoIdentidad", "condicionDomiciliado", "ejemploInscripcion", "tipoFacturacion",
	    "fechaUltimaActividad", "fechaNacimiento", "fechaVencimiento", "fichaInscripcion",
	    "fechaInicioActividades", "numeroLicenciaMunicipal", "motivoBajaContribuyente", "motivoEmisionContribuyente",
	    "nacionalidad", "numeroFolios", "nombreComercial", "numeroDocumentoIdentidad",
	    "numeroFax", "numeroRUC", "origenEntidad", "paisEmisionPasaporte",
	    "numeroPasaporte", "carnetPatronal", "sexo",
	    "numeroTelefono1", "numeroTelefono2", "numeroTelefono3", "nombreUsuario",
	    "fechaDeclaracion", "descripcionAlternativaCierre", "descripcionComercioExterior",
	    "descripcionTipoContabilidad", "descripcionDocumentoIdentidad",
	    "descripcionCondicionDomiciliado", "descripcionTipoFacturacion",
	    "descripcionMotivoBajaContribuyente", "descripcionNacionalidad", "descripcionOrigenEntidad", 
	    "descripcionSexo"
	})
public class SunatDatosSecundarios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * @XmlAttribute(name = "id") private String id;
	 * 
	 * @XmlAttribute(name = "root", namespace =
	 * "http://schemas.xmlsoap.org/soap/encoding/") private String root;
	 * 
	 * @XmlAttribute(name = "encodingStyle", namespace =
	 * "http://schemas.xmlsoap.org/soap/envelope/") private String encodingStyle;
	 */
	
	@XmlElement(name = "dds_aparta")
    private String departamentoContribuyente; // Departamento del contribuyente

    @XmlElement(name = "dds_asient")
    private String numeroAsientoInscripcion; // Número de asiento de inscripción RRPP

    @XmlElement(name = "dds_califi")
    private String calificacionConductaContribuyente; // Calificación de la conducta del contribuyente

    @XmlElement(name = "dds_centro")
    private String centroContribuyente; // Centro del contribuyente

    @XmlElement(name = "dds_cierre")
    private String descripcionCierre; // Descripción del cierre

    @XmlElement(name = "dds_comext")
    private String indicadorActividadComercioExterior; // Marca de actividad de comercio exterior

    @XmlElement(name = "dds_consti")
    private String fechaConstitucion; // Fecha de constitución

    @XmlElement(name = "dds_contab")
    private String tipoContabilidad; // Tipo de contabilidad

    @XmlElement(name = "dds_docide")
    private String tipoDocumentoIdentidad; // Tipo de documento de identidad

    @XmlElement(name = "dds_domici")
    private String condicionDomiciliado; // Condición de domiciliado

    @XmlElement(name = "dds_ejempl")
    private String ejemploInscripcion; // Ejemplo de inscripción en RRPP

    @XmlElement(name = "dds_factur")
    private String tipoFacturacion; // Tipo de facturación

    @XmlElement(name = "dds_fecact")
    private String fechaUltimaActividad; // Fecha de la última actividad

    @XmlElement(name = "dds_fecnac")
    private String fechaNacimiento; // Fecha de nacimiento

    @XmlElement(name = "dds_fecven")
    private String fechaVencimiento; // Fecha de vencimiento

    @XmlElement(name = "dds_ficha")
    private String fichaInscripcion; // Ficha de inscripción en RRPP

    @XmlElement(name = "dds_inicio")
    private String fechaInicioActividades; // Fecha de inicio de actividades

    @XmlElement(name = "dds_licenc")
    private String numeroLicenciaMunicipal; // Número de licencia municipal

    @XmlElement(name = "dds_motbaj")
    private String motivoBajaContribuyente; // Motivación para la baja del contribuyente

    @XmlElement(name = "dds_motemi")
    private String motivoEmisionContribuyente; // Motivación de emisión del contribuyente

    @XmlElement(name = "dds_nacion")
    private String nacionalidad; // Nacionalidad

    @XmlElement(name = "dds_nfolio")
    private String numeroFolios; // Número de folios en RRPP

    @XmlElement(name = "dds_nomcom")
    private String nombreComercial; // Nombre comercial

    @XmlElement(name = "dds_nrodoc")
    private String numeroDocumentoIdentidad; // Número de documento de identidad

    @XmlElement(name = "dds_numfax")
    private String numeroFax; // Número de FAX

    @XmlElement(name = "dds_numruc")
    private String numeroRUC; // Número de RUC

    @XmlElement(name = "dds_orient")
    private String origenEntidad; // Origen de la entidad

    @XmlElement(name = "dds_paispa")
    private String paisEmisionPasaporte; // País que emitió el pasaporte

    @XmlElement(name = "dds_pasapo")
    private String numeroPasaporte; // Número de pasaporte

    @XmlElement(name = "dds_patron")
    private String carnetPatronal; // Carnet patronal

    @XmlElement(name = "dds_sexo")
    private String sexo; // Sexo

    @XmlElement(name = "dds_telef1")
    private String numeroTelefono1; // Número de teléfono 1

    @XmlElement(name = "dds_telef2")
    private String numeroTelefono2; // Número de teléfono 2

    @XmlElement(name = "dds_telef3")
    private String numeroTelefono3; // Número de teléfono 3

    @XmlElement(name = "dds_userna")
    private String nombreUsuario; // Nombre de usuario

    @XmlElement(name = "declara")
    private String fechaDeclaracion; // Fecha de declaración

    @XmlElement(name = "desc_cierre")
    private String descripcionAlternativaCierre; // Descripción alternativa del cierre

    @XmlElement(name = "desc_comext")
    private String descripcionComercioExterior; // Descripción de comercio exterior

    @XmlElement(name = "desc_contab")
    private String descripcionTipoContabilidad; // Descripción del tipo de contabilidad

    @XmlElement(name = "desc_docide")
    private String descripcionDocumentoIdentidad; // Descripción del tipo de documento

    @XmlElement(name = "desc_domici")
    private String descripcionCondicionDomiciliado; // Descripción de la condición de domiciliado

    @XmlElement(name = "desc_factur")
    private String descripcionTipoFacturacion; // Descripción del tipo de facturación

    @XmlElement(name = "desc_motbaj")
    private String descripcionMotivoBajaContribuyente; // Descripción de la motivación para la baja del contribuyente

    @XmlElement(name = "desc_nacion")
    private String descripcionNacionalidad; // Descripción de la nacionalidad

    @XmlElement(name = "desc_orient")
    private String descripcionOrigenEntidad; // Descripción del origen de la entidad

    @XmlElement(name = "desc_sexo")
    private String descripcionSexo; // Descripción del sexo

}
