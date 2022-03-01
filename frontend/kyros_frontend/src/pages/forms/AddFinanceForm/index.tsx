import "./styles.css";
import { useForm } from "react-hook-form";
import { CategoryType } from "types/CategoryType";
import { useEffect, useState } from "react";
import { AxiosParams } from "types/vendor/axios";
import axios from "axios";
import { BASE_URL_GATEWAY_API } from "util/request";
import { useNavigate } from "react-router-dom";

const AddFinanceForm = () => {
  const navigate = useNavigate();
  const [categories, setCategories] = useState<[CategoryType]>();
  const [inputCategoria, setInputCategoria] = useState('');

  useEffect(() => {
    const params: AxiosParams = {
      method: "GET",
      url: `${BASE_URL_GATEWAY_API}/categories`,
    };
    axios(params).then((resp) => {
      setCategories(resp.data as [CategoryType]);
    });
  }, []);

  const salvarFinanca = (data: any) => {
    var categoryObj = { id: "", category: "" };

    categories?.forEach((catego) => {
      if (catego.category.trim() === data.category.trim()) {
        categoryObj.id = catego.id;
        categoryObj.category = catego.category;
      }
    });

    const requestBody = {
      description: data.description,
      financeType: data.financeType,
      value: data.value,
      status: data.status,
      dueData: data.dueData,
      paymentData: data.paymentData,
      category: categoryObj,
    };
    axios({
      method: "post",
      url: `${BASE_URL_GATEWAY_API}/finances`,
      headers: {},
      data: requestBody,
    })
      .then(() => {
        alert("Salvo com sucesso");
        navigate("/finances")
      })
      .catch(() => {
        alert("DEU ERRADO");
      });
  };

  const mostrarModal = (modalId:any) => {
    const modal = document.getElementById(modalId)
    if(modal){
      modal.classList.add("mostrar")
      modal.addEventListener('click' , (ev) => {
        const evento = ev.target as HTMLElement
        if(evento.id == modalId || evento.id == 'btnCancelarModal' || evento.className=='fecharTelefoneModal'){
          modal.classList.remove('mostrar');          
        }
      })
      
    }
  };

  const salvarCategoria = (modalId: any) => {

    if(inputCategoria){
      const params: AxiosParams = {
        method: "POST",
        url: `${BASE_URL_GATEWAY_API}/categories`,
        data: {
          category: inputCategoria
        }
      };
      axios(params).then(res => {
        const modal = document.getElementById(modalId);
          if(modal){
              modal.classList.remove('mostrar');            
          }
          navigate("/finances")
      });
    }
    else{
      alert("Deve ser informado o valor da categoria")
    }
  };

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  return (
    <div className="container form_finance">
      <div className="card-post">
        <h1>Adicionar Finança</h1>
        <div className="line-post"></div>

        <div className="card-body-post">
          <form onSubmit={handleSubmit(salvarFinanca)}>
            <div className="row fields">
              <div className="col">
                <label>Categoria</label>
                <select className="form-control" {...register("category")}>
                  <option>...</option>
                  {categories?.map((categorie) => {
                    return (
                      <option key={categorie?.id}>{categorie?.category}</option>
                    );
                  })}
                </select>
                <p className="error-message">{errors.title?.message}</p>
              </div>
              <div className="col">
                <label>Tipo de finança</label>
                <select className="form-control" {...register("financeType")}>
                  <option>...</option>
                  <option>Despesa</option>
                  <option>Receita</option>
                </select>
                <p className="error-message">{errors.title?.message}</p>
              </div>

              <div className="col">
                <label>Status</label>
                <select className="form-control" {...register("status")}>
                  <option>...</option>
                  <option>Pago</option>
                  <option>Pendente</option>
                </select>
                <p className="error-message">{errors.title?.message}</p>
              </div>
            </div>

            <div className="row fields">
              <div className="col">
                <label>Valor R$</label>
                <input type="number" {...register("value")} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
              <div className="col">
                <label>Data de pagamento</label>
                <input type="date" {...register("paymentData")} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
              <div className="col">
                <label>Data de vencimento</label>
                <input type="date" {...register("dueData")} />
                <p className="error-message">{errors.title?.message}</p>
              </div>
            </div>

            <div className="fields">
              <label>Descrição</label>
              <input type="text" {...register("description")} />
              <p className="error-message">{errors.description?.message}</p>
            </div>

            <div className="btn-post">
              <button
                type="button"
                className="btn_cancelar"
                onClick={() => navigate("/finances")}
              >
                Cancelar
              </button>
              <button className="btn_atualizar" type="submit">
                Salvar
              </button>
            </div>
          </form>
          <button type="button" onClick={() => mostrarModal('modal-novo-telefone')}>Add Categoria</button>
        </div>
      </div>
      <div id="modal-novo-telefone" className="modal-container">
        <div className="modal-telefone container">
            <button className="fecharTelefoneModal">X</button>                       
          <div className="container">
            <div className="col-lg-12 well">                     
              <div className="row">
                <div className="col">
                  <div className="form-group">
                    <label>Categoria</label>
                    <input type="text"  className="form-control" placeholder="Digite aqui"
                    onInput={e => {
                      const evento = e.target as HTMLInputElement
                      setInputCategoria(evento.value)
                    } }/>
                  </div>
                </div>
              </div>
              <div className="row">
                <div className="col">
                  <div className="btns_modal pull-right">
                    <button type="button" id="btnCancelarModal" className="btn_cancelar">Cancelar</button>
                    <button type="button" id="btnSalvarNovaCategoria" className = "btn_salvar"  onClick={() => salvarCategoria('btnSalvarNovaCategoria')}>Salvar</button>
                  </div>
                </div>
              </div>                      
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddFinanceForm;
