import { useDispatch, useSelector } from "react-redux";
import "../Css/OrderingScreen.css";
import {
  removeFromOrder,
  clearOrder,
  useCreateTransactionMutation,
} from "../store";

import { Link } from "react-router-dom";

function OrderingScreen({ ...rest }) {
  const order = useSelector((state) => state.transaction.order);
  const dispatch = useDispatch();
  let total = 0;
  const date = new Date();
  const [createTransaction, results] = useCreateTransactionMutation();

  const clearOrderClick = () => {
    dispatch(clearOrder());
  };

  const orderItemClick = (index) => {
    dispatch(removeFromOrder(index));
  };

  const onTenderClick = () => {
    const date = new Date();
    const transaction = {
      date,
      total,
      order,
    };
    createTransaction(transaction);
    clearOrderClick();
  };

  let orderItems;

  orderItems = order.map((item, index) => {
    total += item.price;
    return (
      <p
        key={index}
        onClick={() => orderItemClick(index)}
        className="order-item"
      >
        {item.name} ${item.price}
      </p>
    );
  });

  return (
    <div {...rest}>
      <div id="order-div">{orderItems}</div>
      <div id="buttons" className="ordering-screen-element">
        <h2 onClick={onTenderClick} id="tender-button">
          Tender: {total.toFixed(2)}
        </h2>
        <div id="bottom-btns">
          <h4 onClick={clearOrderClick} id="clear-btn">
            Clear Order
          </h4>
          <Link className="link" to="/transactions">
            <h4 id="transactions-btn">Transactions</h4>
          </Link>
        </div>
      </div>
    </div>
  );
}

export default OrderingScreen;
