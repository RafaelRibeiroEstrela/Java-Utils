package rafaelribeiroestrela.com.github.utilidades.models.enums;

import rafaelribeiroestrela.com.github.utilidades.services.exceptions.ApiException;

public enum StatusAtivoInativoEnum {

	INATIVO(0L, "Inativo"), ATIVO(1L, "Ativo");

	private Long numero;

	private String descricao;

	private StatusAtivoInativoEnum(Long numero, String descricao) {
		this.numero = numero;
		this.descricao = descricao;
	}

	public Long getNumero() {
		return numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusAtivoInativoEnum toEnum(Long numero) {

		if (numero == null) {
			return null;
		}

		for (StatusAtivoInativoEnum x : StatusAtivoInativoEnum.values()) {
			if (numero.equals(x.getNumero())) {
				return x;
			}
		}

		throw new ApiException("Código Status inválido: " + numero);
	}

	public static StatusAtivoInativoEnum toEnumDesc(String desc) {

		if (desc == null || desc.isEmpty()) {
			throw new ApiException("Enum inválido:  " + desc);
		}

		for (StatusAtivoInativoEnum x : StatusAtivoInativoEnum.values()) {
			if (desc.equals(x.name())) {
				return x;
			}
		}

		throw new ApiException("Enum inválido:  " + desc);
	}

}
