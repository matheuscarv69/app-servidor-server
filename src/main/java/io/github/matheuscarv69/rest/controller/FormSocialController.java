package io.github.matheuscarv69.rest.controller;

import io.github.matheuscarv69.domain.entity.FormSocial;
import io.github.matheuscarv69.rest.dto.FormSocialDTO;
import io.github.matheuscarv69.service.FormSocialService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
<<<<<<< HEAD
@RequestMapping("formsocial")
=======
@RequestMapping("/formsocial")
>>>>>>> refatoring
@Api(value = "Api Formulário Anamnese Social")
public class FormSocialController {

    private FormSocialService service;

    public FormSocialController(FormSocialService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @ApiOperation("Salva os dados do formulário")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Formulário cadastrado com sucesso"),
            @ApiResponse(code = 400, message = "Erro de validação"),
    })
    public Integer salvar(@RequestBody @Valid @ApiParam("Dados do formulário") FormSocialDTO dto) {
        FormSocial formSocial = service.salvar(dto);

        return formSocial.getId();
    }

    @GetMapping
    @ApiOperation("Busca todos os formulários")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Formulários encontrados com sucesso"),
    })
    public List<FormSocialDTO> buscarTodos() {
        return service.buscarForms();
    }


}
