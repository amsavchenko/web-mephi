import React, {useEffect} from 'react';
import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import Login from './Auth';
import Signup from './Signup';
import { Navbar, Nav, NavItem } from 'react-bootstrap';
import { LinkContainer } from "react-router-bootstrap";

function App() {
  return (
    <Router>
        <nav>
          <div className="Navigation">
            <div>
              <Link to="/">Home</Link>
            </div>
            <div>
              <Link to="/auth">Auth</Link>
            </div>
            <div>
              <Link to="/register">Sign up</Link>
            </div>
          </div>
        </nav>

        <Switch>
          <Route path="/auth">
            <Login />
          </Route>
          <Route path="/register">
            <Signup />
          </Route>
          <Route path="/">
            <Home />
          </Route>
        </Switch>
    </Router>
  );
}

function Home() {
  useEffect( () => { document.title = "home" }, [] );
  return <h2>Heellloooo man</h2>;
}

export default App;
