package com.zeroquo.magicregister.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Expansion implements Serializable {
    @Id
    private String id;
    private String name;
    private LocalDate releaseDate;
}
