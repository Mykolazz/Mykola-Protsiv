package com.travel.agency.protsiv.model;

import lombok.Data;
import java.io.Serializable;

@Data
public abstract class Model implements Serializable {

    private static final long serialVersionUID = 8466257860808346236L;
    private Integer id;

}
