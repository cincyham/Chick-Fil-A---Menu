import { useGetMenuQuery, addToOrder } from "../store";
import "../Css/ItemList.css";
import { useState, useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { GoChevronDown } from 'react-icons/go';

function ItemList({...rest}) {
  const { data: menu, menuError, isFetchingMenu } = useGetMenuQuery();
  const [items, setItems] = useState([]);
  const currentPage = useSelector(state => state.page.page);
  const dispatch = useDispatch();

  const onClick = (item) => {
    dispatch(addToOrder(item));
  }
  
  useEffect(() => {
    if (menu) {
      setItems(
        menu.map((item) => {
          if (item.type === currentPage) {
            return (
              <div key={item.id} className="item-div">
                <img
                  className="item-picture"
                  src={item.picture}
                  alt={item.name}
                  onClick={() => onClick(item)}
                />
                <GoChevronDown size={20 } className="down-arrow" />
                <div className="dropdown title">
                  <h4 className="dropdown-calories">
                    Calories: {item.calories}
                  </h4>
                </div>
              </div>
            );
          }
          
        })
      );
    }
  }, [menu, currentPage]);

  return (
    <div {...rest}>
      {items}
    </div>
  );
}

export default ItemList;
