/*
 * Copyright (c) 2019.  Nahum Martinez
 */

package com.api.pgc.core.APIRestPGC.repository.actividades;

import com.api.pgc.core.APIRestPGC.models.actividades.TblActividad;
import com.api.pgc.core.APIRestPGC.models.actividades.TblActividadDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ActividadDocumentoRepository extends JpaRepository<TblActividadDocumento, Integer> {
    /**
     * Metodo que despliega los Documentos del Proyecto de la BD
     * @autor Nahum Martinez | NAM
     * @version  06/04/2019/v1.0
     * @return Recursos de la BD, por paramtro de Codigo
     * @param codActividadDocumento
     */
    TblActividadDocumento findByCodActividadDocumento(String codActividadDocumento);

    /**
     * Metodo que despliega los Documentos del Proyecto de la BD
     *
     * @param codActividadDocumento
     * @return Recursos del Proyecto de la BD, por paramtro de Codigo
     * @autor Nahum Martinez | NAM
     * @version 06/04/2019/v1.0
     */
    long countByCodActividadDocumento(String codActividadDocumento);

    /**
     * Metodo que despliega las Id Internas de la BD
     *
     * @param tblActividad
     * @return Documentos del Proyecto de la BD, por paramtro de Id Actividad
     * @autor Nahum Martinez | NAM
     * @version 06/04/2019/v1.0
     */
    long countByIdActividad(TblActividad tblActividad);


    /**
     * Metodo que Borra el Documento de la BD con el Id como parametro
     * en la Tabla Actividad Documentos
     * @param codActividadDocumento
     * @return Documento Actividad de la BD, por paramtro de Codigo
     * @autor Nahum Martinez | NAM
     * @version 06/04/2019/v1.0
     */
    @Modifying
    @Transactional
    @Query("DELETE FROM TblActividadDocumento e WHERE e.codActividadDocumento= :codActividadDocumento")
    void  deleletedCodActividadDocumento(@Param("codActividadDocumento") String codActividadDocumento);
}
