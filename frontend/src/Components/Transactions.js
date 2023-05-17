import { useState } from "react";
import "../Css/Transactions.css";
import { useGetTransactionsQuery } from "../store";
import { Link } from "react-router-dom";

function Transactions() {
  const {
    data: transactions,
    TransactionsError,
    isFetchingTransactions,
  } = useGetTransactionsQuery();
  let transactionList = [];
  const [orderItems, setOrderItems] = useState([]);
  const [indClicked, setIndClicked] = useState(false);
  const [currentOrderId, setCurrentOrderId] = useState(-1);

  const onIndClick = (transaction) => {
    if (!indClicked && (currentOrderId === transaction.id || currentOrderId === -1)) {
        setIndClicked(!indClicked);
    } else if (indClicked && currentOrderId === transaction.id) {
        setIndClicked(!indClicked);
        return;
    }
    
    setOrderItems(transaction.order.map((item, index) => {
      return (
        <p key={index}>
          {item.name} ${item.price}
        </p>
      );
    }))
    setCurrentOrderId(transaction.id);
  };
  
  const orderDiv = (
    <div id="transactions-order-div" className="transactions-element">
      {orderItems}
    </div>
  );

  if (transactions) {
    transactionList = transactions.map((transaction) => {
      return (
        <div
          className="ind-transaction"
          onClick={() => onIndClick(transaction)}
        >
          <p className="ind-transaction-item">#{transaction.id}</p>
          <p className="ind-transaction-item">/ {transaction.date}</p>
          <p className="ind-transaction-item">/ ${transaction.total}</p>
        </div>
      );
    });
  }

  return (
    <div id="transactions">
        <Link className="link" to="/">
            <h2 id="home-btn" className="title">Home</h2>
        </Link>
        
      <div id="transaction-list" className="transactions-element">
        {transactionList}
      </div>
        {indClicked && orderDiv}
        
    </div>
  );
}

export default Transactions;
