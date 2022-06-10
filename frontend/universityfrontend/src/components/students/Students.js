import './style.css';
import React, { useEffect, useState } from "react";
import Cookies from 'universal-cookie';
import Navigate from '../navigate/Navigate';
import { useNavigate } from 'react-router-dom';

function Students() {
    const cookies = new Cookies();
    const [userToken, setUserToken] = useState()
    const [students, setStudents] = useState([])
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
        const url = "http://localhost:8080/students"

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
            data => setStudents(data)
        )
    }

  return (
    <div className="products">
        <div className="products-container">
            <h1>Students</h1>
            <Navigate active="1"></Navigate>
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Matriculation Number</th>
                        <th scope="col">Firstname</th>
                        <th scope="col">Lastname</th>
                        <th scope="col">Street</th>
                        <th scope="col">Zipcode</th>
                        <th scope="col">City</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Birthday Date</th>
                        <th scope="col">Modules</th>
                    </tr>
                </thead>
                <tbody>
                    {students.map(s => 
                        <tr>
                            <td scope="row">{s.id}</td>
                            <td>{s.matriculationNumber}</td>
                            <td>{s.firstname}</td>
                            <td>{s.lastname}</td>
                            <td>{s.street}</td>
                            <td>{s.zipcode}</td>
                            <td>{s.city}</td>
                            <td>{s.phone}</td>
                            <td>{s.birthdayDate}</td>
                            <td>{s.modules}</td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    </div>
  );
}

export default Students;