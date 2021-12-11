package core;

import lombok.extern.slf4j.Slf4j;
import ru.tinkoff.invest.openapi.OpenApi;
import ru.tinkoff.invest.openapi.model.rest.SandboxRegisterRequest;
import ru.tinkoff.invest.openapi.okhttp.OkHttpOpenApi;

@Slf4j
public class ApiConnector implements AutoCloseable {

    private final Parameters parameters;
    private OpenApi openApi;

    public ApiConnector(Parameters parameters) {
        this.parameters = parameters;
    }

    public OpenApi getOpenApi() throws Exception {
        if (openApi == null) {
            close();
            log.info("Create TINKOFF INVEST API connection");
            openApi = new OkHttpOpenApi(parameters.getToken(), parameters.isSandBoxMode());
            if (openApi.isSandboxMode()) {
                openApi.getSandboxContext().performRegistration(new SandboxRegisterRequest()).join();
            }
        }
        return openApi;
    }

    @Override
    public void close() throws Exception {
        if (openApi != null) {
            openApi.close();
            log.info("TINKOFF INVEST API connection has been closed");
        }
    }
}
