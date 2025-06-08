import React, { useEffect, useState } from 'react';
import partidoService from '../services/partidoService';
import { useAuth } from '../services/useAuth';

const getNombreUsuario = () => {
  return localStorage.getItem('nombreUsuario') || '';
};

const PartidoList: React.FC = () => {
  const [partidos, setPartidos] = useState<any[]>([]);
  const { userId, isAuthenticated } = useAuth();
  const [loading, setLoading] = useState(false);
  const [joined, setJoined] = useState<{ [key: number]: boolean }>({});
  const [nombreUsuario, setNombreUsuario] = useState('');
  const [mensaje, setMensaje] = useState('');

  useEffect(() => {
    setNombreUsuario(getNombreUsuario());
    partidoService.listarTodos().then((data) => {
      setPartidos(data);
      // Marcar partidos a los que el usuario ya se unió
      if (userId) {
        const joinedMap: { [key: number]: boolean } = {};
        data.forEach((p: any) => {
          if (p.jugadores?.some((j: any) => j.id?.toString() === userId.toString())) {
            joinedMap[p.id] = true;
          }
        });
        setJoined(joinedMap);
      }
    });
  }, [userId, loading]);

  const handleUnirse = async (partidoId: number) => {
    if (!userId) return;
    setLoading(true);
    setMensaje('');
    try {
      await partidoService.agregarJugador(partidoId, { id: userId });
      setMensaje('¡Te has unido al partido!');
      setJoined((prev) => ({ ...prev, [partidoId]: true }));
      // Refrescar lista para actualizar cantidad de jugadores y botón
      const data = await partidoService.listarTodos();
      setPartidos(data);
    } catch (e) {
      setMensaje('Error al unirse al partido');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div>
      {isAuthenticated && userId && nombreUsuario && (
        <div style={{ marginBottom: 12 }}>
          <strong>Usuario en sesión:</strong> {nombreUsuario}
        </div>
      )}
      <h2>Partidos Disponibles</h2>
      {mensaje && <p style={{ color: 'green' }}>{mensaje}</p>}
      <ul>
        {partidos.map((p) => (
          <li key={p.id}>
            <strong>{p.deporte}</strong> - {p.ubicacion}<br />
            <span>Fecha y hora: {p.horario ? new Date(p.horario).toLocaleString() : '-'}</span><br />
            <span>Duración: {p.duracion} min</span><br />
            <span>Jugadores: {p.jugadores?.length ?? 0} / {p.cantidadJugadores}</span><br />
            {isAuthenticated && (
              <button
                onClick={() => handleUnirse(p.id)}
                disabled={joined[p.id] || loading}
                style={{ marginTop: 8 }}
              >
                {joined[p.id] ? 'Te has unido' : 'Unirse'}
              </button>
            )}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default PartidoList;
