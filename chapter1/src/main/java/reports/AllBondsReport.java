package reports;

import ru.tinkoff.invest.openapi.model.rest.MarketInstrument;
import java.io.IOException;
import java.util.List;

public class AllBondsReport extends CommonReport {

    public AllBondsReport(List<MarketInstrument> instruments) throws IOException {
        super();
        this.setFileName("bonds.csv")
                .setReportObjects(instruments)
                .setReportName("Облигации")
                .setFields(new String[]{"ticker", "isin", "figi", "name", "currency", "lot", "minPriceIncrement"})
                .setHeaders(new String[]{"тикер", "isin", "figi", "наименование", "валюта", "лот", "шаг цены"});
    }

}
