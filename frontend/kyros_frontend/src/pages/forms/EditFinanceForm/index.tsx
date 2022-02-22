import "./styles.css";
import { useForm } from "react-hook-form";
import { FinanceType } from "types/FinanceType";
import { useNavigate, useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { AxiosParams } from "types/vendor/axios";
import axios from "axios";
import { BASE_URL } from "util/request";

const EditFinanceForm = () => {
  const navigate = useNavigate();
    const { id } = useParams();
    const [finance, setFinance] = useState<FinanceType>();
    useEffect(() => {
        const params: AxiosParams = {
            method: "GET",
            url: `${BASE_URL}/finances/${id}`,
          };
          axios(params).then((resp) => {
            console.log(resp.data)
            setFinance(resp.data);
          });
    }, []);
    
    const atualizarFinanca = () => {
      alert("Sem implementação por enquanto para esta funcionalidade");
    }
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  return (
    <div className="container form_finance">
      <div className="card-post">
        <h1>Manipular Finança</h1>
        <div className="line-post"></div>

        <div className="card-body-post">
          <form>
            <div className="row fields">
              <div className="col">
                <label>Tipo de finança</label>
                <select className="form-control" value={finance?.financeType}>
                  <option>...</option>
                  <option>Despesa</option>
                  <option>Receita</option>
                </select>
                <p className="error-message">{errors.title?.message}</p>
              </div>
              <div className="col">
                <label>Valor R$</label>
                <input type="number" value={finance?.value} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
              <div className="col">
                <label>Status</label>
                <select className="form-control" value={finance?.status}>
                  <option>...</option>
                  <option>Pago</option>
                  <option>Pendente</option>
                </select>
                <p className="error-message">{errors.title?.message}</p>
              </div>
            </div>

            <div className="row fields">
              <div className="col">
                <label>Data de pagamento</label>
                <input type="data" value={finance?.paymentData}/>
                <p className="error-message">{errors.title?.message}</p>
              </div>
              <div className="col">
                <label>Data de vencimento</label>
                <input type="text" value={finance?.dueData}/>
                <p className="error-message">{errors.title?.message}</p>
              </div>
            </div>

            <div className="fields">
              <label>Descrição</label>
              <input type="text" value={finance?.description}/>
              <p className="error-message">{errors.description?.message}</p>
            </div>

            <div className="btn-post">
            <button className="btn_cancelar" onClick={() => navigate("/finances")}>
                Cancelar
              </button>
              <button className="btn_catualizar" onClick={atualizarFinanca}>Atualizar</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};
export default EditFinanceForm;
