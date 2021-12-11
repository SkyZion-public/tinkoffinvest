import core.ApiConnector;
import core.ContextProvider;
import core.Parameters;
import reports.*;
import ru.tinkoff.invest.openapi.model.rest.MarketInstrument;

import java.util.ArrayList;
import java.util.List;

public class GetReports {

    public static void main(String[] args) throws Exception {
        Parameters parameters = new Parameters(args[0], Boolean.parseBoolean(args[1]));
        ApiConnector apiConnector = new ApiConnector(parameters);
        ContextProvider contextProvider = new ContextProvider(apiConnector);
        List<CommonReport> reports = new ArrayList<>();
        reports.add(new AllBondsReport(contextProvider.getBonds().getInstruments()));
        reports.add(new AllCurrenciesReport(contextProvider.getCurrencies().getInstruments()));
        reports.add(new AllStocksReport(contextProvider.getStocks().getInstruments()));
        reports.add(new AllEtfsReport(contextProvider.getEtfs().getInstruments()));
        reports.forEach(CommonReport<MarketInstrument>::doExport);
    }
}
