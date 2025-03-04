package dio.restifull.domain.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity(name = "tb_feature")
public class Feature extends BaseItem {

    @NotBlank(message = "Ícone não pode estar em branco")
    @Size(max = 255, message = "Ícone deve ter no máximo 255 caracteres")
    private String icon;

    @NotBlank(message = "Descrição não pode estar em branco")
    @Size(max = 255, message = "Descrição deve ter no máximo 255 caracteres")
    private String description;

}