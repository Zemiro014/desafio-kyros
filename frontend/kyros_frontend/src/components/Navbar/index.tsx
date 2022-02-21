import "./styles.css";
import 'bootstrap/js/src/collapse.js';
import { NavLink } from "react-router-dom";

const NavBar = () => {
  return (
    <nav className="navbar navbar-expand-md navbar-dark bg-primary main-nav">
      <div className="container-fluid">
        <NavLink to="/" className="nav-logo-text">
          <h4>Desafio Kyros</h4>
        </NavLink>
        <div className="collapse navbar-collapse" id="kyros-navbar">
          <ul className="navbar-nav offset-md-2 main-menu">
            <li>
              <NavLink to="/" >HOME</NavLink>
            </li>
            <li>
              <NavLink to="/finances">FINANÇAS</NavLink>
            </li>
            <li>
              <NavLink to="/providers">FORNECEDORES</NavLink>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default NavBar;
