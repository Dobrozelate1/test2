import java.math.*;
import java.util.*;
/**
 * @author Devskiller
 */
class Calculator {

    private final ForexEngine forexEngine;

    Calculator(ForexEngine forexEngine) {
        this.forexEngine = forexEngine;
    }
    final BigDecimal invert = BigDecimal.valueOf(1);

    /**
     * Calculates exchanged currency rate.
     *
     * @param amount    amount to convert
     * @param convertTo currency to convert to
     * @return exchanged amount
     */
    Money exchange(Money amount, Currency convertTo) throws RateUnavailableException {
//        BigDecimal rate;
//        try {
//            rate = forexEngine.getExchangeRate(new Pair(amount.getCurrency(), convertTo));
//        } catch (RateUnavailableException e) {
//            try {
//                rate = BigDecimal.valueOf(1)
//                        .divide(forexEngine.getExchangeRate(new Pair(convertTo,amount.getCurrency())));
//            } catch (RateUnavailableException ex) {
//                return null;
//            }
//        }
//        Money retMoney = new Money(amount.getAmount()
//                .multiply(rate),convertTo);
//        return retMoney;


        BigDecimal rate;
        try {
            rate = forexEngine.getExchangeRate(new Pair(amount.getCurrency(), convertTo));
        } catch (RateUnavailableException e) {
            try {
                rate = forexEngine.getExchangeRate(new Pair(convertTo,amount.getCurrency()));
                rate = invert.divide(forexEngine.getExchangeRate(new Pair(convertTo,amount.getCurrency())));
            } catch (RateUnavailableException ex) {
                return null;
            }
        }
        Money retMoney = new Money(amount.getAmount()
                .multiply(rate),convertTo);
        return retMoney;

    }

}
