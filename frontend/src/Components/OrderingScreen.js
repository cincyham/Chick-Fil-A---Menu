import { useDispatch, useSelector } from "react-redux";
import "../Css/OrderingScreen.css";
import { removeFromOrder, clearOrder, useCreateTransactionMutation } from "../store";
import { useState } from "react";

function OrderingScreen({ ...rest }) {
  const order = useSelector((state) => state.transaction.order);
  const dispatch = useDispatch();
  let total = 0;
  const date = new Date();
  const [createTransaction, results] =
    useCreateTransactionMutation();

  console.log(date);

  const clearOrderClick = () => {
    dispatch(clearOrder());
  };

  const orderItemClick = (index) => {
    dispatch(removeFromOrder(index));
  };

  const onTenderClick = () => {
    const transaction = {
      date: new Date(),
      total,
      order,
    };
    createTransaction(transaction);
  }

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
        <h2 onClick={onTenderClick} id="tender-button">Tender: {total.toFixed(2)}</h2>
        <h4 onClick={clearOrderClick} id="clear-btn">
          Clear Order
        </h4>
      </div>
    </div>
  );
}

export default OrderingScreen;
