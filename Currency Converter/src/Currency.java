public class Currency {
    String currencyCode;
    String currencyName;
    Double currencyPerUSD;
    Double USDperCurrency;

    public Currency(String currencyCode, String currencyName, Double currencyPerUSD, Double USDperCurrency) {
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.currencyPerUSD = currencyPerUSD;
        this.USDperCurrency = USDperCurrency;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public Double getCurrencyPerUSD() {
        return currencyPerUSD;
    }

    public Double getUSDperCurrency() {
        return USDperCurrency;
    }
}
