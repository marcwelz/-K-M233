import './App.css';
import React, { useEffect, useState } from "react";
import { useNavigate } from 'react-router-dom';

function App() {
  const [folders, setFolders] = useState([])
  const [fileSizes, setFileSizes] = useState([])
  const [isLoaded, setLoaded] = useState(false) 

  useEffect(() => {
      loadFolders()
  }, [])

  useEffect(() => {
    calculateSize()
}, [folders])

useEffect(() => {
  setLoaded(true)
}, [fileSizes])

  function loadFolders() {
      const url = "http://localhost:8080/folder"

      const requestOptions = {
          method: 'GET',
          headers: ({ 
              'Content-Type': 'application/json'
          })
      };

      fetch(url, requestOptions)
      .then(response => response.json())
      .then(
          data => setFolders(data)
      )
  }

  function calculateSize() {
    const url = "http://localhost:8080/folder/getfoldersize"

    const requestOptions = {
        method: 'GET',
        headers: ({ 
            'Content-Type': 'application/json'
        })
    };

    // TODO daten werden geholt können jedoch noch nicht angezeigt werden
    fetch(url, requestOptions)
    .then(response => response.json())
    .then(
        data => setFileSizes(data)
    )
    
  }

  return (
    <div className="products">
        <div className="products-container">
            <h1>Modules</h1>
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Title</th>
                        <th scope="col">sortOrder</th>
                        <th scope="col">documents</th>
                        <th scope="col">Size</th>
                    </tr>
                </thead>
                <tbody>
                    {folders.map(f => 
                        <tr>
                            <td scope="row">{f.id}</td>
                            <td>{f.title}</td>
                            <td>{f.sortOrder}</td>
                            {f.documents.map(d => 
                            <td>
                              <table className="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Id</th>
                                        <th scope="col">Title</th>
                                        <th scope="col">sortOrder</th>
                                        <th scope="col">documentUrl</th>
                                        <th scope="col">size</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                      <td>{d.id}</td>
                                      <td>{d.title}</td>
                                      <td>{d.sortOrder}</td>
                                      <td>{d.documentUrl}</td>
                                      <td>{d.fileSizeInKB}</td>
                                    </tr>
                                </tbody>
                              </table>
                              </td>
                          )}
                            <td>{
                              isLoaded ? fileSizes.filter(s => s.id === f.id).map(size => 
                                    size.size + "kb"
                                ) : ""
                            }</td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    </div>
  );
}

export default App;
