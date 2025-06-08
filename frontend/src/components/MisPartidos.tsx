import React, { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import partidoService from '../services/partidoService';
import { useAuth } from '../services/useAuth';

const getNombreUsuario = () => {
  return localStorage.getItem('nombreUsuario') || '';
};

const MisPartidos: React.FC = () => {
  const { userId } = useAuth();
  const navigate = useNavigate();
  const [partidos, setPartidos] = useState<any[]>([]);
  const [nombreUsuario, setNombreUsuario] = useState('');
  const [eliminados, setEliminados] = useState<number[]>([]);
  const [confirmar, setConfirmar] = useState<number | null>(null);

  useEffect(() => {
    setNombreUsuario(getNombreUsuario());
    if (userId) {
      partidoService.listarPorUsuario(Number(userId)).then(setPartidos);
    }
  }, [userId]);

  const handleSalir = async (partidoId: number) => {
    if (!userId) return;
    await partidoService.salirDePartido(partidoId, Number(userId));
    setPartidos(partidos.filter(p => p.id !== partidoId));
  };

  const handleCancelar = async (partidoId: number) => {
    if (!userId) return;
    await partidoService.cancelarPartido(partidoId, Number(userId));
    setPartidos(partidos.filter(p => p.id !== partidoId));
  };

  const handleEliminar = (partidoId: number) => {
    if (confirmar === partidoId) {
      setEliminados([...eliminados, partidoId]);
      setConfirmar(null);
    } else {
      setConfirmar(partidoId);
    }
  };

  if (!userId) return null;

  return (
    <div>
      {userId && nombreUsuario && (
        <div style={{ marginBottom: 12 }}>
          <strong>Usuario en sesión:</strong> {nombreUsuario}
        </div>
      )}
      <h2>Mis Partidos</h2>
      <div style={{ marginBottom: 16 }}>
        <button onClick={() => navigate(-1)} style={{ marginRight: 8 }}>Volver</button>
        <Link to="/">Ir a Partidos Disponibles</Link>
      </div>
      <ul>
        {partidos.length === 0 && <li>No estás inscripto en ningún partido.</li>}
        {partidos.filter(p => !eliminados.includes(p.id)).map((p) => (
          <li key={p.id}>
            {p.deporte} - {p.ubicacion} - {p.estado}
            <button style={{ marginLeft: 12 }} onClick={() => handleEliminar(p.id)}>
              {confirmar === p.id ? 'Confirmar eliminación' : 'Eliminar'}
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default MisPartidos;
