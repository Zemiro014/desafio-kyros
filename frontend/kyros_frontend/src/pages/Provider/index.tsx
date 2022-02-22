import axios from "axios";
import { useEffect, useState } from "react";
import { BiAddToQueue, BiEdit, BiTrash } from "react-icons/bi";
import { Link } from "react-router-dom";
import { ProviderType } from "types/ProviderType";
import { AxiosParams } from "types/vendor/axios";
import { BASE_URL, BASE_URL_PROVIDER } from "util/request";

const Provider = () => {
  const [providers, setProviders] = useState<[ProviderType]>();

  useEffect(() => {
    const params: AxiosParams = {
      method: "GET",
      url: `${BASE_URL_PROVIDER}/providers`,
    };
    axios(params).then((resp) => {
      console.log(resp.data);
      setProviders(resp.data as [ProviderType]);
    });
  }, []);

  const apagarProvider = () => {
    alert("Sem implementação para esta funcionalidade")
  }

  return (
    <table className="container table">
      <thead>
        <tr>
          <th scope="col">Nome</th>
          <th scope="col">Documento</th>
          <th scope="col">Email</th>
          <th scope="col">Telefone</th>
        </tr>
      </thead>
      <tbody>
        {providers?.map((provider) => {
          return (
            <tr key={provider?.id}>
              <th scope="row">{provider?.providerName}</th>
              <td>{provider?.cnpjCpf}</td>
              <td>{provider.email}</td>
              <td>{provider?.providerPhone}</td>
              <td>
                  <Link to={`/form_provider/${provider?.id}`}>
                    <BiEdit className="actionbtn" color="blue" size="1.2em" />
                  </Link>

                  <Link to="/new_provider">
                    <BiAddToQueue className="actionbtn" color="green" size="1.2em" />
                  </Link>

                  <Link to="/providers">
                    <BiTrash className="actionbtn" color="red" size="1.2em" onClick={apagarProvider} />
                  </Link>
                </td>        
            </tr>
          );
        })}
      </tbody>
    </table>
  );
};
export default Provider;
