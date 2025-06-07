import React, { useState } from 'react';
import usuarioService from '../services/usuarioService';

const LoginForm: React.FC = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [mensaje, setMensaje] = useState('');

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await usuarioService.login({ email, password });
      setMensaje('Login exitoso');
    } catch (err) {
      setMensaje('Error en el login');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Iniciar Sesión</h2>
      <input type="email" placeholder="Email" value={email} onChange={e => setEmail(e.target.value)} required />
      <input type="password" placeholder="Contraseña" value={password} onChange={e => setPassword(e.target.value)} required />
      <button type="submit">Ingresar</button>
      {mensaje && <p>{mensaje}</p>}
    </form>
  );
};

export default LoginForm;
