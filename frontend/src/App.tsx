import React from 'react';
import { useAuth } from './services/useAuth';
import { BrowserRouter as Router, Routes, Route, Navigate, useLocation, Link } from 'react-router-dom';
import RegisterForm from './components/RegisterForm';
import LoginForm from './components/LoginForm';
import PartidoList from './components/PartidoList';
import PartidoForm from './components/PartidoForm';
import MisPartidos from './components/MisPartidos';

const AppRoutes: React.FC<{ isAuthenticated: boolean; logout: () => void }> = ({ isAuthenticated, logout }) => {
  const location = useLocation();
  return (
    <div style={{ maxWidth: 600, margin: 'auto' }}>
      <h1>Gestión de Encuentros Deportivos</h1>
      {(isAuthenticated && (location.pathname === '/partidos' || location.pathname === '/mis-partidos')) && (
        <div style={{ marginBottom: 16 }}>
          <Link to="/mis-partidos" style={{ marginRight: 12 }}>Mis Partidos</Link>
          <Link to="/partidos" style={{ marginRight: 12 }}>Partidos Disponibles</Link>
          <button style={{ float: 'right', marginTop: -50 }} onClick={logout}>
            Cerrar sesión
          </button>
        </div>
      )}
      <Routes>
        <Route path="/" element={<LoginForm />} />
        <Route path="/register" element={<RegisterForm />} />
        <Route path="/login" element={<LoginForm />} />
        <Route
          path="/partidos"
          element={isAuthenticated ? (
            <>
              <PartidoForm />
              <PartidoList />
            </>
          ) : (
            <Navigate to="/" replace />
          )}
        />
        <Route
          path="/mis-partidos"
          element={isAuthenticated ? <MisPartidos /> : <Navigate to="/" replace />}
        />
        <Route path="*" element={<Navigate to="/" replace />} />
      </Routes>
    </div>
  );
};

const App: React.FC = () => {
  const { isAuthenticated, logout } = useAuth();
  return (
    <Router>
      <AppRoutes isAuthenticated={isAuthenticated} logout={logout} />
    </Router>
  );
};

export default App;
