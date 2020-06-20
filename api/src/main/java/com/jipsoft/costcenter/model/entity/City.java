package com.jipsoft.costcenter.model.entity;

import com.github.microtweak.jac4e.core.EnumAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Table
@Entity
public class City implements Serializable {

    @Id
    @Column(name = "city_id")
    private Long id;

    @Setter
    private String name;

    @Setter
    private State state;

    @AllArgsConstructor
    @EnumAttributeConverter
    public enum State {
        RO(11,"Rondônia"),
        AC(12,"Acre"),
        AM(13,"Amazonas"),
        RR(14,"Roraima"),
        PA(15,"Pará"),
        AP(16,"Amapá"),
        TO(17,"Tocantins"),
        MA(21,"Maranhão"),
        PI(22,"Piauí"),
        CE(23,"Ceará"),
        RN(24,"Rio Grande do Norte"),
        PB(25,"Paraíba"),
        PE(26,"Pernambuco"),
        AL(27,"Alagoas"),
        SE(28,"Sergipe"),
        BA(29,"Bahia"),
        MG(31,"Minas Gerais"),
        ES(32,"Espírito Santo"),
        RJ(33,"Rio de Janeiro"),
        SP(35,"São Paulo"),
        PR(41,"Paraná"),
        SC(42,"Santa Catarina"),
        RS(43,"Rio Grande do Sul"),
        MS(50,"Mato Grosso do Sul"),
        MT(51,"Mato Grosso"),
        GO(52,"Goiás"),
        DF(53,"Distrito Federal");

        private int value;

        private String name;

        public static State findByCode(int code) {
            for (State state : State.values()) {
                if (code == state.value) {
                    return state;
                }
            }

            return null;
        }

    }

}
