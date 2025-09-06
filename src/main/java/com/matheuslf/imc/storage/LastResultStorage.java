package com.matheuslf.imc.storage;

import com.matheuslf.imc.dto.ImcResponse;
import org.springframework.stereotype.Component;

@Component
public class LastResultStorage {

    private ImcResponse lastResult;

    public void salvarResultado(ImcResponse response) {
        this.lastResult = response;
    }

    public ImcResponse obterUltimoResultado() {
        return lastResult;
    }

}
