package model;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Produto {

	@NonNull
	private Long id;
	private String nome;
	private LocalDate validade;

}
