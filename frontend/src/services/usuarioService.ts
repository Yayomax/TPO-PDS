import api from './api';

const usuarioService = {
  register: async (usuario: any) => {
    const res = await api.post('/auth/register', usuario);
    if (usuario && usuario.nombre) {
      localStorage.setItem('nombreUsuario', usuario.nombre);
    }
    return res;
  },
  login: async (credenciales: any) => {
    const res = await api.post('/auth/login', credenciales);
    if (res.data.token) {
      localStorage.setItem('token', res.data.token);
      if (res.data.usuario && res.data.usuario.id) {
        localStorage.setItem('userId', res.data.usuario.id.toString());
      }
      if (res.data.usuario && res.data.usuario.nombre) {
        localStorage.setItem('nombreUsuario', res.data.usuario.nombre);
      }
    }
    return res.data;
  },
  listarTodos: () => api.get('/usuarios'),
};

export default usuarioService;
