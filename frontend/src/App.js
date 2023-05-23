import './Css/App.css';
import { BrowserRouter as Router, Route, Link, Routes } from "react-router-dom";
import Home from './Components/Home';
import Transactions from './Components/Transactions';

function App() {
  
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route exact path="/" Component={Home} />
          <Route exact path="/transactions" Component={Transactions} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
