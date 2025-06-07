import api from './api';

const partidoService = {
  crearPartido: (partido: any) => api.post('/partidos', partido),
  listarTodos: () => api.get('/partidos').then(res => res.data),
  agregarJugador: (id: number, usuario: any) => api.post(`/partidos/${id}/agregar-jugador`, usuario),
};

export default partidoService;
