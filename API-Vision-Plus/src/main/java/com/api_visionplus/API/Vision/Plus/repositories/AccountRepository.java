package com.api_visionplus.API.Vision.Plus.repositories;

import com.api_visionplus.API.Vision.Plus.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account,String> {

    Account findAccountByHash(String hash);
    List<Account> findAccountByBalanceGreaterThanEqualAndBalanceLessThanEqual(BigDecimal minRange, BigDecimal maxRange);

}
