
import java.math.*;
import java.time.*;
import java.util.*;
class ForexEngine {

    private final Map<Pair, Bid> rates = new HashMap<>();

    /**
     * Updates the new exchange rate if possible
     * @param pair pair to update
     * @param exchangeRate new exchange rate
     * @param quoteTime timestamp of the new exchange rate
     * @return exchange rate change: positive if the new rate is higher, negative if lower and zero if the previous value is not available
     * @throws QuoteOutdatedException when passed quoteTime is older than the one already stored in the rates map
     */
    BigDecimal update(Pair pair, BigDecimal exchangeRate, ZonedDateTime quoteTime) throws QuoteOutdatedException {

        Bid bid = rates.get(pair);

        rates.put(pair, new Bid(exchangeRate, quoteTime));
        if (bid != null) {
            if (bid.getQuoteTime().isAfter(quoteTime)) {
                throw new QuoteOutdatedException();
            }
            return exchangeRate.subtract(bid.getExchangeRate());
        }
        else
            return BigDecimal.ZERO;
    }

    /**
     * Gets actual exchange rate
     * @param pair pair to verify
     * @return exchange rate
     * @throws RateUnavailableException when no rate for the given pair is available
     */
    BigDecimal getExchangeRate(Pair pair) throws RateUnavailableException {
        return Optional.ofNullable(rates.get(pair)).map(Bid::getExchangeRate).orElseThrow(RateUnavailableException::new);
    }

}
