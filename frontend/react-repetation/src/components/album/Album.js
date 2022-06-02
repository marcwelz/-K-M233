import './style.css';
import { useNavigate } from 'react-router-dom';
import Button from 'react-bootstrap/Button'
import React, { useEffect, useState } from "react";

function Album() {
    const navigate = useNavigate();
  const [albumData, setAlbumData] = useState([])
  const [imageData, setImageData] = useState([])

  useEffect(() => {
    // ohne Paramater => unendlich ausführen, mit Parameter => nur einmal ausführen
    fetchAlbumData()
  }, [])

  useEffect(() => {
    fetchImageData()
  }, [albumData])

    function fetchImageData() {
        const url = "https://jsonplaceholder.typicode.com/photos"

        fetch(url)
        .then(response => response.json())
        .then(
            data => setImageData(data)
        )
    }

  function fetchAlbumData() {
        const url = "https://jsonplaceholder.typicode.com/albums"

        fetch(url)
        .then(response => response.json())
        .then(
            data => setAlbumData(data)
        )
    }  

  return (
    <div className='main-container'>
      <h1>Album</h1>
      <Button style={{marginBottom: "10px"}} variant="primary" onClick={() => navigate("/todo")}>Todo List</Button>
      <Button style={{margin: "0 0 10px 10px"}} variant="primary" onClick={() => navigate("/")}>home</Button>
      <table class="table">
        <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Title</th>
                <th scope="col">Album Cover</th>
            </tr>
        </thead>
            <tbody>
                {albumData.map(albumData => 
                    <tr>
                        <td scope="row">{albumData.id}</td>
                        <td>{albumData.title}</td>
                        <td>
                            {imageData.filter(image => image.albumId === albumData.id).map(foundImage => 
                                <img style={{width:"25px"}} src={foundImage.thumbnailUrl} />
                                )}
                            </td>
                    </tr>
                )}
            </tbody>
        </table>
    </div>
  );
}

export default Album;
