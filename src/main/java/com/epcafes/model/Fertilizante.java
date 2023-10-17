package com.epcafes.model;

import java.time.OffsetDateTime;

import com.epcafes.model.enums.Medida;
import com.epcafes.model.enums.TipoAuxiliarInsumos;
import com.epcafes.model.enums.TipoInsumo;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity

public class Fertilizante {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tenantId;

    @Enumerated(EnumType.STRING)
    private Medida medida;

    @Enumerated(EnumType.STRING)
    private TipoInsumo tipoInsumo;

    @Enumerated(EnumType.STRING)
    private TipoAuxiliarInsumos tipo;

    /*
     * Datas de Criação e Modificação
     */

    @CreationTimestamp
    @Column(columnDefinition = "datetime")
    private OffsetDateTime dataCriacao;

    @UpdateTimestamp
    @Column(columnDefinition = "datetime")
    private OffsetDateTime dataModificacao;
}