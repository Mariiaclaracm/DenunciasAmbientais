package com.denunciasambientais.controller;

import com.denunciasambientais.dto.ReportDTO;
import com.denunciasambientais.entity.Report;
import com.denunciasambientais.service.ReportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/denuncias")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping
    public ResponseEntity<Report> criar(@RequestBody @Valid ReportDTO dto) {
        return ResponseEntity.ok(reportService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Report>> listarTodas() {
        return ResponseEntity.ok(reportService.findAll());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Report>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(reportService.findByUsuario(usuarioId));
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<Report>> listarPorCategoria(@PathVariable Long categoriaId) {
        return ResponseEntity.ok(reportService.findByCategoria(categoriaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        reportService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
