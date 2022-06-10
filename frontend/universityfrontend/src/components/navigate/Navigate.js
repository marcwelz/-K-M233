import './style.css';
import React, { useEffect, useState } from "react";
import Cookies from 'universal-cookie';

function Navigate(props) {
    const cookies = new Cookies();
  return (
    <div className="navigate">
        <div className="navigate-container">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <a class="navbar-brand" href="#">Welcome {cookies.get("userName")}!</a>
                <button 
                    class="navbar-toggler" 
                    type="button"
                    data-toggle="collapse" 
                    data-target="#navbarNav" 
                    aria-expanded="false" 
                    aria-controls="navbarText"
                    aria-label="Toggle navigation"
                >
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarText">
                    <ul class="navbar-nav mr-auto">
                        <li class={props.active == "1" ? "nav-item active": "nav-item"}>
                            <a class="nav-link" href="/students">Students</a>
                        </li>
                        <li class={props.active == "2" ? "nav-item active": "nav-item"}>
                            <a class="nav-link" href="/modules">Modules</a>
                        </li>
                        <li class={props.active == "3" ? "nav-item active": "nav-item"}>
                            <a class="nav-link" href="/faculty">Faculty</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Logout</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
  );
}

export default Navigate;