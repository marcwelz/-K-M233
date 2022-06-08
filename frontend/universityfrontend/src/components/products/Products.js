import './style.css';
import React, { useEffect, useState } from "react";
import Cookies from 'universal-cookie';

function Products() {
    const cookies = new Cookies();
    const [userToken, setUserToken] = useState()
    const [product, setProduct] = useState([])

    useEffect(() => {
        const data = cookies.get('userToken')
        setUserToken(data.token)
    }, [])

    useEffect(() => {
        loadProducts()
    }, [userToken])

    function loadProducts() {
        const url = "http://localhost:8080/products"

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
            data => setProduct(data)
        )
    }

  return (
    <div className="products">
        <div className="products-container">
            <h1>Products</h1>
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Description</th>
                    </tr>
                </thead>
                <tbody>
                    {product.map(p => 
                        <tr>
                            <td scope="row">{p.id}</td>
                            <td>{p.name}</td>
                            <td>{p.description}</td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    </div>
  );
}

export default Products;