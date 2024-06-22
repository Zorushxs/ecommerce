package com.onebox.ecommerce.api.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    private String id;

    private List<Product> products;

    private long lastActivityTime;
}
