package dev.harsh.architect.bookmyshow.models;

import dev.harsh.architect.bookmyshow.enums.PaymentMethod;
import dev.harsh.architect.bookmyshow.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private double amount;
    private String reference;
    @Enumerated
    private PaymentMethod paymentMethod;
    @Enumerated
    private PaymentStatus paymentStatus;
}
