import React from 'react';
import RegisterForm from './components/RegisterForm';
import LoginForm from './components/LoginForm';
import PartidoList from './components/PartidoList';
import PartidoForm from './components/PartidoForm';

const App: React.FC = () => {
  return (
    <div style={{ maxWidth: 600, margin: 'auto' }}>
      <h1>Gestión de Encuentros Deportivos</h1>
      <RegisterForm />
      <LoginForm />
      <PartidoForm />
      <PartidoList />
    </div>
  );
};

export default App;
