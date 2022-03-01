import "./styles.css";
import { useForm } from "react-hook-form";
import { useNavigate, useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { AxiosParams } from "types/vendor/axios";
import axios from "axios";
import { BASE_URL_GATEWAY_API } from "util/request";
import { ProviderType } from "types/ProviderType";

const EditProviderForm = () => {

  const navigate = useNavigate();
  const { id } = useParams();
  const [provider, setProvider] = useState<ProviderType>();

  useEffect(() => {
    const params: AxiosParams = {
      method: "GET",
      url: `${BASE_URL_GATEWAY_API}/providers/${id}`,
      data:{}
    };
    axios(params).then((resp) => {
      console.log(resp.data);
      setProvider(resp.data);
    });
  }, []);

  const atualizarProvider = () => {
      alert("Sem implementação por enquanto");
  }
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  return (
    <div className="container form_finance">
      <div className="card-post">
        <h1>Manipular Fornecedores</h1>
        <div className="line-post"></div>

        <div className="card-body-post">
          <form>
            <div className="row fields">
              <div className="col">
                <label>Nome</label>
                <input type="text" value={provider?.providerName} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
            </div>

            <div className="row fields">
              <div className="col">
                <label>Documento</label>
                <input type="data" value={provider?.cnpjCpf} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
              <div className="col">
                <label>Celular</label>
                <input type="text" value={provider?.providerPhone} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
              <div className="fields col">
                <label>E-mail</label>
                <input type="text" value={provider?.email} />
                <p className="error-message">{errors.description?.message}</p>
              </div>
            </div>

            <div className="row fields">
              <div className="col">
                <label>Rua</label>
                <input type="data" value={provider?.providerAddress.street} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
              <div className="col">
                <label>Número</label>
                <input type="text" value={provider?.providerAddress.number} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
            </div>

            <div className="row fields">
              <div className="col">
                <label>CEP</label>
                <input type="data" value={provider?.providerAddress.cep} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
              <div className="col">
                <label>Estado</label>
                <input type="text" value={provider?.providerAddress.state} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
              <div className="fields col">
                <label>Cidade</label>
                <input type="text" value={provider?.providerAddress.city} />
                <p className="error-message">{errors.description?.message}</p>
              </div>
            </div>

            <div className="btn-post">
              <button
                className="btn_cancelar"
                onClick={() => navigate("/providers")}
              >
                Cancelar
              </button>
              <button className="btn_catualizar" onClick={atualizarProvider}>
                Atualizar
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};
export default EditProviderForm;
