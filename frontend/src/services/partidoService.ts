import api from './api';

const partidoService = {
  crearPartido: (partido: any, usuarioId: number) =>
    api.post(`/partidos?usuarioId=${usuarioId}`, partido),
  listarTodos: () => api.get('/partidos').then(res => res.data),
  agregarJugador: (id: number, usuario: any) => api.post(`/partidos/${id}/agregar-jugador`, usuario),
};

export default partidoService;
