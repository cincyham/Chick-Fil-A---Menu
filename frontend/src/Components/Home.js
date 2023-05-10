import Headbar from './Headbar';
import ItemList from './ItemList';
import OrderingScreen from './OrderingScreen';
import Sidebar from './Sidebar';
import '../Css/Home.css';

function Home() {
    return (
      <div id="home">
        <Headbar id="headbar" className="home-element" />
        <Sidebar id="sidebar" className="home-element" />
        <ItemList id="item-list" className="home-element" />
        <OrderingScreen id="ordering-screen" className="home-element" />
      </div>
    );
}

export default Home;