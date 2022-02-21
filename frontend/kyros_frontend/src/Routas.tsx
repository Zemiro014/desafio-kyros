import NavBar from "components/Navbar";
import Finance from "pages/Finance";
import FinanceForm from "pages/forms/FinanceForm";
import ProviderForm from "pages/forms/ProviderForm";
import Home from "pages/Home";
import Provider from "pages/Provider";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'

const Routas = () => {
  return (
    <Router>
      <NavBar />
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/finances" element={<Finance />}/>
        <Route path="/providers" element={ <Provider />}/>
        <Route path="/form_provider" element={<ProviderForm />}/>
        <Route path="/form_finance" element={<FinanceForm />}/>
      </Routes>
    </Router>
  );
};

export default Routas;
