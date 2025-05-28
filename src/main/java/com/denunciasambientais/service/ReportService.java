package com.denunciasambientais.service;

import com.denunciasambientais.dto.ReportDTO;
import com.denunciasambientais.entity.Category;
import com.denunciasambientais.entity.Report;
import com.denunciasambientais.entity.User;
import com.denunciasambientais.repository.CategoryRepository;
import com.denunciasambientais.repository.ReportRepository;
import com.denunciasambientais.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public Report create(ReportDTO dto) {
        User usuario = userRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        Category categoria = categoryRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));

        Report report = Report.builder()
                .descricao(dto.descricao())
                .usuario(usuario)
                .categoria(categoria)
                .localizacao(dto.localizacao())
                .build();

        return reportRepository.save(report);
    }

    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    public List<Report> findByUsuario(Long usuarioId) {
        return reportRepository.findByUsuario_Id(usuarioId);
    }

    public List<Report> findByCategoria(Long categoriaId) {
        return reportRepository.findByCategoria_Id(categoriaId);
    }

    public void delete(Long id) {
        if (!reportRepository.existsById(id)) {
            throw new EntityNotFoundException("Denúncia não encontrada");
        }
        reportRepository.deleteById(id);
    }
}
