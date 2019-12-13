import React, { useState, useEffect } from "react";
import "./Auth.css";
import cat1 from './cat1.png'
import vkLogo from './vk-logo.png'
import { 
  Wrapper, 
  Label, 
  Header, 
  ForSignup, 
  Footer, 
  ButtonSubmit, 
  Input } from "./Auth-styles"


  export default function Login(props) {
    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");

    useEffect( () => { document.title = "Auth at kotochat" }, [] );
  
    function handleSubmit(event) {
      event.preventDefault();
      alert('zachem nazhal? your name is ' + login + "pass " + password);
    }
  
    return (
      <Wrapper>
          <Header>
            <img src={cat1}  alt={"Logo Cat"} style={{width: "200px", height: "170px", margin:"0px"}}/>
            <p style={{color: "#f36f34", fontSize: "60px", fontFamily: "bold", margin:"0px", height: "70px" }}>kotochat</p>
            <p style={{fontSize: "22px", fontFamily: "Palatino, serif", fontWeight:"3", margin:"0px"}}>The place for a fluffy chill</p>
          </Header>
        <form onSubmit={handleSubmit}>
          <Label>Login</Label>
          <Input 
            type="login"
            value={login}
            onChange={e => setLogin(e.target.value)} 
          />
          <Label>Password</Label>
          <Input
            value={password}
            onChange={e => setPassword(e.target.value)}
            type="password"
          />
        <ButtonSubmit>
          Sign in
        </ButtonSubmit>
        </form>
        <ForSignup>
            <a>Don't have an account yet? </a>
            <a href="/register">Register now</a>
        </ForSignup>
        <Footer>
            © 2019 Kotochat
            <br/>
            <a href="https://vk.com/amsavchenko">
              <img src={vkLogo} alt="VK Logo" style={{width: "40px", height:"40px", marginTop: "5px"}}></img>
            </a>
        </Footer>
      </Wrapper>
    );
  }