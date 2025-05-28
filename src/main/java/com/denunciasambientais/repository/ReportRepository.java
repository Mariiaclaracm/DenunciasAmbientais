package com.denunciasambientais.repository;

import com.denunciasambientais.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByUsuario_Id(Long usuarioId);
    List<Report> findByCategoria_Id(Long categoriaId);
}
