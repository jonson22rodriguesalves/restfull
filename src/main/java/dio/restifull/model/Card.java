package dio.restifull.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;


@Entity(name = "tb_card")
public class Card {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @NotBlank(message = "Número do cartão não pode estar em branco")
        @Size(min = 16, max = 16, message = "Número do cartão deve ter 16 caracteres")
        @Column(unique = true)
        private String number;

        @NotNull(message = "Limite do cartão não pode ser nulo")
        @PositiveOrZero(message = "Limite do cartão deve ser positivo ou zero")
        @Digits(integer = 13, fraction = 2, message = "Limite do cartão deve ter no máximo 13 dígitos inteiros e 2 decimais")
        @Column(name = "card_limit", precision = 13, scale = 2)
        private BigDecimal limit;

        
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
        
        @Column(name = "available_limit", precision = 13, scale = 2)
        public BigDecimal getLimit() {
            return limit;
        }

        public void setLimit(BigDecimal limit) {
            this.limit = limit;
        }

            
     
}
