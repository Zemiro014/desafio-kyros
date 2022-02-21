import axios from "axios";
import { useEffect, useState } from "react";
import { FinanceType } from "types/FinanceType";
import { AxiosParams } from "types/vendor/axios";
import { BASE_URL } from "util/request";
import { BiEdit, BiTrash } from "react-icons/bi";
import "./styles.css";
import { Link } from "react-router-dom";

const Finance = () => {
  const [finances, setFinances] = useState<[FinanceType]>();
  useEffect(() => {
    const params: AxiosParams = {
      method: "GET",
      url: `${BASE_URL}/finances`,
    };
    axios(params).then((resp) => {
      setFinances(resp.data as [FinanceType]);
    });
  }, []);
  return (
    <table className="finance_table container table table-striped">
      <thead className="thead-dark">
        <tr>
          <th scope="col">Tipo de Finança</th>
          <th scope="col">Descrição</th>
          <th scope="col">Valor</th>
          <th scope="col">Status</th>
          <th scope="col">Data de Pagamento</th>
          <th scope="col">Data de Vencimento</th>
          <th scope="col">Ações</th>
        </tr>
      </thead>
      <tbody>
        {finances?.map((finance) => {
          return (
            <tr key={finance.id}>
              <th scope="row">{finance.financeType}</th>
              <td>{finance.description}</td>
              <td>{finance.value}</td>
              <td>{finance.status}</td>
              <td>{finance.paymentData}</td>
              <td>{finance.dueData}</td>
              <td>
                <Link to="/form_finance">
                  <BiEdit color="blue" size="1.2em"/>
                </Link>

                <Link to="/">
                  <BiTrash color="red" size="1.2em"/>
                </Link>
              </td>
            </tr>
          );
        })}
      </tbody>
    </table>
  );
};
export default Finance;
