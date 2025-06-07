import React, { useState } from 'react';
import usuarioService from '../services/usuarioService';
import { useNavigate } from 'react-router-dom';

const RegisterForm: React.FC = () => {
  const [nombre, setNombre] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [mensaje, setMensaje] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await usuarioService.register({ nombre, email, password });
      setMensaje('Registro exitoso');
      setTimeout(() => navigate('/login'), 1000);
    } catch (err) {
      setMensaje('Error en el registro');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Registro</h2>
      <input type="text" placeholder="Nombre" value={nombre} onChange={e => setNombre(e.target.value)} required />
      <input type="email" placeholder="Email" value={email} onChange={e => setEmail(e.target.value)} required />
      <input type="password" placeholder="Contraseña" value={password} onChange={e => setPassword(e.target.value)} required />
      <button type="submit">Registrarse</button>
      {mensaje && <p>{mensaje}</p>}
    </form>
  );
};

export default RegisterForm;
