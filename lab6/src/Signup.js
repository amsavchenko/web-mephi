import React, { useState, useEffect } from "react";
import "./styles/Signup.css";
import catNew from './images/cat2.png'
import vkLogo from './images/vk-logo.png'
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
    Greeting } from "./styles/CustomStyles"


export default function Signup(props) {
    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");
    const [name, setName] = useState("");

    useEffect( () => { document.title = "Join kotochat" }, [] );
    let reg = /[\u0400-\u04FF]/;

    function handleSubmit(event) {
        event.preventDefault();
        let isNameCorrect = true;
        for (let char of name){
            if (! reg.test(char)) { isNameCorrect = false; }
        }
        let exception = "";
        exception += (!isNameCorrect ? 'Name must contain only cyrillic characters ' : '');
        exception += (password.length < 6 ? '\nPassword must contain 6+ symbols' : '');
        if (exception.length != 0) {
            alert(exception);
        }
    }

    return (
        <Wrapper>
            <Header>
                <img src={catNew}  alt={"Logo Cat"} style={{width: "300px", marginTop:"10px"}}/>
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
                <img src={vkLogo} alt="VK Logo" style={{width: "40px", marginTop: "5px"}}></img>
                </a>
            </Footer>
        </Wrapper>
    );
}