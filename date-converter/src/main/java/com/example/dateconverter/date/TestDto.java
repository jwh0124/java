package com.example.dateconverter.date;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {

    private Long id;

    private LocalDateTime createDt;

    private LocalDateTime updateDt;
}
