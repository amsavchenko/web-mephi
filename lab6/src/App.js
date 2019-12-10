import React, {useEffect} from 'react';
import logo from './logo.svg';
import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import Login from './Auth';
import { Navbar, Nav, NavItem } from 'react-bootstrap';
import { LinkContainer } from "react-router-bootstrap";

function App() {
  return (
    <Router>
        {/*<Navbar bg="light" expand="lg">
          <Navbar.Brand href="/">Kotochat</Navbar.Brand>
          
            <Nav className="mr-auto">
              <Nav.Link href="/auth">Login</Nav.Link>
              <Nav.Link href="/register">Sign up</Nav.Link>
            </Nav>
          
  </Navbar>*/}
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

        {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
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

function Signup() {
  useEffect( () => { document.title = "signup" }, [] );
  return <h2>Nu davai</h2>;
}

export default App;
