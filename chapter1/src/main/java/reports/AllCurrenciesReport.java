package reports;

import ru.tinkoff.invest.openapi.model.rest.MarketInstrument;
import java.io.IOException;
import java.util.List;

public class AllCurrenciesReport extends CommonReport {

    public AllCurrenciesReport(List<MarketInstrument> instruments) throws IOException {
        super();
        this.setFileName("currencies.csv")
                .setReportObjects(instruments)
                .setReportName("Валюты")
                .setFields(new String[]{"ticker", "figi", "name", "currency", "lot", "minPriceIncrement"})
                .setHeaders(new String[]{"тикер", "figi", "наименование", "валюта", "лот", "шаг цены"});
    }

}
