import React, { useState, useEffect } from "react";
import { Button, FormGroup, FormControl, FormLabel } from "react-bootstrap";
import "./Auth.css";
import cat1 from './cat1.png'
import vkLogo from './vk-logo.png'

export default function Login(props) {
    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");

    useEffect( () => { document.title = "Auth at kotochat" }, [] );
  
    function handleSubmit(event) {
      event.preventDefault();
      const { history } = props;
      history.push("/thePath")
    }
  
    return (
      <div className="Wrapper">
          <div className="Header">
            <img src={cat1}  alt={"Logo Cat"} style={{width: "200px", height: "170px", margin:"0px"}}/>
            <p style={{ color: "#f36f34", fontSize: "60px", fontFamily: "bold", margin:"0px", height: "70px" }}>kotochat</p>
            <p style={{fontSize: "22px", fontFamily: "Palatino, serif", fontWeight:"3", margin:"0px"}}>The place for a fluffy chill</p>
          </div>
        <form onSubmit={handleSubmit}>
          <FormGroup controlId="login" bsSize="large">
            <p className="Label">Login</p>
            <FormControl
              className="Input"
              type="login"
              value={login}
              onChange={e => setLogin(e.target.value)}
            />
          </FormGroup>
          <FormGroup controlId="password" bsSize="large">
            <p className="Label">Password</p>
            <FormControl
              className="Input"
              value={password}
              onChange={e => setPassword(e.target.value)}
              type="password"
            />
          </FormGroup>
          <Button className="ButtonSubmit" type="submit">
            Sign in
          </Button>
        </form>
        <div className="ForSignup">
            <a>Don't have an account yet? </a>
            <a href="/register">Register now</a>
        </div>
        <div className="Footer">
            © 2019 Kotochat
            <br/>
            <a href="https://vk.com/amsavchenko">
              <img src={vkLogo} alt="VK Logo" style={{width: "40px", height:"40px", marginTop: "5px"}}></img>
            </a>
        </div>
      </div>
    );
  }