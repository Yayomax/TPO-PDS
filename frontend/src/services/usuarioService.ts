import api from './api';

const usuarioService = {
  register: (usuario: any) => api.post('/auth/register', usuario),
  login: async (credenciales: any) => {
    const res = await api.post('/auth/login', credenciales);
    if (res.data.token) {
      localStorage.setItem('token', res.data.token);
    }
    return res.data;
  },
  listarTodos: () => api.get('/usuarios'),
};

export default usuarioService;
