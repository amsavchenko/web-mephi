import React, { useState, useEffect } from "react";
import "./Signup.css";
import catNew from './cat2.png'
import vkLogo from './vk-logo.png'
import { 
    Wrapper, 
    Label, 
    Header, 
    ForSignup, 
    Footer, 
    ButtonSubmit, 
    Input,
    Container,
    OrangeHeader,
    Greeting } from "./CustomStyles"


export default function Signup(props) {
    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");
    const [name, setName] = useState("");

    useEffect( () => { document.title = "Join kotochat" }, [] );

    function handleSubmit(event) {
        event.preventDefault();
        alert('your name is ' + login + "pass " + password);
    }

    return (
        <Wrapper>
            <Header>
                <img src={catNew}  alt={"Logo Cat"} style={{width: "300px", height: "200px", marginTop:"10px"}}/>
            </Header>
            <Container>
                <Header>
                    <p style={{color: "#f36f34", fontSize: "60px", fontFamily: "bold", margin:"0px", height: "70px" }}>kotochat</p>
                    <p style={{fontSize: "22px", fontFamily: "Palatino, serif", fontWeight:"3", margin:"0px"}}>The place for a fluffy chill</p>
                    <OrangeHeader>
                      <Greeting>Glad to see you!</Greeting>
                      <Greeting>Let's join Kotochat now</Greeting>
                    </OrangeHeader>
                </Header>
                <form className="BigForm" onSubmit={handleSubmit}>
                    <Label>Name</Label>
                    <Input 
                        type="name"
                        value={name}
                        onChange={e => setName(e.target.value)} 
                    />
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
                        Sign up
                    </ButtonSubmit>
                </form>
            </Container>
            <ForSignup>
                <a>Have an account already? </a>
                <a href="/auth">Login</a> now
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