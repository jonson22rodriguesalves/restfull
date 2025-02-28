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


@Entity(name = "tb_account")

public class Account {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) 
        private long id;

        @NotBlank(message = "Número da conta não pode estar em branco")
        @Size(min = 5, max = 20, message = "Número da conta deve ter entre 5 e 20 caracteres")
        @Column(unique = true)
        private String number;

        @NotBlank(message = "Agência não pode estar em branco")
        @Size(min = 4, max = 10, message = "Agência deve ter entre 4 e 10 caracteres")
        private String agency;

        @NotNull(message = "Saldo não pode ser nulo")
        @PositiveOrZero(message = "Saldo deve ser positivo ou zero")
        @Digits(integer = 13, fraction = 2, message = "Saldo deve ter no máximo 13 dígitos inteiros e 2 decimais")
        @Column(precision = 13, scale = 2)
        private BigDecimal balance;

        @NotNull(message = "Limite adicional não pode ser nulo")
        @PositiveOrZero(message = "Limite adicional deve ser positivo ou zero")
        @Digits(integer = 13, fraction = 2, message = "Limite adicional deve ter no máximo 13 dígitos inteiros e 2 decimais")
        @Column(name = "additional_limit", precision = 13, scale = 2)
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

        public String getAgency() {
            return agency;
        }

        public void setAgency(String agency) {
            this.agency = agency;
        }

        public BigDecimal getBalance() {
            return balance;
        }

        public void setBalance(BigDecimal balance) {
            this.balance = balance;
        }

        public BigDecimal getLimit() {
            return limit;
        }

        public void setLimit(BigDecimal limit) {
            this.limit = limit;
        }

        
}
