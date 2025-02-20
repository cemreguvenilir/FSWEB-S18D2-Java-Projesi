package com.workintech.fruit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vegetable", schema = "spring")
public class Vegetable extends Plant {
    @Column(name = "is_grown_on_tree")
    private boolean isGrownOnTree;
}
