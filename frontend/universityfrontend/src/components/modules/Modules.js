import './style.css';
import React, { useEffect, useState } from "react";
import Cookies from 'universal-cookie';
import Navigate from '../navigate/Navigate';
import { useNavigate } from 'react-router-dom';

function Modules() {
    const cookies = new Cookies();
    const [userToken, setUserToken] = useState()
    const [modules, setModules] = useState([])
    const navigate = useNavigate()

    useEffect(() => {
        try {
            const data = cookies.get('userToken')
            setUserToken(data.token)
        } catch {
            navigate("/error")
        }
    }, [])

    useEffect(() => {
        loadProducts()
    }, [userToken])

    function loadProducts() {
        const url = "http://localhost:8080/modules"

        const requestOptions = {
            method: 'GET',
            headers: ({ 
                'Content-Type': 'application/json',
                'Authorization': "bearer " + userToken
            })
        };

        fetch(url, requestOptions)
        .then(response => response.json())
        .then(
            data => setModules(data)
        )
    }

  return (
    <div className="products">
        <div className="products-container">
            <h1>Students</h1>
            <Navigate></Navigate>
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Shortname</th>
                        <th scope="col">Title</th>
                        <th scope="col">ECTS Points</th>
                    </tr>
                </thead>
                <tbody>
                    {modules.map(m => 
                        <tr>
                            <td scope="row">{m.id}</td>
                            <td>{m.shortname}</td>
                            <td>{m.title}</td>
                            <td>{m.ects_points}</td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    </div>
  );
}

export default Modules;