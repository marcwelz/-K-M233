import './App.css';
import Button from 'react-bootstrap/Button'
import { useNavigate } from 'react-router-dom';

function App() {
  const navigate = useNavigate();
  return (
    <div className="App">
      <h1>Hallo</h1>
      <Button variant="primary" onClick={() => navigate("/login")}>Login</Button>
    </div>
  );
}

export default App;
