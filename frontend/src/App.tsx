import Login from 'pages/Login';
import Cadastro from 'pages/Cadastro';
import {
  BrowserRouter, Route, Routes
} from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Login />} />
        <Route path='/cadastro' element={<Cadastro />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
