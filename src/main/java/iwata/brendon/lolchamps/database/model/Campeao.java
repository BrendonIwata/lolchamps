package iwata.brendon.lolchamps.database.model;

import iwata.brendon.lolchamps.domain.enums.PosicaoPrimariaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "campeao")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "com")
public class Campeao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate anoLancamento;

    private Boolean rework;

    @Enumerated(EnumType.STRING)
    private PosicaoPrimariaEnum posicaoPrimaria;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Campeao campeao = (Campeao) o;

        return Objects.equals(id, campeao.id);
    }

    @Override
    public int hashCode() {
        return 369017462;
    }
}
