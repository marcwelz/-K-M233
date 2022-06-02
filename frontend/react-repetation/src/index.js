import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import TodoList from './components/todoLost/TodoList';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import Album from './components/album/Album';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Router>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/todo" element={<TodoList />} />
        <Route path="/album" element={<Album />} />
      </Routes>
    </Router>
  </React.StrictMode>
);

reportWebVitals();
