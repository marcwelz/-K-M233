import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from "./components/app/App";
import Login from "./components/login/Login"
import Products from './components/products/Products';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Router>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/login" element={<Login />} />
        <Route path="/products" element={<Products />} />
      </Routes>
    </Router>
  </React.StrictMode>
);
