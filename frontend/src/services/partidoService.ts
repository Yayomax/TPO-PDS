import api from './api';

const partidoService = {
  crearPartido: (partido: any) => {
    const userId = localStorage.getItem('userId');
    return api.post(`/partidos?usuarioId=${userId}`, partido);
  },
  listarTodos: () => api.get('/partidos').then(res => res.data),
  agregarJugador: (id: number, usuario: any) => api.post(`/partidos/${id}/agregar-jugador`, usuario),
  listarPorUsuario: (usuarioId: number) => api.get(`/partidos/usuario/${usuarioId}`).then(res => res.data),
  salirDePartido: (id: number, usuarioId: number) => api.post(`/partidos/${id}/salir?usuarioId=${usuarioId}`),
  cancelarPartido: (id: number, usuarioId: number) => api.post(`/partidos/${id}/cancelar?usuarioId=${usuarioId}`),
};

export default partidoService;
