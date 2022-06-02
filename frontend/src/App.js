import './App.css';
import React, { useEffect, useState } from "react";

function App() {
  const [inputWord, setInputWord] = useState("")

  useEffect(() => {
    // ohne Paramater => unendlich ausführen, mit Parameter => nur einmal ausführen
    fetchData()
  }, [])

  function fetchData() {

  }

  return (
    <div className='main-container'>
      <h1>Hallo</h1>
      <input type="text" value={inputWord} placeholder='Gib deine Antwort ein...' onChange={e => setInputWord(e.target.value)}></input>
      {inputWord}
    </div>
  );
}

export default App;
