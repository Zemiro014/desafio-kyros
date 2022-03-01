package kyros.desafio.jeronimo.services;

import io.quarkus.test.junit.QuarkusTest;
import kyros.desafio.jeronimo.beans.to.responseTO.FinanceResponseTO;
import kyros.desafio.jeronimo.exceptions.custom.FinanceException;
import kyros.desafio.jeronimo.services.api.FinanceServiceApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

@QuarkusTest
public class FinanceServiceTest {

    @Inject
    FinanceServiceApi serviceApi;


    @Test
    public void testFindAllFinancesService(){
        List<FinanceResponseTO> finances = serviceApi.findAll();
        Assertions.assertFalse(finances.isEmpty());
    }

    @Test
    public void testThrowsExceptionWhenFinanceNotFound(){
        Assertions.assertThrows(FinanceException.class, () ->{
            FinanceResponseTO provider = serviceApi.findById("65ba9e66-9962-11ec-85dc-473ba37e242f");
        });
    }
}
