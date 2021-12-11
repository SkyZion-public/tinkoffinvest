package reports;

import ru.tinkoff.invest.openapi.model.rest.MarketInstrument;
import java.io.IOException;
import java.util.List;

public class AllStocksReport extends CommonReport {

    public AllStocksReport(List<MarketInstrument> instruments) throws IOException {
        super();
        this.setFileName("stocks.csv")
                .setReportObjects(instruments)
                .setReportName("Акции")
                .setFields(new String[]{"ticker", "isin", "figi", "name", "currency", "lot", "minPriceIncrement"})
                .setHeaders(new String[]{"тикер", "isin", "figi", "наименование", "валюта", "лот", "шаг цены"});
    }

}
