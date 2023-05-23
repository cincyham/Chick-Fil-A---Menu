import { useGetMenuQuery } from "../store";
import "../Css/ItemList.css";
import { useState, useEffect } from "react";
import { GoChevronDown } from "react-icons/go";

function ItemList({ page, addToOrder, ...rest }) {
  const { data: menu, menuError, isFetchingMenu } = useGetMenuQuery();
  const [items, setItems] = useState([]);

  const onClick = (item) => {
    addToOrder(item);
  };
  
  useEffect(() => {
    if (menu) {
      setItems(
        menu.map((item) => {
          if (item.type === page) {
            let showToppings = false;
            if (item.toppings.length > 0) {
              showToppings = true;
            }
            const toppings = (
              <div id="toppings-div">
                <h4 className="dropdown-toppings-title title">
                    Ingredients:
                  </h4>
                  <h4 className="dropdown-topppings-items title">
                    {item.toppings.join(", ")}
                  </h4>
              </div>
              
            )
            return (
              <div key={item.id} className="item-div">
                <img
                  className="item-picture"
                  src={item.picture}
                  alt={item.name}
                  onClick={() => onClick(item)}
                />
                <GoChevronDown size={20} className="down-arrow" />
                <div className="dropdown title">
                  <h4 className="dropdown-calories title">
                    Calories: {item.calories}
                  </h4>
                  {showToppings && toppings}
                </div>
              </div>
            );
          }
        })
      );
    }
  }, [menu, page]);

  return <div {...rest}>{items}</div>;
}

export default ItemList;
