package edu.neu.swc.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * <h1>股票实体类定义</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockEntity {
    private String securityCode;
    private String securityNameAbbr;
    private String tradeMarketCode;
    private String tradeMarket;
    private String securityTypeCode;
    private String securityType;
    private String updateDate;
    private String reportDate;
    private BigDecimal basicEps;
    private BigDecimal totalOperateIncome;
    private BigDecimal parentNetprofit;
    private BigDecimal weightavgRoe;
    private BigDecimal ystz;
    private BigDecimal sjltz;
    private BigDecimal bps;
    private BigDecimal mgjyxjje;
    private BigDecimal xsmll;
    private BigDecimal yshz;
    private BigDecimal sjlhz;
    private String publishName;
    private String noticeDate;
    private String orgCode;
    private String tradeMarketZjg;
    private String isNew;
    private String qDate;
    private String dataType;
    private String dataYear;
    private String dateMMDD;
    private String eitime;
    private String SecuCode;
}
