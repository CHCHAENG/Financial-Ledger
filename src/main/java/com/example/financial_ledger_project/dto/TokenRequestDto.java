package com.example.financial_ledger_project.dto;
import lombok.Data;

@Data
public class TokenRequestDto {
    private String code;
    private String client_id;
    private String client_secret;
    private String redirect_uri;
    private String grant_type;
}
