package com.matheuslf.imc.controller;

import com.matheuslf.imc.dto.ImcRequest;
import com.matheuslf.imc.dto.ImcResponse;
import com.matheuslf.imc.service.IcmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/imc")
public class ImcController {

    private final IcmService imcService;

    public ImcController(IcmService imcService) {
        this.imcService = imcService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<ImcResponse> calcular(@RequestBody ImcRequest request) {
        return ResponseEntity.ok(imcService.calcularImc(request));
    }

    @GetMapping("/ultimo-resultado")
    public ResponseEntity<ImcResponse> obterUltimoResultado() {

        ImcResponse ultimoResultado = imcService.obterUltimoResultado();
        if (ultimoResultado == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(ultimoResultado);
    }

}









