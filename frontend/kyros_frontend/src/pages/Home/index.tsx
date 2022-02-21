import { ReactComponent as MainImage } from "assets/images/main-image.svg";
import ButtonIcon from "components/ButtonIcon";
import { Link } from "react-router-dom";
import "./styles.css";
const Home = () => {
  return (
    <>
      <div className="home-container">
        <div className="base-card home-card">
          <div className="home-content-container">
            <div>
              <h1>Sistema de controle de finanças e fornecedores</h1>
              <p>
                Ajudaremos você a controlar as suas finanças bem como a gerenciar os seus fornecedores.
              </p>
            </div>
            <div>
              <Link to="/finances">
                <ButtonIcon text="COMEÇAR" />
              </Link>
            </div>
          </div>
          <div className="home-image-container">
            <MainImage />
          </div>
        </div>
      </div>
    </>
  );
};

export default Home;
