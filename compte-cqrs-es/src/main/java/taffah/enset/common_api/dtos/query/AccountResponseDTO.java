package taffah.enset.common_api.dtos.query;


import taffah.enset.common_api.enumerations.AccountStatus;

public class AccountResponseDTO {
        private String id;
        private String currency;
        private double balance;
        private AccountStatus accountStatus;
}
