package core;

import lombok.extern.slf4j.Slf4j;
import ru.tinkoff.invest.openapi.OpenApi;
import ru.tinkoff.invest.openapi.model.rest.MarketInstrumentList;

@Slf4j
public class ContextProvider {

    private ApiConnector apiConnector;

    public ContextProvider(ApiConnector apiConnector) {
        this.apiConnector = apiConnector;
    }

    public MarketInstrumentList getStocks() throws Exception {
        return getOpenApi().getMarketContext().getMarketStocks().join();
    }

    public MarketInstrumentList getBonds() throws Exception {
        return getOpenApi().getMarketContext().getMarketBonds().join();
    }

    public MarketInstrumentList getEtfs() throws Exception {
        return getOpenApi().getMarketContext().getMarketEtfs().join();
    }

    public MarketInstrumentList getCurrencies() throws Exception {
        return getOpenApi().getMarketContext().getMarketCurrencies().join();
    }

    private OpenApi getOpenApi () throws Exception {
        return apiConnector.getOpenApi();
    }

}
