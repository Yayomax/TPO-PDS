import React, { useEffect, useState } from 'react';
import partidoService from '../services/partidoService';

const PartidoList: React.FC = () => {
  const [partidos, setPartidos] = useState<any[]>([]);

  useEffect(() => {
    partidoService.listarTodos().then(setPartidos);
  }, []);

  return (
    <div>
      <h2>Partidos Disponibles</h2>
      <ul>
        {partidos.map((p) => (
          <li key={p.id}>{p.deporte} - {p.ubicacion} - {p.estado?.nombre}</li>
        ))}
      </ul>
    </div>
  );
};

export default PartidoList;
