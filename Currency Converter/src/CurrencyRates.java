import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CurrencyRates {


    public static void currencyRates(ArrayList currencyRates) throws IOException {

        Currency currency;

        FileReader currencyFile = null;
        try {
            currencyFile = new FileReader("C:\\Users\\brian\\IdeaProjects\\CurrencyConverter\\CurrencyRates");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader bufferedReader = new BufferedReader(currencyFile);
        String currencyData;

        while(( currencyData = bufferedReader.readLine()) != null)
        {
        String currencyProperties [] = currencyData.split(",");
        String currencyCode = currencyProperties[0];
        String currencyName = currencyProperties[1];
        Double currencyPerUSD = Double.parseDouble(currencyProperties[2]);
        Double USDperCurrency = Double.parseDouble(currencyProperties[3]);
        currency = new Currency(currencyCode, currencyName, currencyPerUSD, USDperCurrency);
        currencyRates.add(currency);
        }

    }
    public static Currency findCurrency(String name, ArrayList <Currency> currencyRates){
    for(Currency currency: currencyRates){
        if(currency.getCurrencyCode().equalsIgnoreCase(name) || currency.getCurrencyName().equalsIgnoreCase(name))
        {
            return currency;
        }
    }
    return null;
    }

    public static boolean isValidCurrency(String name, ArrayList <Currency> currencyRates)
    {
        for(Currency currency: currencyRates){
            if(currency.getCurrencyCode().equalsIgnoreCase(name) || currency.getCurrencyName().equalsIgnoreCase(name))
            {
                return true;
            }
        }
        return false;
    }
    public static double convert(Currency currencyFrom, Currency currencyTo, Double amount)
    {
        Double inUSD = currencyFrom.getUSDperCurrency() * amount;
        Double inCurrency = currencyTo.getCurrencyPerUSD() * inUSD;
        return inCurrency;
    }
}
