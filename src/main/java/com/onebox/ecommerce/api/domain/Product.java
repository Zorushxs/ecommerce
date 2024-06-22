package com.onebox.ecommerce.api.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private int id;

    private String description;

    private int amount;

}
