import './style.css';
import React, { useEffect, useState } from "react";
import { useNavigate } from 'react-router-dom';
import Cookies from 'universal-cookie';

function Login() {
    const cookies = new Cookies();
    const navigate = useNavigate();
    const [inputPassword, setPassword] = useState("");
    const [inputUsername, setEmail] = useState("");
    const [emailError, setemailError] = useState("");
    const [errorMessage, setErrorMessage] = useState("")

    const loginSubmit = (e) => {
      e.preventDefault();
        const url = "http://localhost:8080/login"

        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username: inputUsername, password: inputPassword})
        };

        fetch(url, requestOptions)
        .then(response => response.json())
        .then(
          data => {
            if(data.status === 401) {
              setErrorMessage(data.message)
            } else {
              cookies.set('userToken', data)
              cookies.set('userName', inputUsername)
              navigate("/students")
            }
          }
        )
    };
  
    return (
      <div className="login">
        <div className="login-container">
            <div className='title'>
                <h3>Login</h3>
            </div>
          <div className="row d-flex justify-content-center">
              <form id="loginform" onSubmit={loginSubmit}>
                <div className="form-group">
                  <input
                  style={{margin: "10px 0"}}
                    type="text"
                    className="form-control"
                    id="EmailInput"
                    name="EmailInput"
                    aria-describedby="emailHelp"
                    placeholder="Enter username..."
                    onChange={(event) => setEmail(event.target.value)}
                  />
                  <small id="emailHelp" className="text-danger form-text">
                    {emailError}
                  </small>
                </div>
                <div className="form-group">
                  <input
                    style={{margin: "10px 0"}}
                    type="password"
                    className="form-control"
                    id="exampleInputPassword1"
                    placeholder="Password"
                    onChange={(event) => setPassword(event.target.value)}
                  />
                </div>
                <p className="text-danger form-text">{errorMessage}</p>
                <button type="submit" className="btn btn-primary">
                  Submit
                </button>
              </form>
            
          </div>
        </div>
      </div>
    );
}

export default Login;