package io.github.matheuscarv69.rest.controller;

import io.github.matheuscarv69.domain.entity.FormSocial;
import io.github.matheuscarv69.rest.dto.FormSocialDTO;
import io.github.matheuscarv69.service.FormSocialService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.*;

import java.util.List;

@RestController
@RequestMapping("api/formsocial")
public class FormSocialController {

    private FormSocialService service;

    public FormSocialController(FormSocialService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody @Valid FormSocialDTO dto) {
        FormSocial formSocial = service.salvar(dto);

        return formSocial.getId();
    }

    @GetMapping
    public List<FormSocialDTO> find() {
        return service.buscarForms();
    }
}
