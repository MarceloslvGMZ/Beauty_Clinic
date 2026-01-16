package com.clinica.api.model.servico;

public record ServicoRequestDTO(String nome, String descricao, float valor, boolean ativo) {
}
