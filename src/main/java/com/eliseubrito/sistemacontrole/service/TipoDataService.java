package com.eliseubrito.sistemacontrole.service;

import com.eliseubrito.sistemacontrole.model.TipoData;
import com.eliseubrito.sistemacontrole.repository.TipoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDataService {

    TipoDataRepository tipoDataRepository;

    @Autowired
    public TipoDataService(TipoDataRepository tipoDataRepository) {
        this.tipoDataRepository = tipoDataRepository;
    }

    public List<TipoData> findAll() {
        return tipoDataRepository.findAll();
    }

    public TipoData saveTipoData(TipoData tipoData) {
        return tipoDataRepository.save(tipoData);
    }

    public Optional<TipoData> getById(Long idTipoData) {
        return tipoDataRepository.findById(idTipoData);
    }

    public TipoData updateTipoData(TipoData tipoData) {
        return tipoDataRepository.save(tipoData);
    }

    public void deleteTipoData(Long idTipoData) {
        tipoDataRepository.deleteById(idTipoData);
    }

}
