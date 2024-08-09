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
    "descripcionOficinaRRPP",
    "fechaHoraActualizacion",
    "fechaBaja",
    "numeroIndice",
    "nombreEmpresa",
    "numeroRegistro",
    "numeroRUC"
})
public class SunatDatosT362 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "desc_numreg")
    private String descripcionOficinaRRPP;

    @XmlElement(name = "t362_fecact")
    private String fechaHoraActualizacion;

    @XmlElement(name = "t362_fecbaj")
    private String fechaBaja;

    @XmlElement(name = "t362_indice")
    private int numeroIndice;

    @XmlElement(name = "t362_nombre")
    private String nombreEmpresa;

    @XmlElement(name = "t362_numreg")
    private String numeroRegistro;

    @XmlElement(name = "t362_numruc")
    private String numeroRUC;
    
}
