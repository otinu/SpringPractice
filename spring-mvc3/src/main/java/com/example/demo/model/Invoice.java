package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Invoice {

    // 必須入力、文字列が60文字まで
    @NotBlank
    @Size(max = 60)
    private String name;

    // 必須入力、文字列が254文字まで
    @NotBlank
    @Size(max = 254) //ここで、minを指定していないから暗黙的に「min = 0」となっている
    private String address;

    // ※バリデーションではない
    // 必須入力、半角数字かハイフン
    @NotBlank
    @Pattern(regexp = "[0-9-]*")
    private String phoneNumber;

    // ※バリデーションではない
    // 必須入力、1000円以上、数値へ変換
    @NotNull
    @Min(1000)
    @NumberFormat(pattern = "#,###")
    private BigDecimal price;

    // 必須入力、文字列型から日付型へ変換
    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate paymentDeadline;
}
