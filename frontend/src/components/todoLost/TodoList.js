import './style.css';
import React, { useEffect, useState } from "react";

function TodoList() {
  const [todoData, setTodoList] = useState([])

  useEffect(() => {
    // ohne Paramater => unendlich ausführen, mit Parameter => nur einmal ausführen
    fetchData()
  }, [])

  async function fetchData() {
      const url = "https://jsonplaceholder.typicode.com/todos"

      fetch(url)
      .then(response => response.json())
      .then(
          // more functions with comma
          data => setTodoList(data)
      )
  }

  return (
    <div className='main-container'>
      <h1>TodoList</h1>
      <table class="table">
        <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Title</th>
                <th scope="col">Completed</th>
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
