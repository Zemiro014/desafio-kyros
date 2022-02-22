import NavBar from "components/Navbar";
import Finance from "pages/Finance";
import AddFinanceForm from "pages/forms/AddFinanceForm";
import AddProviderForm from "pages/forms/AddProviderForm";
import EditFinanceForm from "pages/forms/EditFinanceForm";
import EditProviderForm from "pages/forms/EditProviderForm";
import ProviderForm from "pages/forms/EditProviderForm";
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
        <Route path="/form_add_finance" element={<AddFinanceForm />}/>
        <Route path="/new_provider" element={<AddProviderForm />}/>
        <Route path="/form_finance/:id" element={<EditFinanceForm />}/>
        <Route path="/form_provider/:id" element={<EditProviderForm />}/>
      </Routes>
    </Router>
  );
};

export default Routas;
