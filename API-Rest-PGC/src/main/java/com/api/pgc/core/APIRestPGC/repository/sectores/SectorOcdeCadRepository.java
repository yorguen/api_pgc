/*
 * Copyright (c) 2019.  Nahum Martinez
 */

/**
 * @author nahum.martinez
 * @date 22/03/2019
 * @name SectorOcdeCadRepository
 */

package com.api.pgc.core.APIRestPGC.repository.sectores;

import com.api.pgc.core.APIRestPGC.models.sectores.TblNivelSector;
import com.api.pgc.core.APIRestPGC.models.sectores.TblSectorOcdeCad;
import com.api.pgc.core.APIRestPGC.models.sectores.TblTipoSector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SectorOcdeCadRepository extends JpaRepository<TblSectorOcdeCad, Integer> {
    /**
     * Metodo que despliega el Sector OCDE/CAD de la BD
     *
     * @param idSector
     * @return Sector OCDE/CAD de la BD, por parametro de ID
     * @autor Nahum Martinez | NAM
     * @version 22/03/2019/v1.0
     */
    TblSectorOcdeCad findByIdSector(long idSector);


    /**
     * Metodo que despliega el Sector OCDE/CAD de la BD
     *
     * @param codSector
     * @return Sector OCDE/CAD de la BD, por parametro de Codigo
     * @autor Nahum Martinez | NAM
     * @version 22/03/2019/v1.0
     */
    TblSectorOcdeCad findByCodigoSector(String codSector);


    /**
     * Metodo que despliega el Sector OCDE/CAD de la BD con el Tipo de Sector como parametro
     *
     * @param tblTipoSector
     * @return SECTOR OCDE/CAD de la BD, por parametro de ID Tipo
     * @autor Nahum Martinez | NAM
     * @version 22/03/2019/v1.0
     */
    @Query("SELECT e FROM TblSectorOcdeCad e WHERE e.idTipoSector = :idTipoSector ")
    List<TblSectorOcdeCad> getSectorOCByIdTipoSector(@Param("idTipoSector") TblTipoSector tblTipoSector);


    /**
     * Metodo que despliega el Sector OCDE/CAD de la BD con el Nivel de Sector como parametro
     *
     * @param tblNivelSector
     * @return SECTOR OCDE/CAD de la BD, por parametro de ID Nivel de Sector
     * @autor Nahum Martinez | NAM
     * @version 22/03/2019/v1.0
     */
    @Query("SELECT e FROM TblSectorOcdeCad e WHERE e.idNivelSector = :idNivelSector Order By e.idSector")
    List<TblSectorOcdeCad> getSectorOCByIdNivelSector(@Param("idNivelSector") TblNivelSector tblNivelSector);


    /**
     * Metodo que despliega el Sector OCDE/CAD de la BD con el Nivel de Sector como parametro
     *
     * @param tblNivelSector
     * @return SECTOR OCDE/CAD de la BD, por parametro de ID Nivel de Sector
     * @autor Nahum Martinez | NAM
     * @version 22/03/2019/v1.0
     */
    @Query("SELECT COUNT(*) FROM TblSectorOcdeCad e WHERE e.idNivelSector = :idNivelSector")
    long countSectorOCByIdNivelSector(@Param("idNivelSector") TblNivelSector tblNivelSector);


    /**
     * Metodo que despliega el Sector OCDE/CAD de la BD con el Nivel de Sector y Sector Padre como parametro
     *
     * @param tblNivelSector   Nivel del Sector
     * @param tblSectorOcdeCad Sector Padre
     * @return SECTOR OCDE/CAD de la BD, por parametro de ID Nivel de Sector y Sector Padre Id
     * @autor Nahum Martinez | NAM
     * @version 25/03/2019/v1.0
     */
    @Query("SELECT e.idSector as idSector, e.nombreSector as nombreSector FROM TblSectorOcdeCad e WHERE e.idNivelSector = :idNivelSector AND e.sectorPadreId = :sectorPadreId")
    List<TblSectorOcdeCad> getSectorOCByIdNivelSectorAndSectorPadreId(@Param("idNivelSector") TblNivelSector tblNivelSector,
                                                                      @Param("sectorPadreId") TblSectorOcdeCad tblSectorOcdeCad);


    /**
     * Metodo que despliega el Sector OCDE/CAD de la BD con el Nivel de Sector como parametro
     *
     * @param tblNivelSector
     * @param tblSectorOcdeCad Sector Padre
     * @return SECTOR OCDE/CAD de la BD, por parametro de ID Nivel de Sector
     * @autor Nahum Martinez | NAM
     * @version 22/03/2019/v1.0
     */
    @Query("SELECT COUNT(*) FROM TblSectorOcdeCad e WHERE e.idNivelSector = :idNivelSector AND e.sectorPadreId = :sectorPadreId")
    long countSectorOCByIdNivelSectorAndSectorPadreId(@Param("idNivelSector") TblNivelSector tblNivelSector,
                                                      @Param("sectorPadreId") TblSectorOcdeCad tblSectorOcdeCad);


    /**
     * Metodo que despliega los Sectores OCDE/CAD de la BD
     *
     * @return SECTORES OCDE/CAD de la BD
     * @autor Nahum Martinez | NAM
     * @version 03/07/2019/v1.0
     */
    @Query("SELECT new map( se.idSector as idSector, se.codigoSector as codigoSector," +
            "ts.idTipoSector as idTipoSector, ts.nombreSector as nombreSector, " +
            "np.sectorPadreId.idSector as sectorPadreId," +
            "se.nombreSector as nombreSector, se.descripcionSector as descripcionSector," +
            "se.activo as activo, se.fechaCreacion as fechaCreacion, se.horaCreacion as horaCreacion, " +
            "ns.idNivelSector as idNivelSector, ns.nombreNivelSector as nombreNivelSector, " +
            "se.imagenSector as imagenSector) " +
            "FROM TblSectorOcdeCad as se " +
            "INNER JOIN se.idTipoSector as ts " +
            "INNER JOIN se.idNivelSector as ns " +
            "LEFT OUTER JOIN se.sectorPadreId as np " +
            "ORDER BY se.idSector ASC ")
    List<TblSectorOcdeCad> getAllSectoresOcdeCad();
}
