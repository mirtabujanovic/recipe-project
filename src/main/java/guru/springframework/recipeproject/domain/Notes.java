package guru.springframework.recipeproject.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String recipeNotes;
    @OneToOne//nećemo definirati cascade jer je Recipe objekt owner veze(ako obrišemo recept neka se brišu i notes, a ne obrnuto)
    @EqualsAndHashCode.Exclude
    private Recipe recipe;

}
