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
      <ul className="partido-list">
        {partidos.map((p) => (
          <li key={p.id} className="partido-item">
            <span>{p.deporte} - {p.ubicacion}</span>
            <span className="estado">{p.estado}</span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default PartidoList;
