import "../Css/Sidebar.css";

function Sidebar({ pageFunctions, ...rest }) {

  const { pageEntree, pageSide, pageCondiment, pageBeverage, pageTreat } =
    pageFunctions;

  const onClick = (event) => {
    switch(event.target.innerText) {
      case 'Entrees':
        pageEntree();
      break;
      case 'Sides':
        pageSide();
      break;
      case 'Condiments':
        pageCondiment();
      break;
      case 'Beverages':
        pageBeverage();
      break;
      case 'Treats':
        pageTreat();
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
