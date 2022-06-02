import './style.css';
import { useNavigate } from 'react-router-dom';
import React, { useEffect, useState } from "react";
import Button from 'react-bootstrap/Button'

function TodoList() {
    const navigate = useNavigate();
  const [todoData, setTodoList] = useState([])
  const [taskCompleted, setTaskCompleted] = useState(0)

  useEffect(() => {
    // ohne Paramater => unendlich ausführen, mit Parameter => nur einmal ausführen
    fetchData()
  }, [])

  useEffect(() => {
      // ausführen wenn todoData geladen ist
    countCompleted()
  }, [todoData])

    function fetchData() {
      const url = "https://jsonplaceholder.typicode.com/todos"

      fetch(url)
      .then(response => response.json())
      .then(
          data => setTodoList(data)
      )
  }

  function countCompleted() {
      // let counter = 0;
      const counter = todoData.filter(todo => todo.completed)

      setTaskCompleted(counter.length)
  }

  return (
    <div className='main-container'>
      <h1>TodoList</h1>
      <Button style={{marginBottom: "10px"}} variant="primary" onClick={() => navigate("/album")}>Album</Button>
      <Button style={{margin: "0 0 10px 10px"}} variant="primary" onClick={() => navigate("/")}>home</Button>
      <table class="table">
        <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Title</th>
                <th scope="col">{taskCompleted}/{todoData.length} Completed</th>
            </tr>
        </thead>
            <tbody>
                {todoData.map(item => 
                    <tr>
                        <td scope="row">{item.id}</td>
                        <td>{item.title}</td>
                        <td>{item.completed ? "✅" : "❌"}</td>
                    </tr>
                )}
            </tbody>
        </table>
    </div>
  );
}

export default TodoList;
