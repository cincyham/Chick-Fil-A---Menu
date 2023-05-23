import Headbar from "./Headbar";
import ItemList from "./ItemList";
import OrderingScreen from "./OrderingScreen";
import Sidebar from "./Sidebar";
import "../Css/Home.css";
import { useCallback, useState } from "react";

function Home() {
  const [order, setOrder] = useState([]);
  const [page, setPage] = useState("Entree");

  const addToOrder = useCallback((item) => {
    setOrder((prevOrder) => [...prevOrder, item]);
  }, []);

  const removeFromOrder = (index) => {
    const newOrder = [...order];
    newOrder.splice(index, 1);
    setOrder(newOrder);
  };

  const clearOrder = () => {
    setOrder([]);
  };

  const OrderingScreenOrderFunctions = {
    removeFromOrder,
    clearOrder,
  };

  const pageEntree = () => {
    setPage("Entree");
  };

  const pageSide = () => {
    setPage("Side");
  };

  const pageCondiment = () => {
    setPage("Condiment");
  };

  const pageBeverage = () => {
    setPage("Beverage");
  };

  const pageTreat = () => {
    setPage("Treat");
  };

  const pageFunctions = {
    pageEntree,
    pageSide,
    pageCondiment,
    pageBeverage,
    pageTreat,
  };

  return (
    <div id="home">
      <Headbar id="headbar" className="home-element" />
      <Sidebar
        pageFunctions={pageFunctions}
        id="sidebar"
        className="home-element"
      />
      <ItemList
        addToOrder={addToOrder}
        page={page}
        id="item-list"
        className="home-element"
      />
      <OrderingScreen
        orderingScreenOrderFunctions={OrderingScreenOrderFunctions}
        order={order}
        id="ordering-screen"
        className="home-element"
      />
    </div>
  );
}

export default Home;
