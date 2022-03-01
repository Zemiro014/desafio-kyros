package kyros.desafio.jeronimo.services;

import io.quarkus.test.junit.QuarkusTest;
import kyros.desafio.jeronimo.beans.to.response.ProviderResponseTO;
import kyros.desafio.jeronimo.exception.custom.ProviderException;
import kyros.desafio.jeronimo.service.api.ProviderServiceApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

@QuarkusTest
public class ProviderServiceTest {

    @Inject
    ProviderServiceApi serviceApi;

    @Test
    public void testFindAllProviderService(){
        List<ProviderResponseTO> providers = serviceApi.findAllProviders();
        Assertions.assertFalse(providers.isEmpty());
    }

    @Test
    public void testThrowsExceptionWhenProviderNotFound(){
        Assertions.assertThrows(ProviderException.class, () ->{
            ProviderResponseTO provider = serviceApi.findProviderById("65ba9e66-9962-11ec-85dc-473ba37e242f");
        });
    }
}
