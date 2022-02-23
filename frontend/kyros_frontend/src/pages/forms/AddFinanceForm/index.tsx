import "./styles.css";
import { useForm } from "react-hook-form";
import { CategoryType } from "types/CategoryType";
import { useEffect, useState } from "react";
import { AxiosParams } from "types/vendor/axios";
import axios from "axios";
import { BASE_URL, BASE_URL_PROVIDER, BASE_URL_GATEWAY_API } from "util/request";
import { useNavigate } from "react-router-dom";

const AddFinanceForm = () => {
  const navigate = useNavigate();
  const [categories, setCategories] = useState<[CategoryType]>();
  useEffect(() => {
    const params: AxiosParams = {
      method: "GET",
      url: `${BASE_URL}/categories`,
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
      url: `${BASE_URL}/finances`,
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
                className="btn_cancelar"
                onClick={() => navigate("/finances")}
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

export default AddFinanceForm;
