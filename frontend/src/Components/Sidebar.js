import "../Css/Sidebar.css";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import { useDispatch } from "react-redux";
import { pageEntrees, pageSides, pageCondiments, pageBeverages, pageTreats } from '../store';

function Sidebar({ ...rest }) {

  const dispatch = useDispatch();

  const onClick = (event) => {
    switch(event.target.innerText) {
      case 'Entrees':
        dispatch(pageEntrees());
      break;
      case 'Sides':
        dispatch(pageSides());
      break;
      case 'Condiments':
        dispatch(pageCondiments())
      break;
      case 'Beverages':
        dispatch(pageBeverages())
      break;
      case 'Treats':
        dispatch(pageTreats())
      break;
    }
  }
  
  return (
    <div {...rest}>
      <div className="sidebar-element" onClick={onClick}>
        <h2>Entrees</h2>
      </div>
      <div className="sidebar-element" onClick={onClick}>
        <h2>Sides</h2>
      </div>
      <div className="sidebar-element" onClick={onClick}>
        <h2>Condiments</h2>
      </div>
      <div className="sidebar-element" onClick={onClick}>
        <h2>Beverages</h2>
      </div>
      <div className="sidebar-element" onClick={onClick}>
        <h2>Treats</h2>
      </div>
    </div>
  );
}

export default Sidebar;
