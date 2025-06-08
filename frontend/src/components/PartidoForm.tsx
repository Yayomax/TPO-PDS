import React, { useState } from 'react';
import partidoService from '../services/partidoService';
import { useAuth } from '../services/useAuth';

const PartidoForm: React.FC = () => {
  const { userId } = useAuth();
  const [deporte, setDeporte] = useState('');
  const [ubicacion, setUbicacion] = useState('');
  const [horario, setHorario] = useState('');
  const [duracion, setDuracion] = useState(60);
  const [cantidadJugadores, setCantidadJugadores] = useState(10);
  const [mensaje, setMensaje] = useState('');

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await partidoService.crearPartido(
        { deporte, ubicacion, horario, duracion, cantidadJugadores },
        Number(userId)
      );
      setMensaje('Partido creado');
    } catch (err) {
      setMensaje('Error al crear partido');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Crear Partido</h2>
      <input type="text" placeholder="Deporte" value={deporte} onChange={e => setDeporte(e.target.value)} required />
      <input type="text" placeholder="Ubicación" value={ubicacion} onChange={e => setUbicacion(e.target.value)} required />
      <input type="datetime-local" value={horario} onChange={e => setHorario(e.target.value)} required />
      <input type="number" placeholder="Duración (min)" value={duracion} onChange={e => setDuracion(Number(e.target.value))} required />
      <input type="number" placeholder="Cantidad de Jugadores" value={cantidadJugadores} onChange={e => setCantidadJugadores(Number(e.target.value))} required />
      <button type="submit">Crear</button>
      {mensaje && <p>{mensaje}</p>}
    </form>
  );
};

export default PartidoForm;
