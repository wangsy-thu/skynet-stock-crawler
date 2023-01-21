package edu.neu.swc.stock.constant;

@SuppressWarnings("all")
public class UrlConstant {
    public static final String ROOT_URL = "https://datacenter-web.eastmoney.com/api/data/v1/get?callback=jQuery1123036452538891455144_1672219749698&sortColumns=UPDATE_DATE%2CSECURITY_CODE&sortTypes=-1%2C-1&pageSize=50&reportName=RPT_LICO_FN_CPD&columns=ALL&filter=(REPORTDATE%3D%272022-09-30%27)";
    public static final String STRIP_PREFIX_STR = "jQuery1123036452538891455144_1672219749698(";
    public static final String STRIP_SUFFIX_STR = ");";
    public static final String PAGE_PARAM = "&pageNumber=";

    public static final Integer TOTAL_PAGE_NUM = 112;

    public static final Integer FETCH_INTERVAL = 2;

    public static final String K_LINE_URL = "https://46.push2his.eastmoney.com/api/qt/stock/kline/get?cb=jQuery351021419409017191415_1673163343695&ut=fa5fd1943c7b386f172d6893dbfba10b&fields1=f1%2Cf2%2Cf3%2Cf4%2Cf5%2Cf6&fields2=f51%2Cf52%2Cf53%2Cf54%2Cf55%2Cf56%2Cf57%2Cf58%2Cf59%2Cf60%2Cf61&klt=101&fqt=1&end=20500101&lmt=120&_=1673163343761";

    public static final String K_LINE_PARAM = "&secid=0.";
}
