import { useForm } from "react-hook-form";
import axios from "axios";
import { BASE_URL_GATEWAY_API } from "util/request";
import { useNavigate } from "react-router-dom";

const AddProviderForm = () => {
  const navigate = useNavigate();

  const salvarProvider = (data: any) => {
     if(data.cnpjCpf.length === 11){
        data.cpf = data.cnpjCpf;        
     }
     else{
        data.cnpj = data.cnpjCpf;
     }
     delete data.cnpjCpf;
    console.log(data);
    axios({
      method: "post",
      url: `${BASE_URL_GATEWAY_API}/providers`,
      headers: {},
      data: data,
    })
      .then((resp) => {
        console.log(resp.data);
        alert("Salvo com sucesso");
        navigate("/providers");
      })
      .catch(() => {
        alert("DEU ERRADO");
      });
  };

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  return (
    <div className="container form_finance">
      <div className="card-post">
        <h1>Adicionar Fornecedores</h1>
        <div className="line-post"></div>

        <div className="card-body-post">
          <form onSubmit={handleSubmit(salvarProvider)}>
            <div className="row fields">
              <div className="col">
                <label>Nome</label>
                <input type="text" {...register("providerName")} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
            </div>

            <div className="row fields">
              <div className="col">
                <label>Documento</label>
                <input type="data" {...register("cnpjCpf")} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
              <div className="col">
                <label>Celular</label>
                <input type="text" {...register("providerPhone")} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
              <div className="fields col">
                <label>E-mail</label>
                <input type="text" {...register("email")} />
                <p className="error-message">{errors.description?.message}</p>
              </div>
            </div>

            <div className="row fields">
              <div className="col">
                <label>Rua</label>
                <input type="data" {...register("providerAddress.street")} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
              <div className="col">
                <label>Número</label>
                <input type="text" {...register("providerAddress.number")} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
            </div>

            <div className="row fields">
              <div className="col">
                <label>CEP</label>
                <input type="data" {...register("providerAddress.cep")} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
              <div className="col">
                <label>Estado</label>
                <input type="text" {...register("providerAddress.state")} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
              <div className="fields col">
                <label>Cidade</label>
                <input type="text" {...register("providerAddress.city")} />
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
              <button className="btn_catualizar" type="submit">
                Salvar
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};
export default AddProviderForm;
