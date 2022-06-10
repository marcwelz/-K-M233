import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from "./components/app/App";
import Login from "./components/login/Login"
import Students from './components/students/Students';
import Error from './components/error/Error';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import Modules from './components/modules/Modules';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Router>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/login" element={<Login />} />
        <Route path="/students" element={<Students />} />
        <Route path="/error" element={<Error />} />
        <Route path="/modules" element={<Modules />} />
      </Routes>
    </Router>
  </React.StrictMode>
);
