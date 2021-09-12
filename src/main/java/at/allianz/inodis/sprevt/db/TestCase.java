package at.allianz.inodis.sprevt.db;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TestCase {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String result;

    @ManyToOne
    @JoinColumn(name="exec_id", nullable = false)
    private  Execution execution;
}
