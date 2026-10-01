package com.colonia.CrudBasic.Database.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ProdutoEntity {
    private Integer id;
    private String name;
    private Float price;
    private Integer quantity;

}

