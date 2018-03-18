package com.zeroquo.magicregister.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Card implements Serializable{
    @Id
    private String id;
    private String cost;
    private String title;
    private String type;
    private String subtype;
    private String textBox;
    private List<Expansion> expansion;
    private String collectorNumber;
    private String power;
    private String toughness;
    private String loyalty;
    private String urlImage;
}
