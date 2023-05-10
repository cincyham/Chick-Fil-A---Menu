import logo from './logo.svg';
import './Css/App.css';
import { BrowserRouter as Router, Route, Link, Routes } from "react-router-dom";
import Home from './Components/Home';
import { useDispatch } from 'react-redux';
import { pageEntrees } from './store';

function App() {

  const dispatch = useDispatch();

  dispatch(pageEntrees());
  
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route exact path="/" Component={Home} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
