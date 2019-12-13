import React, { useState, useEffect } from "react";
import { Wrapper, Header, Container, Footer } from "./styles/CustomStyles";
import spaceCat from './images/space-cat.png';
import "./styles/Home.css";
import vkLogo from './images/vk-logo.png';


export default function Home(props) {
    return (
        <Wrapper>
            <Header>
              <p style={{color: "#f36f34", fontSize: "60px", fontFamily: "bold", margin:"0px", height: "70px" }}>kotochat</p>
              <p style={{fontSize: "22px", fontFamily: "Palatino, serif", fontWeight:"3", margin:"0px"}}>The place for a fluffy chill</p>
            </Header>
            <Container>
              <div>
                  <h1>Hello, username!</h1>
                  <p>You have been logged in</p>
              </div>
              <img src={spaceCat}  alt={"Space Cat"} style={{height:"480px", marginTop:"10px"}}/>   
            </Container>
            <Footer>
                © 2019 Kotochat
                <br/>
                <a href="https://vk.com/amsavchenko">
                <img src={vkLogo} alt="VK Logo" style={{width: "40px", marginTop: "5px"}}></img>
                </a>
            </Footer>
        </Wrapper>
    );
}