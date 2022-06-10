import './style.css';
import React, { useEffect, useState } from "react";
import Cookies from 'universal-cookie';

function Error() {
  return (
    <div className="error">
        <div className="error-container">
            <h1>Error</h1>
        </div>
    </div>
  );
}

export default Error;