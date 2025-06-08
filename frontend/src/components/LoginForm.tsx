import React, { useState, useEffect } from 'react';
import usuarioService from '../services/usuarioService';
import { useNavigate, Link } from 'react-router-dom';
import { useAuth } from '../services/useAuth';

const LoginForm: React.FC = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [mensaje, setMensaje] = useState('');
  const navigate = useNavigate();
  const { login: loginAuth, isAuthenticated } = useAuth();

  useEffect(() => {
    if (isAuthenticated) {
      navigate('/partidos');
    }
  }, [isAuthenticated, navigate]);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      const data = await usuarioService.login({ email, password });
      if (data.token) {
        loginAuth(data.token);
        setMensaje('Login exitoso');
        setTimeout(() => navigate('/partidos'), 1000);
      } else {
        setMensaje('Error en el login');
      }
    } catch (err) {
      setMensaje('Error en el login');
    }
  };

  return (
    <>
      <form onSubmit={handleSubmit}>
        <h2>Iniciar Sesión</h2>
        <input id="login-email" name="email" type="email" placeholder="Email" value={email} onChange={e => setEmail(e.target.value)} required />
        <input id="login-password" name="password" type="password" placeholder="Contraseña" value={password} onChange={e => setPassword(e.target.value)} required />
        <button type="submit">Ingresar</button>
        {mensaje && <p>{mensaje}</p>}
      </form>
      <p>¿No tienes cuenta? <Link to="/register">Regístrate aquí</Link></p>
    </>
  );
};

export default LoginForm;
