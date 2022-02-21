import "./styles.css";
const FinanceForm = () => {
  //console.log(props)
  return (
    <form className="container">
    <div className="form-row">
      <div className="col-4">
        <input type="text" className="form-control" placeholder="First name" />
      </div>
      <div className="col-4">
        <input type="text" className="form-control" placeholder="Last name" />
      </div>
    </div>
  </form>
  );
};
export default FinanceForm;
