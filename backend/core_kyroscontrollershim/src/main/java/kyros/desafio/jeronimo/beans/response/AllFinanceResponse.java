package kyros.desafio.jeronimo.beans.response;

import java.io.Serializable;
import java.util.List;

public class AllFinanceResponse implements Serializable {
    List<FinanceResponseTO> finances;

    public List<FinanceResponseTO> getFinances() {
        return finances;
    }

    public void setFinances(List<FinanceResponseTO> finances) {
        this.finances = finances;
    }
}
