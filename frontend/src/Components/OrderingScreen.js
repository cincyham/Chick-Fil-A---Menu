import { useDispatch, useSelector } from "react-redux";
import "../Css/OrderingScreen.css";
import { removeFromOrder, clearOrder } from "../store";

function OrderingScreen({ ...rest }) {
  const order = useSelector((state) => state.transaction.order);
  const dispatch = useDispatch();

  const clearOrderClick = () => {
    dispatch(clearOrder());
  };

  const orderItemClick = (index) => {
    dispatch(removeFromOrder(index));
  };

  let orderItems;

  orderItems = order.map((item, index) => {
    return (
      <p
        key={index}
        onClick={() => orderItemClick(index)}
        className="order-item"
      >
        {item}
      </p>
    );
  });

  return (
    <div {...rest}>
      <div id="checkout-list" className="ordering-screen-element"></div>
      <div id="order-div">{orderItems}</div>

      <div id="buttons" className="ordering-screen-element">
        <h2 id="tender-button">Tender</h2>
        <h4 onClick={clearOrderClick} id="clear-btn">
          Clear Order
        </h4>
      </div>
    </div>
  );
}

export default OrderingScreen;
