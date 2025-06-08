import React, { useState } from 'react';
import partidoService from '../services/partidoService';

const PartidoForm: React.FC = () => {
  const [deporte, setDeporte] = useState('');
  const [ubicacion, setUbicacion] = useState('');
  const [horario, setHorario] = useState('');
  const [duracion, setDuracion] = useState(60);
  const [cantidadJugadores, setCantidadJugadores] = useState(10);
  const [mensaje, setMensaje] = useState('');

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await partidoService.crearPartido({ deporte, ubicacion, horario, duracion, cantidadJugadores });
      setMensaje('Partido creado');
    } catch (err) {
      setMensaje('Error al crear partido');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Crear Partido</h2>
      <label htmlFor="deporte">Deporte</label>
      <input id="deporte" name="deporte" type="text" placeholder="Deporte" value={deporte} onChange={e => setDeporte(e.target.value)} required />
      <label htmlFor="ubicacion">Ubicación</label>
      <input id="ubicacion" name="ubicacion" type="text" placeholder="Ubicación" value={ubicacion} onChange={e => setUbicacion(e.target.value)} required />
      <label htmlFor="horario">Horario</label>
      <input id="horario" name="horario" type="datetime-local" value={horario} onChange={e => setHorario(e.target.value)} required />
      <label htmlFor="duracion">Duración (minutos)</label>
      <input id="duracion" name="duracion" type="number" placeholder="Duración (min)" value={duracion} onChange={e => setDuracion(Number(e.target.value))} required />
      <label htmlFor="cantidadJugadores">Cantidad de Jugadores</label>
      <input id="cantidadJugadores" name="cantidadJugadores" type="number" placeholder="Cantidad de Jugadores" value={cantidadJugadores} onChange={e => setCantidadJugadores(Number(e.target.value))} required />
      <button type="submit">Crear</button>
      {mensaje && <p>{mensaje}</p>}
    </form>
  );
};

export default PartidoForm;
