package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CompletedLot {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_endLot;
    @DateTimeFormat(pattern = "EEE, d MMM yyyy HH:mm:ss")
    private LocalDateTime dateNow;

    @JsonIgnore
    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST
    )
    private Lot lot;

    public CompletedLot() {
    }

    public CompletedLot(LocalDateTime dateNow, Lot lot) {
        this.dateNow = dateNow;
        this.lot = lot;
    }

    public LocalDateTime getDateNow() {
        return dateNow;
    }

    public void setDateNow(LocalDateTime dateNow) {
        this.dateNow = dateNow;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }
}
