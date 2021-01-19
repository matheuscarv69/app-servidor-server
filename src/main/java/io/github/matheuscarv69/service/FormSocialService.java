package io.github.matheuscarv69.service;

import io.github.matheuscarv69.domain.entity.FormSocial;
import io.github.matheuscarv69.rest.dto.FormSocialDTO;

import java.util.List;


public interface FormSocialService {

    FormSocial salvar(FormSocialDTO dto);

    List<FormSocialDTO> buscarForms();

}
