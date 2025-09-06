package com.matheuslf.imc.service;

import com.matheuslf.imc.dto.ImcRequest;
import com.matheuslf.imc.dto.ImcResponse;
import com.matheuslf.imc.storage.LastResultStorage;
import com.matheuslf.imc.util.ImcCalculator;
import org.springframework.stereotype.Service;

@Service
public class IcmService {

    private final LastResultStorage lastResultStorage;

    public IcmService(LastResultStorage lastResultStorage) {
        this.lastResultStorage = lastResultStorage;
    }

    public ImcResponse calcularImc(ImcRequest request) {
        double alturaCm = ImcCalculator.calcularAlturaCm(request.altura());
        double pesoIdeal = ImcCalculator.calcularPesoIdeal(alturaCm, request.peso());
        double imc = ImcCalculator.calcularImc(request.altura(), request.peso());
        String interpretacao = ImcCalculator.interpretarImc(imc);

        ImcResponse response = new ImcResponse(imc, interpretacao, pesoIdeal, alturaCm);
        lastResultStorage.salvarResultado(response);
        return response;
    }

    public ImcResponse obterUltimoResultado() {
        return lastResultStorage.obterUltimoResultado();
    }

}








