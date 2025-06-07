import React from 'react';
import { useAuth } from './services/useAuth';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import RegisterForm from './components/RegisterForm';
import LoginForm from './components/LoginForm';
import PartidoList from './components/PartidoList';
import PartidoForm from './components/PartidoForm';

const App: React.FC = () => {
  const { isAuthenticated } = useAuth();
  return (
    <Router>
      <div style={{ maxWidth: 600, margin: 'auto' }}>
        <h1>Gestión de Encuentros Deportivos</h1>
        <Routes>
          <Route path="/register" element={<RegisterForm />} />
          <Route path="/login" element={<LoginForm />} />
          <Route
            path="/"
            element={isAuthenticated ? (
              <>
                <PartidoForm />
                <PartidoList />
              </>
            ) : (
              <Navigate to="/login" />
            )}
          />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
