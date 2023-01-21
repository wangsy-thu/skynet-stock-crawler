package edu.neu.swc.stock.utils;

import edu.neu.swc.stock.domain.StockEntity;

import java.math.BigDecimal;
import java.util.Map;

/**
 * <h1>Map转换成对象</h1>
 */
public class ConvertUtil {
    public static StockEntity convert(Map<String, Object> map) {
        StockEntity res = new StockEntity();

        res.setSecurityCode(
                (String) map.getOrDefault("SECURITY_CODE", "-")
        );
        res.setSecurityNameAbbr(
                (String) map.getOrDefault("SECURITY_NAME_ABBR", "-")
        );
        res.setTradeMarketCode(
                (String) map.getOrDefault("TRADE_MARKET_CODE", "-")
        );

        res.setTotalOperateIncome(object2BigDecimal(
                map.getOrDefault("TOTAL_OPERATE_INCOME", 0.0)
        ));

        res.setTradeMarket(
                (String) map.getOrDefault("TRADE_MARKET", "-")
        );
        res.setSecurityTypeCode(
                (String) map.getOrDefault("SECURITY_TYPE_CODE", "-")
        );
        res.setSecurityType(
                (String) map.getOrDefault("SECURITY_TYPE", "-")
        );
        res.setUpdateDate(
                (String) map.getOrDefault("UPDATE_DATE", "-")
        );
        res.setReportDate(
                (String) map.getOrDefault("REPORTDATE", "-")
        );

        res.setBasicEps(object2BigDecimal(
                map.getOrDefault("BASIC_EPS", 0.0)
        ));


        res.setParentNetprofit(object2BigDecimal(
                map.getOrDefault("PARENT_NETPROFIT", 0.0)
        ));

        res.setWeightavgRoe(object2BigDecimal(
                map.getOrDefault("WEIGHTAVG_ROE", 0.0)
        ));

        res.setYstz(object2BigDecimal(
                map.getOrDefault("YSTZ", 0.0)
        ));

        res.setSjltz(object2BigDecimal(
                map.getOrDefault("SJLTZ", 0.0)
        ));

        res.setBps(object2BigDecimal(
                map.getOrDefault("BPS", 0.0)
        ));

        res.setMgjyxjje(object2BigDecimal(
                map.getOrDefault("MGJYXJJE", 0.0)
        ));
        res.setXsmll(object2BigDecimal(map.getOrDefault("XSMLL", 0.0)));

        res.setYshz(object2BigDecimal(
                map.getOrDefault("YSHZ", 0.0)
        ));
        res.setSjlhz(object2BigDecimal(map.getOrDefault("SJLHZ", 0.0)));
        res.setPublishName(
                (String) map.getOrDefault("PUBLISHNAME", "-")
        );
        res.setNoticeDate(
                (String) map.getOrDefault("NOTICE_DATE", "-")
        );
        res.setOrgCode(
                (String) map.getOrDefault("ORG_CODE", "-")
        );
        res.setTradeMarketZjg(
                (String) map.getOrDefault("TRADE_MARKET_ZJG", "-")
        );
        res.setIsNew(
                (String) map.getOrDefault("ISNEW", "-")
        );
        res.setQDate(
                (String) map.getOrDefault("QDATE", "-")
        );
        res.setDataType(
                (String) map.getOrDefault("DATATYPE", "-")
        );
        res.setDataYear(
                (String) map.getOrDefault("DATAYEAR", "-")
        );
        res.setDateMMDD(
                (String) map.getOrDefault("DATEMMDD", "-")
        );
        res.setEitime(
                (String) map.getOrDefault("EITIME", "-")
        );
        res.setSecuCode(
                (String) map.getOrDefault("SECUCODE", "-")
        );
        return res;
    }

    private static BigDecimal object2BigDecimal(Object o){
        if(o instanceof BigDecimal) {
            return (BigDecimal) o;
        } else if (o == null) {
            return BigDecimal.ZERO;
        } else if (o instanceof Integer) {
            return BigDecimal.valueOf(((Integer) o).doubleValue());
        } else if (o instanceof Long) {
            return BigDecimal.valueOf(((Long) o).doubleValue());
        }
        return BigDecimal.ZERO;
    }

}
