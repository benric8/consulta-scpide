package pe.gob.pj.cspide.infraestructure.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import pe.gob.pj.cspide.domain.model.auditoriageneral.AuditoriaAplicativos;
import pe.gob.pj.cspide.infraestructure.db.entity.auditoriageneral.MovAuditoriaAplicativos;
import pe.gob.pj.cspide.infraestructure.rest.adapter.request.AuditoriaRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-14T11:07:56-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
@Component
public class AuditoriaGeneralMapperImpl implements AuditoriaGeneralMapper {

    @Override
    public AuditoriaAplicativos toAuditoriaAplicativos(AuditoriaRequest auditoriaRequest, String cuo, String ips, String usuauth, String uri, String peticionUrl, String herramientaConsume, String codigoRespuesta, String descripcionRespuesta, long tiempo) {
        if ( auditoriaRequest == null && cuo == null && ips == null && usuauth == null && uri == null && peticionUrl == null && herramientaConsume == null && codigoRespuesta == null && descripcionRespuesta == null ) {
            return null;
        }

        AuditoriaAplicativos auditoriaAplicativos = new AuditoriaAplicativos();

        if ( auditoriaRequest != null ) {
            auditoriaAplicativos.setUsuarioAplicativo( auditoriaRequest.getUsuario() );
            auditoriaAplicativos.setUsuario( auditoriaRequest.getUsuario() );
            auditoriaAplicativos.setNombrePc( auditoriaRequest.getNombrePc() );
            auditoriaAplicativos.setNumeroIp( auditoriaRequest.getNumeroIp() );
            auditoriaAplicativos.setDireccionMac( auditoriaRequest.getDireccionMac() );
        }
        auditoriaAplicativos.setCodigoUnicoOperacion( cuo );
        auditoriaAplicativos.setIps( ips );
        auditoriaAplicativos.setUsuarioAuth( usuauth );
        auditoriaAplicativos.setUri( uri );
        auditoriaAplicativos.setPeticionUrl( peticionUrl );
        auditoriaAplicativos.setHerramientaConsume( herramientaConsume );
        auditoriaAplicativos.setCodigoRespuesta( codigoRespuesta );
        auditoriaAplicativos.setDescripcionRespuesta( descripcionRespuesta );
        auditoriaAplicativos.setDuracionRespuesta( (int) tiempo );
        auditoriaAplicativos.setFechaRegistro( new java.util.Date() );

        return auditoriaAplicativos;
    }

    @Override
    public MovAuditoriaAplicativos toMovAuditoriaAplicativos(AuditoriaAplicativos auditoriaAplicativos) {
        if ( auditoriaAplicativos == null ) {
            return null;
        }

        MovAuditoriaAplicativos movAuditoriaAplicativos = new MovAuditoriaAplicativos();

        movAuditoriaAplicativos.setCAudId( auditoriaAplicativos.getUsuarioAuth() );
        movAuditoriaAplicativos.setId( auditoriaAplicativos.getId() );
        movAuditoriaAplicativos.setFechaRegistro( auditoriaAplicativos.getFechaRegistro() );
        movAuditoriaAplicativos.setUri( auditoriaAplicativos.getUri() );
        movAuditoriaAplicativos.setPeticionUrl( auditoriaAplicativos.getPeticionUrl() );
        movAuditoriaAplicativos.setPeticionBody( auditoriaAplicativos.getPeticionBody() );
        movAuditoriaAplicativos.setUsuarioAplicativo( auditoriaAplicativos.getUsuarioAplicativo() );
        movAuditoriaAplicativos.setUsuarioAuth( auditoriaAplicativos.getUsuarioAuth() );
        movAuditoriaAplicativos.setIps( auditoriaAplicativos.getIps() );
        movAuditoriaAplicativos.setCodigoUnicoOperacion( auditoriaAplicativos.getCodigoUnicoOperacion() );
        movAuditoriaAplicativos.setCodigoRespuesta( auditoriaAplicativos.getCodigoRespuesta() );
        movAuditoriaAplicativos.setDescripcionRespuesta( auditoriaAplicativos.getDescripcionRespuesta() );
        movAuditoriaAplicativos.setDuracionRespuesta( auditoriaAplicativos.getDuracionRespuesta() );
        movAuditoriaAplicativos.setHerramientaConsume( auditoriaAplicativos.getHerramientaConsume() );

        return movAuditoriaAplicativos;
    }
}
