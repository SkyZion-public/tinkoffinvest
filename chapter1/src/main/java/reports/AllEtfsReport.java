package reports;

import ru.tinkoff.invest.openapi.model.rest.MarketInstrument;
import java.io.IOException;
import java.util.List;

public class AllEtfsReport extends CommonReport {

    public AllEtfsReport(List<MarketInstrument> instruments) throws IOException {
        super();
        this.setFileName("etfs.csv")
                .setReportObjects(instruments)
                .setReportName("Биржевые фонды")
                .setFields(new String[]{"ticker", "isin", "figi", "name", "currency", "lot", "minPriceIncrement"})
                .setHeaders(new String[]{"тикер", "isin", "figi", "наименование", "валюта", "лот", "шаг цены"});
    }
}
