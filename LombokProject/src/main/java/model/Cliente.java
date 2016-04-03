package model;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true, includeFieldNames = true, exclude = "ativo")
@EqualsAndHashCode
@Getter
@Setter
public class Cliente {

	@Getter
	private Long id;

	@NonNull
	private String nome;
	private long cpf;
	private String telefone;
	private LocalDate nascimento;

	@Getter
	@Setter(AccessLevel.PUBLIC)
	private boolean ativo;

	public void setId(@NonNull Long id) {
		this.id = id;
	}
}
