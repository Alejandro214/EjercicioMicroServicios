package com.api_visionplus.API.Vision.Plus.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "accounts_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id @GeneratedValue(generator = "uuid") @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ACCOUNT_NUMBER",nullable = false)
    private String number;

    @Column(name = "ACCOUNT_NUMBER_HASH")
    private String hash;

    @Column(name = "CARDHOLDER_FIRST_NAME",nullable = false)
    private String firstName;

    @Column(name = "CARDHOLDER_LAST_NAME",nullable = false)
    private String lastName;

    @Column(name = "BALANCE",nullable = false)
    private BigDecimal balance;

    @Column(name = "CURRENCY_CODE")
    private Enum currencyCode;

    @Column(name = "ADDRESS_COUNTRY",nullable = false)
    private String addressCountry;

    @Column(name = "ADDRESS_CITY",nullable = false)
    private String addressCity;

    @Column(name = "ADDRESS_STREET",nullable = false)
    private String addressStreet;

    @Column(name = "ADDRESS_NUMBER",nullable = false)
    private Integer addressNumber;

    @UpdateTimestamp
    @Column(name = "LAST_ACTIVITY_DATE")
    private LocalDateTime lastActivityDate;

    @Column(name = "DATE_BIRTH",nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBirth;

}
