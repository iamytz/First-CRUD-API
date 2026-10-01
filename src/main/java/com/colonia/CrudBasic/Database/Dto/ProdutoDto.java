package com.colonia.CrudBasic.Database.Dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    private String name;
    private Float price;
    private Integer quantity;

}
